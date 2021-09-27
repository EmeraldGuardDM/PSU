using System;
using System.Collections.Generic;
using System.Text;

namespace Lab2
{
    abstract class Place
    {
        public string Name { get; set; }

        private int area;
        public int Area
        {
            get { return area; }
            set
            {
                if (value <= 0)
                    throw new PersonException("Площадь не может быть меньше или равна 0", value);
                else
                    area = value;
            }
        }

        public Place(string name)
        {
            Name = name;
        }

        public Place(string name, int area)
        {
            Name = name;
            Area = area;
        }

        public abstract void Display();

    }

    public interface IPlace 
    {
        public void AllInfo();
    }

    class Country : Place, IPlace
    {
        public string Continent { get; set; }
        public string FormOfGovernment { get; set; }

        public Country(string name, string continent) 
            : base(name)
        {
            Continent = continent;
        }

        public Country(string name, int area, string continent, string formOfGoverment)
            : base(name, area)
        {
            Continent = continent;
            FormOfGovernment = formOfGoverment;
        }

        public override void Display()
        {
            Console.WriteLine($"{Name} находится на континенте {Continent}");
        }

        public void AllInfo()
        {
            Console.WriteLine($"Name : {Name} \t Area : {Area} \t Continent : {Continent} \t Form of goverment : {FormOfGovernment}\n");
        }
    }

    class City : Place, IPlace
    {
        public string Country { get; set; }

        public City(string name, string country) 
            : base(name)
        {
            Country = country;
        }

        public City(string name, int area, string country)
            : base(name, area)
        {
            Country = country;
        }

        public override void Display()
        {
            Console.WriteLine($"{Name} находится в госудрастве {Country}");
        }

        public void AllInfo()
        {
            Console.WriteLine($"Name : {Name} \t Area : {Area} \t Country : {Country}");
        }
    }

    class PersonException : ArgumentException
    {
        public int Value { get; }
        public PersonException(string message, int val)
            : base(message)
        {
            Value = val;
        }
    }
}
