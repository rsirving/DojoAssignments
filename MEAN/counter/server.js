var express = require('express');
var session = require('express-session');
var app = express();
app.use(session({secret: "KlaatuBaradaNikto", resave: true, saveUninitialized: true}));
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');
app.get('/', function(request, response){
    if (request.session.count === undefined){
        request.session.count = 0;
    }
    request.session.count += 1;
    response.render('home', {count: request.session.count})
})
app.listen(8000, function(){
    console.log("listening on port 8000");
})