var express = require('express');
var mongoose = require('mongoose');
var path = require('path');
var app = express();
var bodyParser = require('body-parser');
mongoose.connect('mongodb://localhost/1955');
mongoose.Promise = global.Promise;
app.use(bodyParser.urlencoded({extended:true}));
app.use(bodyParser.json());

var PersonSchema = new mongoose.Schema({
    name: {type: String, required: true}
});
mongoose.model('Person', PersonSchema);
var Person = mongoose.model('Person');

app.get('/', function(request, response){
    console.log("This is the full API page.");
    Person.find({}, function(errors, persons){
        response.json(persons);
    })
})

app.get('/new/:name', function(request, response){
    console.log('You are trying to put a new person in the API');
    var person = new Person({name: request.params.name});
    person.save(function(errors){
        console.log("You were successful.");
        response.redirect('/');
    })
})
app.get('/remove/:name', function(request, response){
    console.log("You're trying to remove someone from the API.");
    Person.findOneAndRemove({name: request.params.name}, function(errors, person){
        console.log("You monster.");
        response.redirect('/');
    })
})
app.get('/:name', function(request, response){
    console.log("This is the information for just one person.");
    Person.find({name: request.params.name}, function(error, person){
        response.json({person});
    })
})

app.listen(8000, function(){
    console.log("Listening on port 8000.");
})