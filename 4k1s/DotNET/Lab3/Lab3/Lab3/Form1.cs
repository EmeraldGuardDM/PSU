using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Lab3
{
    public partial class Form1 : Form
    {
        public List<Country> Countries { get; set; }
        List<Country> countries;
        public Form1()
        {
            InitializeComponent();
            countries = new List<Country>();
        }
        private void ClearFields()
        {
            textBoxName.Text = "";
            textBoxCapital.Text = "";
            textBoxArea.Text = "";
            textBoxPopulationSize.Text = "";
        }

        private void UpdateDataGrid()
        {
            dataGridView1.DataSource = null;
            dataGridView1.DataSource = countries;
            dataGridView1.Refresh();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void buttonAdd_Click(object sender, EventArgs e)
        {
            string[] fields =
            {
                textBoxName.Text,
                textBoxCapital.Text,
                textBoxArea.Text,
                textBoxPopulationSize.Text
            };

            bool isCorrect = true;
            foreach (var field in fields)
            {
                if (field == "")
                {
                    MessageBox.Show("Заполните все поля для добавления");
                    isCorrect = false;
                    break;
                }
            }

            if (isCorrect)
            {
                countries.Add(new Country(textBoxName.Text, textBoxCapital.Text, Convert.ToInt32(textBoxArea.Text), Convert.ToInt32(textBoxPopulationSize.Text)));

                UpdateDataGrid();
                ClearFields();
            }
        }

        private void buttonDelete_Click(object sender, EventArgs e)
        {
            DialogResult dialogResult = MessageBox.Show("Вы действительно хотите удалить удалить этот объект?", "Delete", MessageBoxButtons.YesNo);
            if (dialogResult == DialogResult.Yes)
            {
                if (dataGridView1.SelectedRows.Count > 0)
                {
                    try
                    {
                        int ind = dataGridView1.SelectedCells[0].RowIndex;
                        countries.RemoveAt(ind);
                        UpdateDataGrid();
                    }
                    catch (Exception ex)
                    {
                        MessageBox.Show(ex.Message);
                    }
                }
                else
                    MessageBox.Show("Список пуст");
            }

        }

        private void buttonShow_Click(object sender, EventArgs e)
        {
            try
            {
                var selectedCountry = dataGridView1.SelectedRows[0].DataBoundItem as Country;
                MessageBox.Show("Name :\t" + selectedCountry.Name.ToString() + "\n" +
                                "Capital :\t" + selectedCountry.Capital.ToString() + "\n" +
                                "Area :\t" + selectedCountry.Area.ToString() + "\n" +
                                "Population size :\t" + selectedCountry.PopulationSize.ToString());
            }
            catch(Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
    }
}
