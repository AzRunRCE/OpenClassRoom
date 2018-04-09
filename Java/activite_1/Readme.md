
<!DOCTYPE html>
<html lang="fr">
    <h1>Instructions</h1>
    <div>
        <p>Bienvenue dans&nbsp;cette activit&eacute; de correction par les pairs.</p>
<p>Vous allez mettre en pratique une bonne partie de ce que vous avez appris dans la partie 1 et 2 de ce cours Java :</p>
<ul>
<li>cr&eacute;ation de classes;</li>
<li>h&eacute;ritage;</li>
<li>packages;</li>
<li>&eacute;num&eacute;ration;</li>
<li>g&eacute;n&eacute;rique;</li>
<li>fichiers.</li>
</ul>
<p><br />Voici un diagramme de classes vous repr&eacute;sentant l&rsquo;exercice :</p>
<p><a href="http://sdz-upload.s3.amazonaws.com/prod/upload/P2PA%20-%20Voiture.png"><img src="http://sdz-upload.s3.amazonaws.com/prod/upload/P2PA%20-%20Voiture.png" alt="Diagramme UML de l'exercice" width="878" height="440" /></a></p>
<p>Vous l&rsquo;aurez compris, vous allez devoir cr&eacute;er un garage, mais vous allez devoir aussi le sauvegarder dans un fichier&hellip; Le but &eacute;tant qu&rsquo;&agrave; chaque fois que vous ajoutez un nouveau v&eacute;hicule dans votre garage, celui-ci se sauvegarde automatiquement dans un fichier. Il faudra aussi automatiquement charger le garage lors de son instanciation.</p>
<p>&nbsp;</p>
<p>&Eacute;tant d&rsquo;un naturel magnanime, je vous donne une classe de test pour votre programme :</p>
<pre>public class Main {
    public static void main(String[] args) {
   	 Garage garage = new Garage();   
   	 System.out.println(garage);
   	 
   	 Vehicule lag1 = new Lagouna();
   	 lag1.setMoteur(new MoteurEssence("150 Chevaux", 10256d));
   	 lag1.addOption(new GPS());
   	 lag1.addOption(new SiegeChauffant());
   	 lag1.addOption(new VitreElectrique());
   	 garage.addVoiture(lag1);
   		 
   	 Vehicule A300B_2 = new A300B();
   	 A300B_2.setMoteur(new MoteurElectrique("1500 W", 1234d));
   	 A300B_2.addOption(new Climatisation());
   	 A300B_2.addOption(new BarreDeToit());
   	 A300B_2.addOption(new SiegeChauffant());
   	 garage.addVoiture(A300B_2);
   	 
   	 Vehicule d4_1 = new D4();
   	 d4_1.setMoteur(new MoteurDiesel("200 Hdi", 25684.80d));
   	 d4_1.addOption(new BarreDeToit());
   	 d4_1.addOption(new Climatisation());
   	 d4_1.addOption(new GPS());
   	 garage.addVoiture(d4_1);   	 
   	 
   	 Vehicule lag2 = new Lagouna();
   	 lag2.setMoteur(new MoteurDiesel("500 Hdi", 456987d));
   	 garage.addVoiture(lag2);
   	 
   	 Vehicule A300B_1 = new A300B();
   	 A300B_1.setMoteur(new MoteurHybride("ESSENCE/Electrique", 12345.95d));
   	 A300B_1.addOption(new VitreElectrique());
   	 A300B_1.addOption(new BarreDeToit());
   	 garage.addVoiture(A300B_1);
   	 
   	 Vehicule d4_2 = new D4();
   	 d4_2.setMoteur(new MoteurElectrique("100 KW", 1224d));
   	 d4_2.addOption(new SiegeChauffant());
   	 d4_2.addOption(new BarreDeToit());
   	 d4_2.addOption(new Climatisation());
   	 d4_2.addOption(new GPS());
   	 d4_2.addOption(new VitreElectrique());
   	 garage.addVoiture(d4_2);   			 
    }
}</pre>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>Et pour que vous ayez&nbsp;une id&eacute;e de ce que ce programme pourrait vous donner, voici deux screenshots, celui-ci&nbsp;lors du premier lancement de cette classe de test :</p>
<p><img src="http://sdz-upload.s3.amazonaws.com/prod/upload/CaptureEcran11.png" alt="Premier screenshot" width="363" height="116" /></p>
<p>&nbsp;</p>
<p>Et&nbsp;celui-l&agrave;&nbsp;apr&egrave;s le deuxi&egrave;me lancement (vous constaterez que mon garage n&rsquo;est plus vide &agrave; ce moment-l&agrave;) :</p>
<p><img src="http://sdz-upload.s3.amazonaws.com/prod/upload/CaptureEcran21.png" alt="Second screenshot" width="644" height="106" /></p>
<p>&nbsp;</p>
<p>C'est &agrave; vous !</p>
<p>&nbsp;</p>
    </div>



    
  </body>
</html>
