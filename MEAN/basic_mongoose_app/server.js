var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mongoose = require("mongoose");
app.use(bodyParser.urlencoded({ extended: true }));
mongoose.connect('mongodb://localhost/basic_mongoose');
mongoose.Promise = global.Promise;
var UserSchema = new mongoose.Schema({
    name: String,
    age: Number
})
mongoose.model('User', UserSchema);
var User = mongoose.model('User');
var path = require('path');
app.use(express.static(path.join(__dirname, './static')));
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');
app.get('/', function(request, response) {
    User.find({}, function(err, users){
        if (err){
            console.log("There was an error.");
        } else {
            for (user in users){
                console.log(user);
            }
        }
    });
    response.render('index');
})
app.post('/users', function(request, response) {
    console.log("POST DATA", request.body);
    var user = new User({name: request.body.name, age: request.body.age});
    user.save(function(err){
        if (err){
            console.log('Something went wrong.');
        } else {
            console.log("Successfully added a user!");
            response.redirect('/');
        }
    })
    response.redirect('/');
})
app.listen(8000, function() {
    console.log("listening on port 8000");
})
