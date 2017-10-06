// REQUIRES
var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mongoose = require('mongoose');
var path = require('path');
app.use(bodyParser.urlencoded({extended:true}));
mongoose.connect('mongodb://localhost/elephants');
mongoose.Promise = global.Promise;
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');
var ElephantSchema = new mongoose.Schema({
    name: { type: String, required: true, minlength: 2 },
    age: { type: Number, required: true, min: 0},
    gender: { type: String, required: true }
});
mongoose.model('Elephant', ElephantSchema);
var Elephant = mongoose.model('Elephant');

// ROUTES
app.get('/', function(request, response){
    Elephant.find({}, function(errors, elephants){
        if (errors){
            console.log("Whoopsie.");
        } else {
            response.render('index', {elephants: elephants});
        }
    });
});

app.post('/elephants', function(request, response){
    var elephant = new Elephant({name: request.body.name, age: request.body.age, gender: request.body.gender});
    elephant.save(function(errors){
        if (errors){
            console.log("Whoops.");
        } else {
            console.log(elephant);
            console.log("New elephant in the herd!");
        }
    });
    response.redirect('/');
});

app.get('/elephants/new', function(request, response){
    response.render('new');
});

app.get('/elephants/:id', function(request, response){
    Elephant.findOne({_id: request.params.id}, function(errors, elephant){
        if (errors){
            response.redirect('/');
        } else {
            console.log(elephant);
            response.render('view', {elephant: elephant});
        }
    });
});

app.post('/elephants/:id', function(request, response){
    Elephant.findOne({_id: request.params.id}, function(errors, elephant){
        if (!errors){
            elephant.name = request.body.name;
            elephant.age = request.body.age;
            elephant.gender = request.body.gender;
            elephant.save(function(errors){
                console.log("Something went wrong.");
            });
        }
        response.redirect('/');
    });
});

app.get('/elephants/edit/:id', function(request, response){
    Elephant.findOne({_id: request.params.id}, function(errors, elephant){
        if (errors){
            response.redirect('/');
        } else {
            response.render('edit', {elephant: elephant});
        }
    });
});

app.post('/elephants/destroy/:id', function(request, response){
    Elephant.findOneAndRemove({_id: request.params.id}, function(errors, elephant){
        if (!errors){
            response.redirect('/');
        }
    })
});

// LISTEN
app.listen(8000, function(){
    console.log("Listening on port 8000.");
});