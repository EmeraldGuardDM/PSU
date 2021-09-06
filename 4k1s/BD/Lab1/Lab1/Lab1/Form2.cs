using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Lab1
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int num;
            if (int.TryParse(textBox1.Text, out num))
            {
                if (num <= 0)
                    MessageBox.Show("Введите положительное число!");
                else
                {
                    int result = 0;
                    for (int i = 1; i <= num; i++)
                    {
                        result += i;
                    }
                    textBox2.Text = result.ToString();
                }
            }
            else
                MessageBox.Show("Error");
        }
    }
}
