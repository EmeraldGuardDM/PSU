using System;
using System.Collections.Generic;
using System.Text;

namespace Lab3
{
    public class Country
    {
        public string Name { get; set; }
        public string Capital { get; set; }
        public int Area { get; set; }
        public int PopulationSize { get; set; }

        public Country(string name, string capital, int area, int populationSize)
        {
            this.Name = name;
            this.Capital = capital;
            this.Area = area;
            this.PopulationSize = populationSize;
        }
    }
}
