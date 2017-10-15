<strong>Todolist partagée en temps réel !</strong>
<h2>Votre mission</h2>
<p>Vous allez reprendre le <a href="http://fr.openclassrooms.com/informatique/cours/des-applications-ultra-rapides-avec-node-js/tp-la-todo-list" target="_blank">projet de Todolist</a>&nbsp;que nous avions créée, et vous allez l'améliorer pour faire en sorte qu'elle puisse être utilisée par plusieurs personnes en même temps à l'aide de <strong>socket.io</strong>. Voici les fonctionnalités attendues :</p>
<ul>
<li>Quand un client se connecte, il récupère la dernière Todolist connue du serveur</li>
<li>Quand un client ajoute une tâche, celle-ci est immédiatement répercutée chez&nbsp;les autres clients</li>
<li>Quand un client supprime une tâche, celle-ci est immédiatement supprimée chez les autres clients</li>
</ul>
<p>Le serveur pourra retenir la Todolist sous le forme d'un simple array qu'il gardera en mémoire. La persistence n'est pas demandée (inutile d'utiliser MySQL ou Mongodb ;o).</p>
<p>L'utilisation d'Express.js est recommandée mais n'est pas obligatoire.</p>
