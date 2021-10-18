using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Utility.Security
{
    public class RandomNum
    {
        /// <summary>
        /// 返回随机数
        /// </summary>
        /// <param name="VcodeNum"></param>
        /// <returns></returns>
        public string RndNum(int VcodeNum)
        {
            string Vchar = "0,1,2,3,4,5,6,7,8,9";

            string[] VcArray = Vchar.Split(',');
            string VNum = "";//由于字符串很短，就不用StringBuilder了
            int temp = -1;//记录上次随机数值，尽量避免生产几个一样的随机数

            //采用一个简单的算法以保证生成随机数的不同
            Random rand = new Random();
            for (int i = 1; i < VcodeNum + 1; i++)
            {
                if (temp != -1)
                {
                    rand = new Random(i * temp * unchecked((int)DateTime.Now.Ticks));
                }
                //int t =  rand.Next(35) ;
                int t = rand.Next(9);
                if (temp != -1 && temp == t)
                {
                    return RndNum(VcodeNum);
                }
                temp = t;
                VNum += VcArray[t];

            }
            return VNum;
        }
    }
}
