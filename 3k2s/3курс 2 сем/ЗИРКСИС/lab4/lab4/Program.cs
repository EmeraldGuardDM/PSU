using System;
using System.Net.NetworkInformation;
using System.Runtime.InteropServices;
using System.Windows.Forms;

namespace lab4
{
    class Program
    {
        [DllImport("user32.dll")]
        static extern bool ShowWindow(IntPtr hWnd, int nCmdShow);
        [DllImport("kernel32.dll")]
        static extern IntPtr GetConsoleWindow();
        static void Main(string[] args)
        {
            ShowWindow(GetConsoleWindow(), 0);
            
        bool isConnected = false;
            while (true)
            {
                NetworkInterface[] adapters = NetworkInterface.GetAllNetworkInterfaces();
                foreach(NetworkInterface myInt in adapters)
                {
                    if(myInt.NetworkInterfaceType == NetworkInterfaceType.Ethernet)
                    {
                        if (myInt.OperationalStatus == OperationalStatus.Up && !isConnected)
                        {
                            isConnected = true;
                            MessageBox.Show(String.Format("{2} connected!\nName: {0}\nDescription: {1}\n", myInt.Name, myInt.Description, myInt.NetworkInterfaceType.ToString()), "Внимание!!!!", MessageBoxButtons.OK);
                            //Console.WriteLine("{2} connected!\nName: {0}\nDescription: {1}\n", myInt.Name, myInt.Description, myInt.NetworkInterfaceType.ToString());
                        }
                        if(myInt.OperationalStatus == OperationalStatus.Down && isConnected)
                        {
                            isConnected = false;
                            MessageBox.Show(String.Format("{0} disconnect!\n", myInt.NetworkInterfaceType.ToString()), "Внимание!!!!", MessageBoxButtons.OK);
                           // Console.WriteLine("{0} disconnect!\n", myInt.NetworkInterfaceType.ToString());
                        }
                    }
                }
            }
        }
    }
}
