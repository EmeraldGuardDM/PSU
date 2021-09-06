using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Lab1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int num;
            if (int.TryParse(textBox1.Text, out num))
            {
                int number = 5;
                if (num == number)
                    textBox2.Text = "Угадал";
                else
                    textBox2.Text = "Не угадал";
            }
            else
                MessageBox.Show("Error");
        }
    }
}
