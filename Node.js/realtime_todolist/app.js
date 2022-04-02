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
    app.render('todo.ejs',  { teamData : "test" }, function (err, html) {
		console.warn(html);
	})
})


server.listen(8080);   
