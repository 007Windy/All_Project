using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace Utility.Security
{
    public class Encrypt
    {
        #region "MD5"

        private const int START = 8;
        private const int LENGTH = 16;
        public static string BuildPassword(string password)
        {
            if (string.IsNullOrEmpty(password))
                return password;
            MD5CryptoServiceProvider md5Provider = new MD5CryptoServiceProvider();
            return BitConverter.ToString(md5Provider.ComputeHash(Encoding.Default.GetBytes(password))).Replace("-", "").ToLower().Substring(START, LENGTH);

        }
        #endregion
    }
}
