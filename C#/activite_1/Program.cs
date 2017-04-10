using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpActivité2TirageDeLoto
{
    class Program
    {
        static bool isPresent(int find,int[] tab)
        {        
            for (int i = 0; i < tab.Length; i++)
            {
                if (tab[i] == find)
                    return true;
            }
            return false;
        }

        static void ShowNumber( int[] tab)
        {
            for (int i = 0; i < tab.Length; i++)
                Console.WriteLine(tab[i]);
            
        }

        static void Main(string[] args)
        {

    //#1   
            int[] tab = new int[] { 0, 0, 0, 0, 0, 0, 0 };

    //#2
            for (int i = 0; i < tab.Length; i++)
            {
                Random rnd = new Random();
                int x = rnd.Next(1, 49);
                while (isPresent(x,tab))
                  x =  rnd.Next(1, 49);
                tab[i] = x;
            }
    //#3
            ShowNumber(tab);
            Console.ReadKey();
        }
    }
}
