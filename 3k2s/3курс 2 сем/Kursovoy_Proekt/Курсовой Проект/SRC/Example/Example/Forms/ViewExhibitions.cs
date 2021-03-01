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
    delegate void senderData(ListExh list);
    public partial class ViewExhibitions : Form
    {
        DB db;
        ListExh list;
        public ViewExhibitions()
        {
            InitializeComponent();
            db = new DB();
            list = new ListExh();
            db.LoadData(ref list);
            ReloadData(ref list);
        }

        private void BackButton_Click(object sender, EventArgs e)
        {
            this.Hide();
            MainMenuForm mmf = new MainMenuForm();
            mmf.Show();
        }

        private void ReloadData(ref ListExh list)
        {
            for (var i = 0; i <list.exhibitions.Count; i++)
                dataExhibitions.Rows.Add(list.exhibitions[i].Author, list.exhibitions[i].Type, list.exhibitions[i].Genre);
        }
    }
}
