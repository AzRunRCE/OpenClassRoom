<!DOCTYPE html>
<!-- saved from url=(0066)http://exercices.openclassrooms.com/assessment/instructions/258554 -->
<html lang="fr"><head>

 
<h1>Activité 2 - Gérez l’ajout de nouveaux liens (AjaxGet / AjaxPost)</h1>
</head>
    
   

  <body>


        <p>Dans cette activité finale, vous allez utiliser un serveur web externe pour rendre votre application de liens web véritablement opérationnelle.</p>
<p>Pour commencer, reprenez le code issu de votre activité 2 ou de la correction-type que vous aviez téléchargée précédemment. La structure de l’application reste la même. Renommez uniquement le répertoire <strong>activite_2</strong> sous le nom <strong>activite_3</strong>. Vous devez obtenir l’arborescence suivante.</p>
<p><img src="https://static.oc-static.com/prod/courses/files/creez-des-pages-web-interactives-avec-javascript/activite3_1.png" alt="" width="181" height="147"></p>
<p>Votre travail consiste à connecter l’application au serveur <a href="https://oc-jswebsrv.herokuapp.com/">https://oc-jswebsrv.herokuapp.com</a> pour récupérer les derniers liens publiés et ajouter un nouveau lien.</p>
<p>L’API de récupération des liens est <a href="https://oc-jswebsrv.herokuapp.com/api/liens">https://oc-jswebsrv.herokuapp.com/api/liens</a>. Elle renvoie les derniers liens ajoutés sous forme de tableau JSON.</p>
<p>L’API d’ajout d’un lien est <a href="https://oc-jswebsrv.herokuapp.com/api/lien">https://oc-jswebsrv.herokuapp.com/api/lien</a>. Elle attend un objet JSON représentant un lien.</p>
<p>&nbsp;</p>
<p><strong>Attention :&nbsp;<a href="https://oc-jswebsrv.herokuapp.com/api/lien">https://oc-jswebsrv.herokuapp.com/api/lien</a>&nbsp;</strong><strong>sert à publier un lien et n’accepte que le protocole HTTP POST. L’URL pour récupérer la liste des liens est <a href="https://oc-jswebsrv.herokuapp.com/api/liens">https://oc-jswebsrv.herokuapp.com/api/liens</a>.</strong></p>
<p>&nbsp;</p>
<p>Voici le format JSON d’un lien.</p>
<pre>{<br>
  “titre”: “titre du lien”,<br>
  “url”: “URL du lien”,<br>
  “auteur”: “auteur du lien”<br>
}</pre>
<p><img src="https://static.oc-static.com/prod/courses/files/creez-des-pages-web-interactives-avec-javascript/activite_3_demo.gif" alt="" width="600" height="348"></p>
<p>Voici quelques consignes supplémentaires :</p>
<ul>
<li>Les liens affichés sont récupérés depuis le serveur.</li>
<li>Le nouveau lien n’est affiché sur la page qu’en cas de succès de l’ajout sur le serveur.</li>
<li>Le formulaire d’ajout est remplacé par le bouton “Ajouter un lien” quel que soit le résultat de l’ajout sur le serveur.</li>
<li>Contrairement à l’activité 2, le rechargement de la page web affiche toujours le nouveau lien puisque celui-ci est sauvegardé sur le serveur.</li>
<li>Les communications avec le serveur utilisent les fonctions <strong>ajaxGet</strong> et <strong>ajaxPost</strong> définies dans le cours.</li>
<li>Les variables JavaScript doivent respecter la norme camelCase et le fichier <strong>liensweb.js</strong> doit être correctement indenté.</li>


</body>
</html>
