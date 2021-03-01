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
    public partial class MainMenuForm : Form
    {
        DB db;
        public MainMenuForm()
        {
            InitializeComponent();
            db = new DB();
        }

        private void ViewExh_Click(object sender, EventArgs e)
        {
            this.Hide();
            ViewExhibitions ve = new ViewExhibitions();
            ve.Show();
        }

        private void WorkWithExh_Click(object sender, EventArgs e)
        {
            this.Hide();
            WorkWithExhibitionsForm wwef = new WorkWithExhibitionsForm();
            wwef.Show();
        }

        private void ExitButton_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
