using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace Example
{
    class DB
    {
        
        MySqlConnection connection = new MySqlConnection("server=localhost;port=3306;username=root;password=;database=exampledb");
        public void OpenConnect()
        {
            if (connection.State == System.Data.ConnectionState.Closed)
                connection.Open();
        }
        public void CloseConnect()
        {
            if (connection.State == System.Data.ConnectionState.Open)
                connection.Close();
        }
        public void LoadData(ref ListExh list)
        {
            list.exhibitions.Clear();
            OpenConnect();
            string query = "SELECT * FROM `exhibitions`";
            MySqlCommand command = new MySqlCommand(query, GetConnection());
            MySqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                list.exhibitions.Add(new Exhibition(reader[1].ToString(), reader[2].ToString(), reader[3].ToString()));
            }
            reader.Close();
            CloseConnect();
        }
        public MySqlConnection GetConnection() => connection;
    }
}
