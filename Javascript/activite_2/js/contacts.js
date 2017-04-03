/* 
Activité : gestion des contacts
*/

// TODO : complétez le programme

//Declaration de l'object Contact
var Contact = {
    // Initialise le personnage
    init: function (nom, prenom) {
        this.nom = nom;
        this.prenom = prenom;
    },
};

// Déclaration des variables
var contactList = [];
var contact1 = Object.create(Contact);
contact1.init("Carole", "Lévisse");
contactList.push(contact1);
var contact2 = Object.create(Contact);
contact2.init("Mélodie","Nelsonne");
contactList.push(contact2);
userAction ='';

while (true)
{
     //Affichage du menu
    console.log("1: Afficher tous vos contacts");
    console.log("2: Ajouter un contact");
    console.log("0: Quitter");
    userAction = prompt("Choissisez une option:");
   
    if (userAction === '1')
    {
        //Affichage du contenu de contactList
        console.log("Voici la liste de tous vos contacts:");
        for (i = 0; i < contactList.length; i++) { 
            console.log("Nom: " + contactList[i].nom +  ",  Prenom:" + contactList[i].prenom );   
        }
        console.log(" \n");
    }
    else if (userAction === '2')
    {
        //Ajout d'un nouveau contact
        var nouvContact = Object.create(Contact);
        nom = prompt("Entrez un nom:");
        prenom = prompt("Entrez un prenom:");
        nouvContact.init(nom,prenom);
        contactList.push(nouvContact);
        console.log("Un contact a été ajouter");
        console.log(" \n");
    }
    else if (userAction === '0')
    {
        //Sortie de la boucle => Sortie du programme
        break;
    }
}
