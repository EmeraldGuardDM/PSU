using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Example.Forms
{
    public partial class EditForm : Form
    {
        DB db;
        public EditForm()
        {
            InitializeComponent();
            db = new DB();
        }



        private void EditButton_Click(object sender, EventArgs e)
        {
            if (Author.Text == "")
            {
                MessageBox.Show("Enter " + Author.Name.ToString() + " Field");
                return;
            }
            if (TypeTB.Text == "")
            {
                MessageBox.Show("Enter " + Author.Name.ToString() + " Field");
                return;
            }
            if (Genre.Text == "")
            {
                MessageBox.Show("Enter " + Author.Name.ToString() + " Field");
                return;
            }

            string query = "UPDATE `exhibitions` SET `author`=@author,`type`=@type,`genre`=@genre WHERE `author`=@id";
            MySqlCommand command = new MySqlCommand(query, db.GetConnection());

            command.Parameters.Add("@author", MySqlDbType.VarChar).Value = Author.Text;
            command.Parameters.Add("@type", MySqlDbType.VarChar).Value = TypeTB.Text;
            command.Parameters.Add("@genre", MySqlDbType.VarChar).Value = Genre.Text;
            command.Parameters.Add("@id", MySqlDbType.VarChar).Value = WorkWithExhibitionsForm.selected;
            db.OpenConnect();
            if (command.ExecuteNonQuery() == 1)
                MessageBox.Show("Was edited");
            else
                MessageBox.Show("Wasnt edited");

            db.CloseConnect();
            this.Hide();
        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
