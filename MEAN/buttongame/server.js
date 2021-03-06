var express = require('express');
var bodyParser = require('body-parser');
var ejs = require('ejs');
var app = express();
app.use(bodyParser.urlencoded({extended:true}));
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

app.get('/', function(request,response){
    response.render('index');
})
var server = app.listen(8000, function() {
    console.log("Listening on port 8000!");
})
var io = require("socket.io").listen(server);
var count = 0;
io.sockets.on('connection', function(socket){
    console.log("Client/socket is connected!");
    console.log("Client/socket id is: ", socket.id);
    io.emit("incResponse", {'count': count});
    socket.on("incCount", function(){
        count = count + 1;
        console.log(count);
        io.emit('incResponse', {'count': count});
    })
    socket.on("incReset", function(){
        count = 0;
        io.emit('incResponse', {'count': count});
    })
})