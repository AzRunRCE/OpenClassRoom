/* 
Activité 1
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


for (var i = 0; i < listeLiens.length; i++) {

    var lienElt = document.createElement("ul");
    lienElt.classList.add("lien");

    var titleLink = document.createElement("a");
    titleLink.href = listeLiens[i].url;
    titleLink.innerText =  listeLiens[i].titre;
    titleLink.style.color = "#428bca";
    titleLink.style.fontWeight = "bold";
    titleLink.style.textDecoration = "none";

    var span = document.createElement("span");
    span.innerText = "Ajouté par " + listeLiens[i].auteur;

    var spanUrl = document.createElement("span");
    spanUrl.innerText = " " + listeLiens[i].url;
    
    lienElt.appendChild(titleLink);
    lienElt.appendChild(spanUrl);
    lienElt.appendChild( document.createElement("br"));     // Ajoute une balise <br>
    lienElt.appendChild(span);       // Ajoute une balise <span>

    document.getElementById("contenu").appendChild(lienElt); // Ajoute a la div contenu
    
}
// TODO : compléter ce fichier pour ajouter les liens à la page web