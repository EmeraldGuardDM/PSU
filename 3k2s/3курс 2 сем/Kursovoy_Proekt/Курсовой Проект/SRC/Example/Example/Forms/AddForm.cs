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

namespace Example
{
    public partial class AddForm : Form
    {
        DB db;
        public AddForm()
        {
            InitializeComponent();
            db = new DB();
        }

        private void AddButton_Click(object sender, EventArgs e)
        {
            if(Author.Text == "")
            {
                MessageBox.Show("Enter "+Author.Name.ToString()+" Field");
                return;
            }
            if (Type.Text == "")
            {
                MessageBox.Show("Enter " + Author.Name.ToString() + " Field");
                return;
            }
            if (Genre.Text == "")
            {
                MessageBox.Show("Enter " + Author.Name.ToString() + " Field");
                return;
            }
            if (CheckUser())
                return;

            string query = "INSERT INTO `exhibitions` (`author`,`type`,`genre`) VALUES (@author,@type,@genre)";
            MySqlCommand command = new MySqlCommand(query, db.GetConnection());

            command.Parameters.Add("@author", MySqlDbType.VarChar).Value = Author.Text;
            command.Parameters.Add("@type", MySqlDbType.VarChar).Value = Type.Text;
            command.Parameters.Add("@genre", MySqlDbType.VarChar).Value = Genre.Text;

            db.OpenConnect();
            if (command.ExecuteNonQuery() == 1)
                MessageBox.Show("Was created");
            else
                MessageBox.Show("Wasnt created");

            db.CloseConnect();
            this.Hide();
            
        }

        public bool CheckUser()
        {
            DataTable userTable = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter();

            string query = "SELECT * FROM `exhibitions` WHERE `author` = @Author";
            MySqlCommand command = new MySqlCommand(query, db.GetConnection());
            command.Parameters.Add("@Author", MySqlDbType.VarChar).Value = Author.Text;

            adapter.SelectCommand = command;
            adapter.Fill(userTable);

            if (userTable.Rows.Count > 0)
            {
                MessageBox.Show("Db has same author, enter another author");
                return true;
            }
            else
                return false;
        }

    }
}
