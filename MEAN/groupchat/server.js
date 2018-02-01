var express = require('express');
var bodyParser = require('body-parser');
var ejs = require('ejs');
var app = express();
app.use(bodyParser.urlencoded({extended: true}));
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

app.get('/', function(request, response){
    response.render('index');
})

var server = app.listen(8000, function(){
    console.log("Listening on port 8000!");
})
var io = require('socket.io').listen(server);
io.sockets.on('connection', function(socket){
    console.log("Client/socket is connected!");
    console.log("Client/socket id is: ", socket.id);
    socket.on('get_new_user', function(data){
        console.log("Received");
        console.log(data.name);
    })
})