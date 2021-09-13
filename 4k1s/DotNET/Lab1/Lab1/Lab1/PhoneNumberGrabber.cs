using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;

namespace Lab1
{
    class PhoneNumberGrabber
    {
        private string text { get; set; }
        private Regex regex;
        List<string> list = new List<string>();

        public PhoneNumberGrabber(string str)
        {
            text = str;
            regex = new Regex(@"(?<!(\d|\d[ -]))[1-9][ -]?\d[ -]?\d[ -]?\d[ -]?\d[ -]?\d[ -]?\d(?!(\d|[ -]\d))");
        }

        public string[] GetPhoneNumbers()
        {
            var matches = regex.Matches(text);

            foreach (var match in matches)
            {
                string str = match.ToString();
                list.Add(str);
            }

            return list.ToArray();
        }
    }

    
}
