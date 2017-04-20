#include <iostream>
#include <fstream>
#include <string>
#include <ctime>
#include <cstdlib>

using namespace std;


string obtenirMotAleatoire(string dicoPath)
{
     //Initialisation des variables
    ifstream monFlux(dicoPath.c_str());  //Ouverture d'un fichier en lecture
    string word;
    int i = 0, countWord = 0, position = 0;

    if(!monFlux)  //Verification de l'ouverture
    {
        cout << "ERREUR: Impossible d'ouvrir le fichier en lecture." << endl;
        return NULL;
    } 

    while(getline(monFlux, word)) //Tant qu'on n'est pas à la fin, on lit
        countWord++;  
        
    position = rand() % countWord;  //Modulo sur random pour obtenir une ligne compris entre 0 et le MAX
    monFlux.clear(); //On reset le EOF
    monFlux.seekg(0, ios::beg); //On se replace au début du fichier
    for(i= 0; i < position; i++) //Tant qu'on n'est pas a la position, on lit
        getline(monFlux, word);

    return word;
}

string melangerLettres(string mot)
{
   string melange;
   int position(0);

   //Tant qu'on n'a pas extrait toutes les lettres du mot
   while (mot.size() != 0)
   {
      //On choisit un numéro de lettre au hasard dans le mot
      position = rand() % mot.size();
      //On ajoute la lettre dans le mot mélangé
      melange += mot[position];
      //On retire cette lettre du mot mystère
      //Pour ne pas la prendre une deuxième fois
        mot.erase(position, 1);
    }

   //On renvoie le mot mélangé
   return melange;
}
int main()
{
   string motMystere, motMelange, motUtilisateur, continuer, mode;
   int const NbrEssaiDefaut = 5;
   string fileName = "dico.txt";
   int essaiRestant;
    do 
    {

        //Initialisation des nombres aléatoires
        srand(time(0)); 
        essaiRestant = NbrEssaiDefaut;

        //0 : On demande de saisir un mode
        cout << "Saisissez un mode de generation \n 1) Utilisateur \n 2) Dictionnaire" << endl;
        cin >> mode;
        if (mode == "1"){ 
            //1 : On demande de saisir un mot
            cout << "Saisissez un mot" << endl;
            cin >> motMystere;
         }  
         else //1 : Sinon on le génére
            motMystere = obtenirMotAleatoire(fileName);
        //2 : On récupère le mot avec les lettres mélangées dans motMelange
        motMelange = melangerLettres(motMystere);
        continuer = "o";
        //3 : On demande à l'utilisateur quel est le mot mystère
        do
        {
            cout  << "Il vous reste " << essaiRestant << " essais." << endl; //On informe l'utilisateur
            cout  << "Quel est ce mot ? " << motMelange << endl;   
            cin >> motUtilisateur;
            essaiRestant--; //On décremente après la saisie d'une reponse
            if (motUtilisateur != motMystere) //On compare la saisie utilisateur
                cout << "Ce n'est pas le mot !" << endl; //On informe l'utilisateur du resultat de sa saisie

        }while (motUtilisateur != motMystere && essaiRestant > 0); 
        //On recommence tant qu'il n'a pas trouvé
        if (motUtilisateur != motMystere)  //On affiche un message suivant le resultat
            cout << "Vous avez perdu " << "le mot etait: " << motMystere << endl; //On informe l'utilisateur
        else
            cout << "Bravo ! Vous avez gagne en " << NbrEssaiDefaut - essaiRestant <<  " essais." << endl; //On informe l'utilisateur
        cout << "Voulez-vous refaire une partie ? o/n" << endl;  //On demande s'il veut continuer a joué
        cin >> continuer;
        
    }while (continuer == "O" || continuer == "o" );
   //On recommence tant qu'il veut joué
    return 0;
}