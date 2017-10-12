<!DOCTYPE html>
<html lang="fr">
<head>
<h1>Instructions</h1>
<body>      
<p>L&rsquo;application devra permettre la manipulation d&rsquo;un ensemble d&rsquo;utilisateurs et de pouvoir modifier les donn&eacute;es de ces derniers. La grande diff&eacute;rence avec notre pr&eacute;c&eacute;dente r&eacute;alisation est que l&rsquo;agencement des &eacute;l&eacute;ments dans notre application sera dynamique.</p>
<p>En effet, votre application doit proposer 3 agencements diff&eacute;rents&nbsp;:</p>
<ul>
<li>Vue de la liste des utilisateurs&nbsp;:<em><br /> </em></li>
</ul>
<p><em><img src="https://static.oc-static.com/prod/courses/files/creez-votre-premiere-application-connectee-en-c-net/acti4_image1.png" alt="Vue Liste Utilisateurs" width="422" height="324" /></em></p>
<ul>
<li>Vue de la liste des utilisateurs et du premier niveau de d&eacute;tail de l&rsquo;utilisateur s&eacute;lectionn&eacute;&nbsp;:</li>
</ul>
<p><img src="https://static.oc-static.com/prod/courses/files/creez-votre-premiere-application-connectee-en-c-net/acti4_image2.png" alt="liste utilisateurs et premier niveau" width="422" height="324" /></p>
<ul>
<li>Vue de la liste des utilisateurs, du premier niveau de d&eacute;tail de l&rsquo;utilisateur s&eacute;lectionn&eacute; ainsi que de son deuxi&egrave;me niveau de d&eacute;tail (ici son adresse)&nbsp;:<em><br /> </em></li>
</ul>
<p><em><img src="https://static.oc-static.com/prod/courses/files/creez-votre-premiere-application-connectee-en-c-net/acti4_image3.png" alt="liste utilisateurs premier et deuxi&egrave;me niveaux" width="439" height="337" /></em></p>
<p>Le passage d&rsquo;un agencement &agrave; un autre doit se faire &agrave; l&rsquo;aide des deux barres horizontales et verticales mises en surbrillance ci-dessous&nbsp;:</p>
<p><img src="https://static.oc-static.com/prod/courses/files/creez-votre-premiere-application-connectee-en-c-net/acti4_image4.png" alt="passage agencement" width="439" height="341" /></p>
<p>Les fonctionnalit&eacute;s traditionnelles d&rsquo;ajout, de suppression et de remise &agrave; z&eacute;ro d&rsquo;un utilisateur doivent &ecirc;tre pr&eacute;sentes.</p>
<p>La s&eacute;lection d&rsquo;un utilisateur dans la liste doit imm&eacute;diatement mettre &agrave; jour les deux panneaux de d&eacute;tails s&rsquo;ils sont ouverts (ne plus utiliser un bouton sp&eacute;cifique comme dans l&rsquo;exercice pr&eacute;c&eacute;dent)&nbsp;:</p>
<p><img src="https://static.oc-static.com/prod/courses/files/creez-votre-premiere-application-connectee-en-c-net/acti4_image5.png" alt="s&eacute;lection utilisateur" width="446" height="342" />&nbsp;&nbsp;</p>
<p><img src="https://static.oc-static.com/prod/courses/files/creez-votre-premiere-application-connectee-en-c-net/acti4_image6.png" alt="passage 2" width="441" height="340" /></p>
<p>Les modifications sur les param&egrave;tres d&rsquo;un utilisateur doivent &ecirc;tre persistantes tout au long de la dur&eacute;e de lancement du programme.</p>
<p>L&rsquo;application doit &ecirc;tre robuste au changement de taille, les textes ne doivent pas &ecirc;tre coup&eacute;s&nbsp;dans la mesure du possible :</p>
<p><img src="https://static.oc-static.com/prod/courses/files/creez-votre-premiere-application-connectee-en-c-net/acti4_image7.png" alt="rue" width="482" height="317" /></p>
<p>Concernant l&rsquo;architecture de votre projet et code source, il devra &ecirc;tre clairement identifi&eacute; ce qui rel&egrave;ve de la vue, du vue-mod&egrave;le, et du mod&egrave;le&nbsp;:</p>
<p><em><img src="https://static.oc-static.com/prod/courses/files/creez-votre-premiere-application-connectee-en-c-net/acti4_image8.png" alt="architecture" width="347" height="226" /></em></p>
<p>&nbsp;</p>
<p>Votre code devra &ecirc;tre propre, concis, et respecter les notions vues pr&eacute;c&eacute;demment &agrave; savoir&nbsp;:</p>
<ul>
<li>La vue n&rsquo;interagit avec le vue mod&egrave;le que via Databinding sur ce dernier et invocation de Commandes.</li>
<li>Le vue mod&egrave;le ne fait pas r&eacute;f&eacute;rence &agrave; la vue.</li>
<li>Le mod&egrave;le ne fait r&eacute;f&eacute;rence ni &agrave; la vue, ni au vue mod&egrave;le.</li>
</ul>
  </body>
</html>
