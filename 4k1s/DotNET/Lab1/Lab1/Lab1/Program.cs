using System;
using System.Text;

namespace Lab1
{
    class Program
    {
        static void Main(string[] args)
        {
            secondTask();
        }

        static void firstTask()
        {
            Console.WriteLine("Введите количество столбцов : ");
            int column = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Введите количество строк : ");
            int row = Convert.ToInt32(Console.ReadLine());

            int[,] array = new int[row, column];

            Random random = new Random();
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < column; j++)
                {
                    array[i, j] = random.Next(10);
                    Console.Write(array[i, j] + "\t");
                }
                Console.WriteLine();

            }

            int minI = 0;
            int minJ = 0;
            int minNumber = array[0, 0];
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < column; j++)
                {
                    if(minNumber > array[i, j])
                    {
                        minNumber = array[i, j];
                        minI = i + 1;
                        minJ = j + 1;
                    }
                }
            }

            Console.WriteLine("Минимальное число : " + minNumber);
            Console.WriteLine("Номер строки : " + minI);
            Console.WriteLine("Номер столбца : " + minJ);
        }

        static void secondTask()
        {
            Console.WriteLine("Введите предложение : ");
            string str = Console.ReadLine();
            Console.WriteLine("Введите длину слова : ");
            int lenght = Convert.ToInt32(Console.ReadLine());

            var sb = new StringBuilder();
            foreach(char c in str)
            {
                if (!char.IsPunctuation(c))
                    sb.Append(c);
            }

            str = sb.ToString();

            string[] words = str.Split(' ');
            Array.Sort(words);
            foreach(string w in words)
            {
                if (w.Length == lenght)
                {
                    Console.WriteLine(w);
                }
            }

        }

        static void thirdTask()
        {

        }
    }
}
