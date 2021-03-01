using Example.Forms;
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
    public partial class WorkWithExhibitionsForm : Form
    {
        DB db;
        ListExh list;
        DataGridView dataGridExh;
        public static string selected; 
        public WorkWithExhibitionsForm()
        {
            InitializeComponent();
            db = new DB();
            list = new ListExh();
            dataGridExh = dataExh;
            db.LoadData(ref list);
            ReloadData(ref list);
        }

        private void AddButton_Click(object sender, EventArgs e)
        {
            var addedBox = new AddForm();
            addedBox.ShowDialog();

        }

        private void BackButton_Click(object sender, EventArgs e)
        {
            this.Hide();
            MainMenuForm mmf = new MainMenuForm();
            mmf.Show();
        }
        private void ReloadData(ref ListExh list)
        {
            for (var i = 0; i < list.exhibitions.Count; i++)
                dataExh.Rows.Add(list.exhibitions[i].Author, list.exhibitions[i].Type, list.exhibitions[i].Genre);
        }

        private void UpdateButton_Click(object sender, EventArgs e)
        {
            dataExh.Rows.Clear();
            db.LoadData(ref list);
            ReloadData(ref list);
        }

        private void EditButton_Click(object sender, EventArgs e)
        {
            selected = dataGridExh.CurrentCell.Value.ToString();
            if (MessageBox.Show("Do you want to edit this ", "Editing", MessageBoxButtons.YesNo,
                MessageBoxIcon.Question, MessageBoxDefaultButton.Button2) == DialogResult.Yes)
            {
                var editBox = new EditForm();
                editBox.ShowDialog();
            }
        }

        private void RemoveButton_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Do you want to remove this ", "Removing", MessageBoxButtons.YesNo,
               MessageBoxIcon.Question, MessageBoxDefaultButton.Button2) == DialogResult.Yes)
            {
                int selectedId = dataGridExh.CurrentCell.RowIndex;
                string selected = dataGridExh.CurrentCell.Value.ToString();
                string query = "DELETE FROM `exhibitions` WHERE `author` = @author";
                MySqlCommand command = new MySqlCommand(query, db.GetConnection());
                command.Parameters.Add("@author", MySqlDbType.VarChar).Value = selected;
                //command.Parameters.RemoveAt(selectedId);
                db.OpenConnect();
                if (command.ExecuteNonQuery() == 1)
                    MessageBox.Show("Was deleted");
                else
                    MessageBox.Show("Wasnt deleted");
                db.CloseConnect();
            }
        }
    }
}
