
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <title>Exercices</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <link rel="stylesheet" href="/bundles/tester/css/bootstrap.min.css" type="text/css" />
    <link rel="stylesheet" href="/bundles/tester/css/bootstrap-responsive.min.css" type="text/css" />
    <link rel="stylesheet" href="/bundles/tester/css/styles.css" type="text/css" />

    <script src="/bundles/tester/js/ace/ace.js" type="text/javascript" charset="utf-8"></script>

        

    <!--[if lt IE 9]>
      <script src="/bundles/tester/js/html5shiv.js"></script>
    <![endif]-->

    <script type="text/javascript">
      !function(){var analytics=window.analytics=window.analytics||[];if(analytics.invoked)window.console&&console.error&&console.error("Segment snippet included twice.");else{analytics.invoked=!0;analytics.methods=["trackSubmit","trackClick","trackLink","trackForm","pageview","identify","group","track","ready","alias","page","once","off","on"];analytics.factory=function(t){return function(){var e=Array.prototype.slice.call(arguments);e.unshift(t);analytics.push(e);return analytics}};for(var t=0;t<analytics.methods.length;t++){var e=analytics.methods[t];analytics[e]=analytics.factory(e)}analytics.load=function(t){var e=document.createElement("script");e.type="text/javascript";e.async=!0;e.src=("https:"===document.location.protocol?"https://":"http://")+"cdn.segment.com/analytics.js/v1/"+t+"/analytics.min.js";var n=document.getElementsByTagName("script")[0];n.parentNode.insertBefore(e,n)};analytics.SNIPPET_VERSION="3.0.0";
          analytics.load("mou95e6tdn");
          analytics.page()
      }}();
    </script>

  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">Exercices</a>
                            <ul class="nav nav-pills pull-right">
        <li><a href="https://vimeo.com/album/2826327/video/91864076" target="_blank"><i class="icon-white icon-question-sign"></i> Comment ça marche ?</a></li>
    </ul>
                  </div>
      </div>
    </div>

    <div class="container">
    	    <h1>Activité 2 - Gérez l’ajout de nouveaux liens</h1>

    <p><small>Temps d&#039;attente moyen pour être corrigé sur cet exercice : 1 jour</small></p>

    <p><a href="https://openclassrooms.com/courses/creez-des-pages-web-interactives-avec-javascript" class="btn btn-mini btn-inverse"><i class="icon-white icon-arrow-left"></i> Retour au cours</a></p>

    <div>
        <p>Cette deuxi&egrave;me activit&eacute; sera l&rsquo;occasion d&rsquo;enrichir l&rsquo;application de liens web cr&eacute;&eacute;e pr&eacute;c&eacute;demment.</p>
<p>Pour commencer, reprenez le code issu de votre activit&eacute; 1 ou de la correction-type que vous aviez t&eacute;l&eacute;charg&eacute;e pr&eacute;c&eacute;demment. La structure de l&rsquo;application reste la m&ecirc;me. Renommez uniquement le r&eacute;pertoire <strong>activite_1</strong> sous le nom <strong>activite_2</strong>. Vous devez obtenir l&rsquo;arborescence suivante.</p>
<p><img src="https://static.oc-static.com/prod/courses/files/creez-des-pages-web-interactives-avec-javascript/activite2_1.png" alt="" width="180" height="148" /></p>
<p>Votre travail consiste &agrave; int&eacute;grer &agrave; l&rsquo;application un formulaire permettant d&rsquo;ajouter un nouveau lien en saisissant ses informations (titre, URL et auteur).</p>
<p><img src="https://static.oc-static.com/prod/courses/files/creez-des-pages-web-interactives-avec-javascript/activite_2_demo.gif" alt="" width="600" height="348" /></p>
<p>Voici quelques consignes suppl&eacute;mentaires :</p>
<ul>
<li>Le formulaire appara&icirc;t lors du clic sur le bouton &ldquo;Ajouter un lien&rdquo;.</li>
<li>La saisie des champs Titre, URL et Auteur du lien est obligatoire.</li>
<li>Si l&rsquo;URL saisie ne commence ni par &ldquo;http://&rdquo; ni par &ldquo;https://&rdquo;, on lui ajoute &ldquo;http://&rdquo; au d&eacute;but.</li>
<li>Lorsque l&rsquo;utilisateur valide le nouveau lien, celui-ci est ajout&eacute; en haut de la page, le formulaire d&rsquo;ajout dispara&icirc;t et un message d&rsquo;information s&rsquo;affiche pendant 2 secondes.</li>
<li>Les variables JavaScript doivent respecter la norme camelCase et le fichier <strong>liensweb.js</strong> doit &ecirc;tre correctement indent&eacute;.</li>
</ul>
<p>Remarque : les liens n&rsquo;&eacute;tant pas sauvegard&eacute;s de mani&egrave;re persistante, le rechargement de la page web affiche uniquement les liens initiaux.</p>
<p>&nbsp;</p>
<p>Envoyez l&rsquo;activit&eacute; sous la forme d&rsquo;une archive zip contenant votre r&eacute;pertoire <strong>activite_2</strong>&nbsp;et tout son contenu.</p>
<p>Bon courage !</p>
    </div>

    <form action="/assessment/534?login=7866031&amp;tk=dcb45db5a1ec86b7c634413886b8a038&amp;sbd=2016-02-01&amp;sbdtk=2466d6bae51e373d89ac8e3f74213199" method="post" enctype="multipart/form-data">
        <fieldset>
            <legend>Sélection du travail</legend>
            <label>
                Votre travail (format <strong>.zip</strong>, 70 Mo max)<br />
                <input type="file" name="assessment" required />
                <span class="help-block">Comment créer un fichier ZIP sous <a href="https://vimeo.com/album/2826327/video/91856555" target="_blank">Windows</a> ? Sous <a href="https://vimeo.com/album/2826327/video/91856554" target="_blank">Mac OS X</a> ?</span>
            </label>
            <label>
                Vous pouvez laisser un mot à l&#039;attention de vos correcteurs si vous le souhaitez :<br />
                <textarea name="comment" placeholder="(facultatif)" rows="6" class="input-xlarge"></textarea>
            </label>
        </fieldset>


        <fieldset>
            <legend>Validation</legend>
            <p><span class="label label-warning">Attention</span> Relisez-vous bien ! Après soumission de votre travail, vous ne pourrez plus le modifier ni en renvoyer un nouveau !</p>
            <p class="text-center"><input type="submit" class="btn btn-primary" /></p>
        </fieldset>
    </form>
    </div>



    <script type="text/javascript" src="/bundles/tester/js/jquery.min.js"></script>
    <script type="text/javascript" src="/bundles/tester/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>



        <script>
        $('form').submit(function(event) {
            if (!confirm('Etes\x2Dvous\x20s\u00FBr\x20de\x20vouloir\x20valider\x20votre\x20travail\x20\x3F\x20L\x27enregistrement\x20est\x20d\u00E9finitif\x20et\x20vous\x20ne\x20pourrez\x20pas\x20renvoyer\x20votre\x20travail\x20\x21')) {
                event.preventDefault();
            }
        });
    </script>

            <script>
            analytics.identify('7866031', {}, {
                integrations: {
                    Intercom : {
                        user_hash : '687fdedd7974e2cc232d8be2f43ee978c8106097119502244b279134591432e9',
                    }
                }
            });
        </script>
    
  </body>
</html>
