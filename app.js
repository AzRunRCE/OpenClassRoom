var express = require('express');
var app = express();
var server = require('http').createServer(app);  
// Chargement de socket.io
var io = require('socket.io')(server);
var todolist = [];

io.sockets.on('connection', function (socket) {
	
	/* Retourne la collection d'item (todolist) */
	socket.emit('connectionCallback', JSON.stringify(todolist));
	
	/* Ajoute et signal l'ajout d'un item */
    socket.on('addItem', function (message) {
		var msg = JSON.parse(message);
		var newItem = {id: todolist.length, text: msg.text};
		console.log('New to do item: ' + JSON.stringify(newItem));
		socket.broadcast.emit('addItemEvent', JSON.stringify(newItem));
		socket.emit('addItemEvent', JSON.stringify(newItem));
		todolist.push(newItem);
    }); 
	/* Supprime et signal la suppression d'un item */
	socket.on('removeItem', function (message) {
		var itm = JSON.parse(message);
		console.log('Remove to do item: ' + message);
		socket.broadcast.emit('removeItemEvent', message);
		socket.emit('removeItemEvent', message);
		todolist.splice(itm.id, 1);
    }); 
});

app.use(function(req, res, next){
    next();
})

/* On affiche la todolist et le formulaire */
app.get('/', function(req, res) { 
    res.render('todo.ejs', getAudioFromTeam(req.query.name));
})

function getRandomInt(max) {
	return Math.floor(Math.random() * max);
  }

function getAudioFromTeam(name){
	var photoIndex = getRandomInt(5);
	switch(name){
		case "OSS117":
			return { teamName:"OSS117" ,name: name, photo: photoIndex }
		case "LesInconnus":
			return { teamName:"Les Inconnus",name: name , photo: photoIndex }
		case "Asterix":
			return { teamName:"Asterix",name: name, photo: photoIndex }
		case "Gargamel":
			return { teamName:"Gargamel" ,name: name , photo: photoIndex }
		case "Noel": 
			return { teamName:"Le Père Noël" ,name: name, photo: photoIndex }
		case "Jacquouille":
			return { teamName:"Jacquouille",name: name , photo: photoIndex }
		case "SouthPark":
			return { teamName:"South Park",name: name , photo: photoIndex }
		case "LePlaignant":	
			return { teamName:"Le Plaignant",name: name, photo: photoIndex }
		case "Admin":
			return { teamName:"Admin"}
		default:
			return  { teamName:"OSS117",name: name }
	}
}

app.use(express.static('ressources'));
server.listen(8080,'0.0.0.0');   
