using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace Lab1
{
    public partial class Form6 : Form
    {
        public Form6()
        {
            InitializeComponent();
        }

        private void Form6_Load(object sender, EventArgs e)
        {

        }

        private void button23_Click(object sender, EventArgs e)
        {
            textBox1.Text += "0";
        }

        private void button18_Click(object sender, EventArgs e)
        {
            textBox1.Text += "1";
        }

        private void button19_Click(object sender, EventArgs e)
        {
            textBox1.Text += "2";
        }

        private void button20_Click(object sender, EventArgs e)
        {
            textBox1.Text += "3";
        }

        private void button13_Click(object sender, EventArgs e)
        {
            textBox1.Text += "4";
        }

        private void button14_Click(object sender, EventArgs e)
        {
            textBox1.Text += "5";
        }

        private void button15_Click(object sender, EventArgs e)
        {
            textBox1.Text += "6";
        }

        private void button8_Click(object sender, EventArgs e)
        {
            textBox1.Text += "7";
        }

        private void button9_Click(object sender, EventArgs e)
        {
            textBox1.Text += "8";
        }

        private void button10_Click(object sender, EventArgs e)
        {
            textBox1.Text += "9";
        }

        private void button12_Click(object sender, EventArgs e)
        {
            double number = double.Parse(textBox1.Text);
            number = Math.Sqrt(number);
            textBox1.Text = number.ToString();
        }

        private void button17_Click(object sender, EventArgs e)
        {

        }

        private void button22_Click(object sender, EventArgs e)
        {
            double number = double.Parse(textBox1.Text);
            number = 1 / number;
            textBox1.Text = number.ToString();
        }

        double firstNumber;
        int operation;

        private void button26_Click(object sender, EventArgs e)
        {
            firstNumber = double.Parse(textBox1.Text);
            textBox1.Text = "";
            operation = 1;
        }

        private void button21_Click(object sender, EventArgs e)
        {
            firstNumber = double.Parse(textBox1.Text);
            textBox1.Text = "";
            operation = 2;
        }

        private void button16_Click(object sender, EventArgs e)
        {
            firstNumber = double.Parse(textBox1.Text);
            textBox1.Text = "";
            operation = 3;
        }

        private void button11_Click(object sender, EventArgs e)
        {
            firstNumber = double.Parse(textBox1.Text);
            textBox1.Text = "";
            operation = 4;
        }

        public void Calculate()
        {
            switch (operation)
            {
                case 1:
                    firstNumber += double.Parse(textBox1.Text);
                    break;
                case 2:
                    firstNumber -= double.Parse(textBox1.Text);
                    break;
                case 3:
                    firstNumber *= double.Parse(textBox1.Text);
                    break;
                case 4:
                    firstNumber /= double.Parse(textBox1.Text);
                    break;
            }

            textBox1.Text = firstNumber.ToString();
        }

        private void button27_Click(object sender, EventArgs e)
        {
            Calculate();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            textBox1.Text = textBox1.Text.Substring(0, textBox1.Text.Length - 1);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";
        }

        private void button24_Click(object sender, EventArgs e)
        {
            double number = double.Parse(textBox1.Text);
            number *= -1;
            textBox1.Text = number.ToString();
        }

        private void button25_Click(object sender, EventArgs e)
        {
            textBox1.Text += ",";
        }
    }
}
