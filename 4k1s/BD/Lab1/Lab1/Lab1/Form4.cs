using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Lab1
{
    public partial class Form4 : Form
    {
        public Form4()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            double num;
            double num2;
            double result;
            if((double.TryParse(textBox1.Text, out num)) && (double.TryParse(textBox2.Text, out num2)))
            {
                if (num > 0 && num2 > 0)
                {
                    result = num * num2;
                    textBox3.Text = result.ToString();
                }
                else
                    MessageBox.Show("Некоректные данные");
            }
            else
                MessageBox.Show("Error");
        }
    }
}
