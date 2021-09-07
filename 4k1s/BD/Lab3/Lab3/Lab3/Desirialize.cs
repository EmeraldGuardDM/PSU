﻿using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Lab3
{
    class Desirialize
    {
        public static List<Student> DeserializeBin(string path)
        {
            try
            {
                BinaryFormatter binaryFormatter = new BinaryFormatter();

                using (FileStream fileStream = new FileStream(path, FileMode.Open))
                {
                    return (List<Student>)binaryFormatter.Deserialize(fileStream);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Ошибка при чтении bin");
                return null;
            }
        }
        public static List<Student> DeserializeTxt(string path)
        {
            try
            {
                List<Student> students = new List<Student>();
                using (StreamReader sr = new StreamReader(path))
                {
                    int i = 0;
                    string[] fields = new string[5];
                    while (sr.Peek() >= 0)
                    {
                        fields[i] = sr.ReadLine();
                        if (i == 4)
                        {
                            students.Add(new Student(fields[0], fields[1], fields[2], fields[3], fields[4]));
                            i = 0;
                            continue;
                        }
                        i++;
                    }
                }
                return students;
            }
            catch (Exception ex)
            {
                MessageBox.Show("Ошибка при чтении txt");
                return null;
            }
        }
    }
}
