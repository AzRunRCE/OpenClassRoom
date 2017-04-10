Je vous demande en particulier de réaliser ces 3 améliorations sur le TP (vous serez noté là-dessus) :

Faites un compteur de « coups ». Ce compteur devra être une variable que vous incrémenterez à chaque fois que vous passez dans la boucle. Lorsque l'utilisateur a trouvé le nombre mystère, vous lui direz « Bravo, vous avez trouvé le nombre mystère en 8 coups » par exemple.

Lorsque l'utilisateur a trouvé le nombre mystère, le programme s'arrête. Demandez si le joueur veut faire une autre partie !

Il vous faudra faire une boucle qui englobera la quasi-totalité de votre programme. Cette boucle devra se répéter TANT QUE l'utilisateur n'a pas demandé à arrêter le programme. Je vous conseille de rajouter une variable booléenne du type continuerPartie initialisée à 1 au départ. Si l'utilisateur demande à arrêter le programme, vous mettrez la variable à 0 et le programme s'arrêtera.

Créez plusieurs niveaux de difficulté. Au début, faites un menu qui demande le niveau de difficulté. Par exemple :

1 = entre 1 et 100 ;

2 = entre 1 et 1000 ;

3 = entre 1 et 10000.

Si vous faites ça, vous devrez changer votre constante MAX… Eh oui, ça ne peut plus être une constante si la valeur doit changer au cours du programme ! Renommez par exemple cette variable en nombreMaximum (vous prendrez soin d'enlever le mot-clé const sinon ça sera toujours une constante !). La valeur de cette variable dépendra du niveau qu'on aura choisi.

Vous pouvez sans problème partir du code de base fourni en solution dans le chapitre.

Ce que vous devez rendre
Vous devez créer un fichier .c contenant votre code. Seul ce fichier est obligatoire. Compressez-le dans un .zip et envoyez ce .zip dans le formulaire qui suit !