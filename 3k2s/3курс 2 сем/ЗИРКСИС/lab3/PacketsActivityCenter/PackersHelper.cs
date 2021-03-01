using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using PacketDotNet;
using SharpPcap;

namespace Lab3
{
    public class PacketActivity
    {
        public string Ip;
        public List<int> PortsList;
    }

    class PackersHelper
    {
        private const int PanicPacketsCount = 20;

        private readonly UpdatePacketDelegate _updatePacketDelegate;
        private readonly UpdateBlacklistDelegate _updateBlacklistDelegate;
        private ICaptureDevice _captureDevice;
        private readonly List<PacketActivity> _packetActivities = new List<PacketActivity>(); //содержит ип адресс и порт

        public delegate void UpdatePacketDelegate(PacketInfo packetInfo);
        public delegate void UpdateBlacklistDelegate(BlacklistInfo blacklistInfo);

        public PackersHelper(UpdatePacketDelegate updatePacketDelegate, UpdateBlacklistDelegate updateBlacklistDelegate)
        {
            _updatePacketDelegate += updatePacketDelegate;
            _updateBlacklistDelegate += updateBlacklistDelegate;
        }

        private void OnPacketArrival(object sender, CaptureEventArgs e)
        {
            Packet packet = Packet.ParsePacket(e.Packet.LinkLayerType, e.Packet.Data);
            TcpPacket tcpPacket = (TcpPacket) packet.Extract(typeof(TcpPacket));
            IpPacket ipPacket = (IpPacket) packet.Extract(typeof(IpPacket));

            if (tcpPacket != null && ipPacket != null)
            {
                PacketInfo packetInfo = new PacketInfo()
                {
                    SourceIp = ipPacket.SourceAddress.ToString(),
                    SourcePort = tcpPacket.SourcePort.ToString(),
                    DestinationIp = ipPacket.DestinationAddress.ToString(),
                    DestinationPort = tcpPacket.DestinationPort.ToString(),
                    Length = e.Packet.Data.Length.ToString(),
                    Time = e.Packet.Timeval.Date.ToString(CultureInfo.InvariantCulture)
                };

                _updatePacketDelegate.BeginInvoke(packetInfo, null, null);

                AddPacketActivity(packetInfo);
            }
        }

        private void AddPacketActivity(PacketInfo packetInfo)
        {
            if (_packetActivities.Select(packet => packet.Ip).ToList().Contains(packetInfo.SourceIp)) //Преобразует каждый элемент списка к новому виду и проверяет содержит ли конечный список ip адр из полученной переменной
            {
                foreach (var packet in _packetActivities) //проходим по списку пакетов _packetActivities
                {
                    if (packet.Ip.Equals(packetInfo.SourceIp))//Проверяем равенство ип из списка и полученного ип 
                    {
                        if (!packet.PortsList.Contains(Convert.ToInt32(packetInfo.SourcePort))) //Если в списке портов нету порта на который пришел пакет
                        {
                            packet.PortsList.Add(Convert.ToInt32(packetInfo.SourcePort)); //добавляем порт в список портов

                            if (packet.PortsList.Count == PanicPacketsCount) //Если в списке портов > панического  числа, то заносим ип в черный список
                            {
                                _updateBlacklistDelegate.BeginInvoke(new BlacklistInfo() { BlacklistIp = packet.Ip }, null, null);//обновляем lisview
                            }
                        }
                        break;
                    }
                }
            }
            else
            {
                _packetActivities.Add(new PacketActivity() { Ip = packetInfo.SourceIp, PortsList = new List<int>()} ); //если не содержит, то добавляем в список
            }
        }

        public void StopCapture()
        {
            _captureDevice.StopCapture();//Останавливаем просмотр пакетов
        }

        public void ChangeNetworkDevice(int index)
        {
            if (_captureDevice != null)
            {
                StopCapture();
                _captureDevice.OnPacketArrival -= OnPacketArrival;
            }
            _captureDevice = CaptureDeviceList.Instance[index];
            _captureDevice.OnPacketArrival += OnPacketArrival;
            _captureDevice.Open(DeviceMode.Promiscuous, 1000);
            _captureDevice.StartCapture();
        }
    }
}
