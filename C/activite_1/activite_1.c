#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main ( int argc, char** argv )
{
    //Déclaration des variables
    int nombreMystere = 0, nombreEntre = 0,level = 0;
    int MAX = 100, MIN = 1;
    int nbEssai = 0;
    int continuerPartie = 1;
    do {
        srand(time(NULL));
        //Demande le niveau a l'utlisateur
        printf("1 = entre 1 et 100\n2 = entre 1 et 1000\n3 = entre 1 et 10000\nSaissisez un niveau: ");
        scanf("%d", &level);
        if (level == 1)
            MAX = 100;
        else if  (level == 2)
            MAX = 1000;
        else if  (level == 3)
            MAX = 10000;         
        else
            MAX = 100;
        nombreMystere = (rand() % (MAX - MIN + 1)) + MIN;
        // Boucle du jeu
        while (nombreEntre != nombreMystere)
        {
            printf("Quel est le nombre ? ");
            scanf("%d", &nombreEntre);
            if (nombreMystere > nombreEntre)
            {
                printf("C'est plus !\n\n");  
                nbEssai++;
            }  
            else if (nombreMystere < nombreEntre)
            {
                printf("C'est moins !\n\n");
                nbEssai++;
            }    
            else
                printf ("Bravo, vous avez trouve le nombre mystere en %d coup(s) !!!\n\n",nbEssai);
        }
        //Demande a l'utilisateur s'il souhaite continuer a jouer
        printf("Voulez-vous continué a jouer ?\n1:Oui\n0:Non\n");
        scanf("%d", &continuerPartie); 
    }while(continuerPartie); //Check de la variable continuerPartie 
    return 0;
}