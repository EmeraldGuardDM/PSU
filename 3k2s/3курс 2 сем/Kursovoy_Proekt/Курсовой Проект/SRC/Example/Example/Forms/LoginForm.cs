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
    public partial class LoginForm : Form
    {
        DB db;
        public LoginForm()
        {
            InitializeComponent();
            db = new DB();
        }

        private void LoginButton_Click(object sender, EventArgs e)
        {
            string login = loginField.Text;
            string password = passwordField.Text;

            DataTable userTable = new DataTable();
            MySqlDataAdapter adapter = new MySqlDataAdapter();

            string query = "SELECT * FROM `users` WHERE `login` = @login AND `password` = @password ";
            MySqlCommand command = new MySqlCommand(query,db.GetConnection());
            command.Parameters.Add("@login", MySqlDbType.VarChar).Value = login;
            command.Parameters.Add("@password", MySqlDbType.VarChar).Value = password;

            adapter.SelectCommand = command;
            adapter.Fill(userTable);

            if (userTable.Rows.Count > 0)
            {
                MessageBox.Show("Success!Authorization");
                this.Hide();
                MainMenuForm menu = new MainMenuForm();
                menu.Show();
            }
            else
                MessageBox.Show("No");
        }

        private void passwordField_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
