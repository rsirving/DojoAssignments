var express = require('express');
var mongoose = require('mongoose');
var app = express();
var path = require('path');
var bodyParser = require('body-parser');
var bcrypt = require('bcrypt-as-promised');
app.use(bodyParser.urlencoded({extended:true}));
mongoose.connect('mongodb://localhost/password');
mongoose.Promise = global.Promise;
app.set('views', path.join(__dirname + './views'));
app.set('view engine', 'ejs');

var UserSchema = new mongoose.Schema({
    email: {
        type: String, 
        required: true,
        validate: {
            validator: function(value){
                return /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/.test(value);
            },
            message: "Email validation failed."
        }
    },
    first_name: {type: String, required: true, validate: {
        validator: function(value){
            if (value.length < 2){
                return false;
            }
        }, 
        message: "Name must be longer than 2 characters."}
    },
    last_name: {type: String, required: true, validate: {
        validator: function(value){
            if (value.length < 2){
                return false;
            }
        }, 
        message: "Name must be longer than 2 characters."}
    },
    password: {type: String, required: true},
    birthday: {type: Date, required: true}
});

UserSchema.methods.encryptPassword = function(input){
    bcrypt.hash(input, 10)
    .then(function(hashed_password){
        return hashed_password;
    })
};

UserSchema.methods.checkPassword = function(input){
    bcrypt.compare(input, this.password)
    .then(function(){
        return true;
    })
    .catch(function(){
        return false;
    })
}

UserSchema.pre('save', function(done){
    this.password = this.encryptPassword(this.password);
    done();
});

mongoose.model('User', UserSchema);
var User = mongoose.model('User');

//Routes

app.get('/', function(request, response){
    response.render('index');
})

app.post('/register', function(request, response){
    if (request.body.password === request.body.password-confirm){
        if (User.find({email: request.body.email}).length === 0){
            var user = new User({email: request.body.email, first_name: request.body.first_name, last_name: request.body.last_name, password: request.body.password, birthday: request.body.birthday});
            request.session.userID = user.id;
            user.save();
        }
    }
})

app.post('/login', function(request, response){
    User.findOne({email: request.body.email}, function(errors, user){
        if (!errors){
            if (user.checkPassword(request.body.password)){
                
            }
        }
    })
})