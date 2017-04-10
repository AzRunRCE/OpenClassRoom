using System;

namespace p1_activite_base
{
    internal class Program
    {
        private static readonly Random random = new Random();

        private static void Main(string[] args)
        {
            while (true)
            {
                AfficheMenu();
                var consoleKeyInfo = Console.ReadKey(true);
                while (consoleKeyInfo.Key != ConsoleKey.D1 && consoleKeyInfo.Key != ConsoleKey.D2 &&
                       consoleKeyInfo.Key != ConsoleKey.NumPad1 && consoleKeyInfo.Key != ConsoleKey.NumPad2)
                {
                    AfficheMenu();
                    consoleKeyInfo = Console.ReadKey(true);
                }
                if (consoleKeyInfo.Key == ConsoleKey.D1 || consoleKeyInfo.Key == ConsoleKey.NumPad1)
                    Jeu1();
                else
                    Jeu2();

                Console.ReadKey();
            }
           
           
        }

        private static void AfficheMenu()
        {
            Console.Clear();
            Console.WriteLine("Veuillez choisir votre mode de jeu :");
            Console.WriteLine("\t1 : Contre les monstres");
            Console.WriteLine("\t2 : Contre le boss de fin");
        }

        private static void Jeu1()
        {
            var nicolas = new Joueur(150);
            var cptFacile = 0;
            var cptDifficile = 0;
            while (nicolas.EstVivant)
            {
                var monstre = FabriqueDeMonstre();
                while (monstre.EstVivant && nicolas.EstVivant)
                {
                    nicolas.Attaque(monstre);
                    if (monstre.EstVivant)
                        monstre.Attaque(nicolas);
                }

                if (nicolas.EstVivant)
                {
                    if (monstre is MonstreDifficile)
                        cptDifficile++;
                    else
                        cptFacile++;
                }
                else
                {
                    Console.WriteLine("Snif, vous êtes mort...");
                    break;
                }
            }
            Console.WriteLine(
                "Bravo !!! Vous avez tué {0} monstres faciles et {1} monstres difficiles. Vous avez {2} points.",
                cptFacile, cptDifficile, cptFacile + cptDifficile * 2);
        }

        private static MonstreFacile FabriqueDeMonstre()
        {
            if (random.Next(2) == 0)
                return new MonstreFacile();
            return new MonstreDifficile();
        }


        private static void Jeu2()
        {
            var nicolas = new Joueur(150);
            var boss = new BossDeFin(250);
            while (nicolas.EstVivant && boss.EstVivant)
            {
                nicolas.Attaque(boss);
                if (boss.EstVivant)
                    boss.Attaque(nicolas);
            }
            if (nicolas.EstVivant)
                Console.WriteLine("Bravo, vous avez sauvé la princesse (ou le prince !)");
            else
                Console.WriteLine("Game over...");
        }
    }

    public static class De
    {
        private static readonly Random random = new Random();

        public static int LanceLeDe()
        {
            return random.Next(1, 7);
        }

        public static int LanceLeDe(int valeur)
        {
            return random.Next(1, valeur);
        }
    }

    public class MonstreFacile : Personnage
    {
        private const int degats = 10;

        public MonstreFacile()
        {
            EstVivant = true;
        }

        public bool EstVivant { get; private set; }

        public override void Attaque(Personnage joueur)
        {
            var lanceMonstre = LanceLeDe();
            var lanceJoueur = joueur.LanceLeDe();
            if (lanceMonstre > lanceJoueur)
                joueur.SubitDegats(degats);
        }

        public override void SubitDegats(int i)
        {
            EstVivant = false;
        }
       
    }

    public class MonstreDifficile : MonstreFacile
    {
        private const int degatsSort = 5;

        public override void Attaque(Personnage joueur)
        {
            base.Attaque(joueur);
            joueur.SubitDegats(SortMagique());
        }

        private int SortMagique()
        {
            var valeur = De.LanceLeDe();
            if (valeur == 6)
                return 0;
            return degatsSort * valeur;
        }
    }

    public class Joueur : PersonnageAPointsDeVie
    {
        public Joueur(int points)
        {
            PtsDeVies = points;
        }
        public override void Attaque(Personnage personnage)
        {
            var lanceJoueur = LanceLeDe();
            var lanceMonstre = personnage.LanceLeDe();
            if (lanceJoueur >= lanceMonstre)
                personnage.SubitDegats(lanceJoueur);
        }

        public void Attaque(BossDeFin personnage)
        {
            int nbPoints = LanceLeDe(26);
            personnage.SubitDegats(nbPoints);
        }
        public override void SubitDegats(int degats)
        {
            if (!BouclierFonctionne())
                PtsDeVies -= degats;
        }

        private bool BouclierFonctionne()
        {
            return De.LanceLeDe() <= 2;
        }
    }

    public class BossDeFin : PersonnageAPointsDeVie
    {

        public BossDeFin(int points)
        {
            PtsDeVies = points;
        }
        public override void Attaque(Personnage personnage)
        {
            var nbPoints = LanceLeDe(26);
            personnage.SubitDegats(nbPoints);
        }
    }

    public abstract class Personnage
    {
        public virtual bool EstVivant { get; protected set; }
        public abstract void Attaque(Personnage perso);
        public abstract void SubitDegats(int degats);
        public int LanceLeDe()
        {
            return De.LanceLeDe();
        }
    }

    public abstract class PersonnageAPointsDeVie : Personnage
    {
        public int PtsDeVies { get; protected set; }

        public override bool EstVivant
        {
            get { return PtsDeVies > 0; }
        }
        public override void SubitDegats(int valeur)
        {
            PtsDeVies -= valeur;
        }

        public int LanceLeDe(int i)
        {
            return De.LanceLeDe(i);
        }
    }
}