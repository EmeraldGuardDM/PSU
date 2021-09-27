using System;
using System.Collections.Generic;
using System.Text;

namespace Lab2
{
    abstract class Place
    {
        public string Name { get; set; }

        public int Area { get; set; }

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

        public override void AllInfo()
        {
            Console.WriteLine($"{Name} находится на континенте {Continent}");
        }
    }

    class City : Place
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
    }
}
