var express = require("express");
var bodyParser = require('body-parser');
var session = require('express-session');
app = express();
app.use(session({secret: "KlaatuBaradaNikto", resave: true, saveUninitialized: true}));
app.use(bodyParser.urlencoded({extended: true}));
app.set('views', __dirname + "/views");
app.set('view engine', 'ejs');
app.get('/', function(request, response){
    if (request.session.answer === undefined){
        request.session.answer = Math.floor(Math.random()*100) + 1;
    }
    if (request.session.guess === undefined){
        request.session.guess = 0;
    }
    console.log(request.session.answer);
    console.log(request.session.guess);
    response.render('index', {guess: request.session.guess, answer: request.session.answer});
})
app.post('/guess', function(request, response){
    request.session.guess = request.body.guess;
    response.redirect('/');
})
app.post('/reset', function(request, response){
    request.session.answer = undefined;
    request.session.guess = undefined;
    response.redirect('/');
})
app.listen(8000, function(){
    console.log("Listening on port 8000");
})