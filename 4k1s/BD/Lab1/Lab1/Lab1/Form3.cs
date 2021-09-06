using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Lab1
{
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int num;
            if (int.TryParse(textBox1.Text, out num))
            {
                num = Math.Abs(num);
                textBox2.Text = num.ToString();
            }
            else
                MessageBox.Show("Error");
        }

        private void button5_Click(object sender, EventArgs e)
        {
            double num;
            if (double.TryParse(textBox1.Text, out num))
            {
                num = Math.Sqrt(num);
                textBox2.Text = num.ToString();
            }
            else
                MessageBox.Show("Error");
        }

        private void button4_Click(object sender, EventArgs e)
        {
            int num;
            if (int.TryParse(textBox1.Text, out num))
            {
                num *= -1;
                textBox2.Text = num.ToString();
            }
            else
                MessageBox.Show("Error");
        }
    }
}
