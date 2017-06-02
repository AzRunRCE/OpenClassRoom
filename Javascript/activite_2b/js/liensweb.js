/* 
Activité 2
*/

// Liste des liens Web à afficher. Un lien est défini par :
// - son titre
// - son URL
// - son auteur (la personne qui l'a publié)
var listeLiens = [
    {
        titre: "So Foot",
        url: "http://sofoot.com",
        auteur: "yann.usaille"
    },
    {
        titre: "Guide d'autodéfense numérique",
        url: "http://guide.boum.org",
        auteur: "paulochon"
    },
    {
        titre: "L'encyclopédie en ligne Wikipedia",
        url: "http://Wikipedia.org",
        auteur: "annie.zette"
    }
];

//Déclarations et ajouts des elements

var contenu = document.getElementById("contenu");
var button = document.createElement("button");
button.textContent = "Ajouter un lien";
button.id ="add";
button.addEventListener("click",showInput);

var authorInput = document.createElement("input");
authorInput.type = "text";
authorInput.style.display = "none";
authorInput.id = "author";
authorInput.size="30"
authorInput.placeholder = "Entrez votre nom";
authorInput.required = true;

var titleInput = document.createElement("input");
titleInput.type = "text";
titleInput.style.display = "none";
titleInput.id = "title";
titleInput.size="50"
titleInput.placeholder = "Entrez le titre du lien";
titleInput.required = true;

var urlInput = document.createElement("input");
urlInput.type = "text";
urlInput.style.display = "none";
urlInput.id = "url";
urlInput.size="50"
urlInput.placeholder = "Entrez l'URL du lien";
urlInput.required = true;

contenu.parentNode.insertBefore(button, contenu);
contenu.parentNode.insertBefore(document.createElement("br"),contenu);
contenu.parentNode.insertBefore(document.createElement("br"),contenu);
button.parentNode.insertBefore(authorInput, button);
button.parentNode.insertBefore(titleInput, button);
button.parentNode.insertBefore(urlInput, button);

listeLiens.forEach(function (lien) {
    var elementLien = creerElementLien(lien);
    contenu.appendChild(elementLien);
});

var authorInput = document.getElementById("author");
var titleInput = document.getElementById("title");
var urlInput = document.getElementById("url");
var button = document.getElementById("add");

// Méthode: Création d'un élément (param: lien) 

function creerElementLien(lien) {
    var titreLien = document.createElement("a");
    titreLien.href = lien.url;
    titreLien.style.color = "#428bca";
    titreLien.style.textDecoration = "none";
    titreLien.style.marginRight = "5px";
    titreLien.appendChild(document.createTextNode(lien.titre));

    var urlLien = document.createElement("span");
    urlLien.appendChild(document.createTextNode(lien.url));

    var ligneTitre = document.createElement("h4");
    ligneTitre.style.margin = "0px";
    ligneTitre.appendChild(titreLien);
    ligneTitre.appendChild(urlLien);

    var ligneDetails = document.createElement("span");
    ligneDetails.appendChild(document.createTextNode("Ajouté par " + lien.auteur));

    var divLien = document.createElement("div");
    divLien.classList.add("lien");
    divLien.appendChild(ligneTitre);
    divLien.appendChild(ligneDetails);

    return divLien;
}

//Méthode permettant la création de la notification (param: msg)

function creerNotif(msg) {

    var ligneTitre = document.createElement("h4");
    ligneTitre.style.margin = "0px";
    ligneTitre.innerText = msg.text;
    ligneTitre.style.color = "#0B4C5F";

    var divNotif = document.createElement("div");
    divNotif.classList.add("lien");
    divNotif.style.background = "#CEE3F6";
    divNotif.appendChild(ligneTitre);
    var ligneDetails = document.createElement("span");
    
    divNotif.appendChild(ligneDetails);
    
    return divNotif;
}

//Methode: Affiche les champs texte

function showInput()
{
    authorInput.style.display = "inline-block";
    authorInput.style.marginRight = "5px";

    titleInput.style.display = "inline-block";
    titleInput.style.marginRight = "5px";

    urlInput.style.display = "inline-block";
    urlInput.style.marginRight = "5px";

    button.textContent = "Ajouter";
    button.addEventListener("click",addLink);

}

//Methode: Réinitialise les champs texte

function resetFields()
{
    button.textContent = "Ajouter un lien";
    button.addEventListener("click",showInput);

    authorInput.value = "" 
    authorInput.style.display = "none";

    titleInput.value = "" 
    titleInput.style.display = "none";

    urlInput.value = ""
    urlInput.style.display = "none";
}

//Methode: Ajout du lien a la liste avec contrôle d'entrée
        // Notification
        // Réinitialisation

function addLink()
{
    if (authorInput.value == "" && titleInput.value == ""  && urlInput.value == "")
    {
        return;
    }

    var pattern = /^((http|https):\/\/)/;
    if(!pattern.test(urlInput.value)) {
        urlInput.value = "http://" + urlInput.value;
    }
    var lien = {
        titre: titleInput.value ,
        url: urlInput.value ,
        auteur: authorInput.value
    };

    var elementLien = creerElementLien(lien);
    contenu.insertAdjacentElement("afterBegin",elementLien);
    var msg = {text :'Le  lien "' + titleInput.value + '" a bien été ajouté.',};
    var notif = creerNotif(msg);
    button.parentNode.insertBefore(notif, button);
    setTimeout(function () {   notif.remove();  },2500);
    resetFields();
}



