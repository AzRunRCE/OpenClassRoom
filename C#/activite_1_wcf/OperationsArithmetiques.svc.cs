using System;
using System.Data;

namespace OC_Calculus_WCFService
{
    public class OperationsArithmetiques : IOperationsArithmetiques
    {
        /// <summary>
        /// Renvoie la transformation d'une chaine de caractères , -> .
        /// </summary>
        /// <param name="chaine"></param>
        /// <returns></returns>
        private string ClearExpression(string chaine)
        {
            return chaine.Replace(",", ".");
        }
        /// <summary>
        /// Renvoie le resultat d'une expression mathématique passée en entrée.
        /// </summary>
        /// <param name="chaine"></param>
        /// <returns></returns>
        private double Evaluate(string chaine)
        { 
            if (string.IsNullOrEmpty(chaine) || string.IsNullOrWhiteSpace(chaine))
                return 0;
            chaine = ClearExpression(chaine);
            DataTable table = new DataTable();
            table.Columns.Add("chaine", typeof(string), chaine);
            DataRow row = table.NewRow();
            table.Rows.Add(row);
            return double.Parse((string)row["chaine"]);
        }
        
        /// <summary>
        /// Renvoie la somme des deux paramètres de type double passés en entrée.
        /// </summary>
        /// <param name="nb1"></param>
        /// <param name="nb2"></param>
        /// <returns></returns>
        public double Plus(double nb1, double nb2)
        {
            return nb1 + nb2;
        }
        
        /// <summary>
        /// Renvoie la différence des deux paramètres de type double passés en entrée.
        /// </summary>
        /// <param name="nb1"></param>
        /// <param name="nb2"></param>
        /// <returns></returns>
        public double Moins(double nb1, double nb2)
        {
            return nb1 - nb2;
        }
        
        /// <summary>
        /// Renvoie le résultat de la division du premier paramètre de type double par le second paramètre de type double.
        /// </summary>
        /// <param name="nb1"></param>
        /// <param name="nb2"></param>
        /// <returns></returns>
        public double Diviser(double nb1, double nb2)
        {
            return nb1 / nb2;
        }
        
        /// <summary>
        /// Renvoie le résultat de la multiplication du premier paramètre de type double par le second paramètre de type double.
        /// </summary>
        /// <param name="nb1"></param>
        /// <param name="nb2"></param>
        /// <returns></returns>
        public double Multiplier(double nb1, double nb2)
        {
            return nb1 * nb2;
        }
        
        /// <summary>
        /// Renvoie vrai si le premier paramètre de type entier positif est un multiple du second paramètre de type entier positif, sinon renvoie faux.
        /// </summary>
        /// <param name="nb1"></param>
        /// <param name="nb2"></param>
        /// <returns></returns>
        public bool EstMultipleDe(int nb1, int nb2)
        {
            return nb1 % nb2 == 0;
        }
        
        /// <summary>
        /// Renvoie le résultat du calcul passé en paramètre sous forme de chaine de caractères ne pouvant contenir que des nombres entiers positifs ainsi que des signes + (non consécutifs) et ne commençant pas par +. 
        /// </summary>
        /// <param name="chaine"></param>
        /// <returns></returns>
        public int ChaineDAdditionsEntieres(string chaine)
        {
            return Convert.ToInt32(Evaluate(chaine));
        }

        /// <summary>
        /// Renvoie le résultat du calcul passé en paramètre sous forme de chaine de caractères ne pouvant contenir que des nombres de type double positifs ainsi que le signe +.
        /// </summary>
        /// <param name="chaine"></param>
        /// <returns></returns>
        public double ChaineDAdditionsReelles(string chaine)
        {  
            return Evaluate(chaine);
        }

        /// <summary>
        /// Renvoie le résultat du calcul passé en paramètre sous forme de chaine de caractères ne pouvant contenir que des nombres entiers positifs ou négatifs ainsi que les signes + et – (non consécutifs) et ne commençant pas par +.
        /// </summary>
        /// <param name="chaine"></param>
        /// <returns></returns>
        public int ChaineDAdditionsEtDeSoustractionsEntieres(string chaine)
        {          
            return Convert.ToInt32(Evaluate(chaine));
        }
     
        /// <summary>
        /// Renvoie le résultat du calcul passé en paramètre sous forme de chaine de caractères ne pouvant contenir que des nombres réels positifs ou négatifs ainsi que les signes + et – (non consécutifs)
        /// </summary>
        /// <param name="chaine"></param>
        /// <returns></returns>
        public double ChaineDAdditionsEtDeSoustractionsReelles(string chaine)
        { 
            return Evaluate(chaine);
        }

        /// <summary>
        /// Renvoie le résultat du calcul passé en paramètre sous forme de chaine de caractères ne pouvant contenir que des nombres entiers positifs ou négatifs ainsi que les signes +, –, * (non consécutifs à l’exception de *- pour représenter la multiplication par un nombre négatif) et ne commençant pas par + ni *.
        /// </summary>
        /// <param name="chaine"></param>
        /// <returns></returns>
        public int ChaineDAdditionsEtSoustractionsEtMultiplicationsEntieres(string chaine)
        {
            return Convert.ToInt32(Evaluate(chaine));
        }
    }
}