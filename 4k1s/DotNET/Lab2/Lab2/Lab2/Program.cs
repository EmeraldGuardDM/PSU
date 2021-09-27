using System;

namespace Lab2
{
    class Program
    {
        static void Main(string[] args)
        {
            Country belarus = new Country("Belarus", 123, "Europe", "President");
            belarus.Display();
            belarus.AllInfo();

            try
            {
                City moskow = new City("Moskow", -2, "Russia");
                moskow.AllInfo();
            }
            catch (PersonException ex)
            {
                Console.WriteLine($"Ошибка: {ex.Message}");
                Console.WriteLine($"Некорректное значение: {ex.Value}");
            }
        }
    }
}
