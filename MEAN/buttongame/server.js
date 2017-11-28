var express = require('express');
var bodyParser = require('body-parser');
var ejs = require('ejs');
var path = require('path');
var app = express();
app.use(bodyParser.urlencoded({extended: true}));
app.set('views', path.join(__dirname, "/views"));
app.set('view engine', 'ejs');
app.get('/', function(request, response){
    response.render('index', {title: "Button Game"});
})
var server = app.listen(8000, function(){
    console.log("Listening on port 8000");
});
var io = require('socket.io').listen(server);
io.sockets.on('connection', function (socket){
    console.log("Client/socket is connected!");
    console.log("Client/socket id is: ", socket.id);
})