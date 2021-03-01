using System.Diagnostics;
using System.Linq;
using System.Management;
using System.Threading;
using System.Windows.Forms;

namespace Lab4
{
    public static class Program
    {
        static void Main(string[] args)
        {
            FindExecutedBatchFile();
        }

        private static void FindExecutedBatchFile()
        {
            while (true)
            {
                foreach (var process in Process.GetProcessesByName("cmd"))
                {
                    try
                    {
                        using (var searcher = new ManagementObjectSearcher("SELECT CommandLine FROM Win32_Process WHERE ProcessId = " + process.Id))
                        {
                            var commandLine = searcher.Get().Cast<ManagementBaseObject>().Aggregate(string.Empty, (current, @object) => current + (@object["CommandLine"] + " "));

                            if (commandLine.Contains(".bat"))
                            {
                                MessageBox.Show("Аномальная активность хоста! " + commandLine);
                            }
                        }
                    }
                    catch
                    {
                        // ignored
                    }
                }

                Thread.Sleep(10);
            }
        }
    }
}
