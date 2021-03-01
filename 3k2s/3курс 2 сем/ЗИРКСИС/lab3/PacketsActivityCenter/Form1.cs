using System;
using System.Windows.Forms;
using SharpPcap;

namespace Lab3
{
    public partial class Form1 : Form
    {
        private PackersHelper _packersHelper;

        public Form1()
        {
            InitializeComponent();
            InitializePacketsHelper();
        }

        public void InitializePacketsHelper()
        {
            _packersHelper = new PackersHelper(UpdatePacketListview, UpdateBlacklistListview);

            foreach (var device in CaptureDeviceList.Instance)
            {
                comboBox1.Items.Add(device.Description);
            }

            comboBox1.SelectedIndex = 0;
        }

        public void UpdatePacketListview(PacketInfo packetInfo)
        {
            string[] row = {
                packetInfo.SourceIp,
                packetInfo.SourcePort,
                packetInfo.DestinationIp,
                packetInfo.DestinationPort,
                packetInfo.Length,
                packetInfo.Time
            };

            ListViewItem listViewItem = new ListViewItem(row);

            if (listView1.InvokeRequired)
            {
                try
                {
                    listView1.Invoke(new MethodInvoker(delegate { listView1.Items.Add(listViewItem); }));
                }
                catch
                {
                    // ignored
                }
            }
        }

        public void UpdateBlacklistListview(BlacklistInfo blacklistInfo)
        {
            string[] row = {
                blacklistInfo.BlacklistIp,
            };

            ListViewItem listViewItem = new ListViewItem(row);

            if (listView2.InvokeRequired)
            {
                listView2.Invoke(new MethodInvoker(delegate { listView2.Items.Add(listViewItem); }));
            }
        }

        private void Form1_FormClosed(object sender, FormClosedEventArgs e)
        {
            _packersHelper.StopCapture();
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            _packersHelper.ChangeNetworkDevice(comboBox1.SelectedIndex);
        }
    }
}
