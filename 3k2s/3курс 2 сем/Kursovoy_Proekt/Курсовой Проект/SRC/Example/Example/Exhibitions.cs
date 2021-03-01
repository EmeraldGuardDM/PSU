using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Example
{
    class Exhibition
    {
        public string Author { get; set; }
        public string Type { get; set; }
        public string Genre { get; set; }        
        public Exhibition(string Author,string Type,string Genre)
        {
            this.Author = Author;
            this.Type = Type;
            this.Genre = Genre;
        }
    }
}
