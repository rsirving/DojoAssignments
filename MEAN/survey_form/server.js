var express = require('express');
var bodyParser = require('body-parser');
var ejs = require('ejs');
var app = express();
app.use(bodyParser.urlencoded({extended: true}));
app.set('views', __dirname + "/views");
app.set('view engine', 'ejs');
app.get('/', function(request, response){
    response.render('index', {title: "Survey Form"});
})
app.post('/results', function(request, response){
    console.log("POST DATA \n\n", request.body)
    response.render('results', {title: "Results", name: request.body.name, location: request.body.location, language: request.body.language, comment: request.body.comment});
})
var server = app.listen(8000, function(){
    console.log("Listening on port 8000");
});
var io = require('socket.io').listen(server);
io.sockets.on('connection', function (socket){
    console.log("Client/socket is connected!");
    console.log("Client/socket id is: ", socket.id);
    socket.on("posting_form", function(data){
        let dataString = JSON.stringify(data);
        let message = "You emitted the following information to the server: " + dataString;
        socket.emit('server_response', {response: message});
        let randnumber = Math.floor(Math.random()*1000);
        socket.emit('lucky_number', {number: randnumber});
    })
})