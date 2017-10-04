var express = require('express');
var bodyParser = require('body-parser');
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
app.listen(8000, function(){
    console.log("Listening on port 8000");
})