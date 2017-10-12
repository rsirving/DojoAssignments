const express = require('express');
const mongoose = require('mongoose');
const path = require('path');
const bodyParser = require('body-parser');
const bcrypt = require('bcrypt');
const saltRounds = 10;
const app = express();
var session = require('express-session');
app.use(bodyParser.urlencoded({extended:true}));
app.use(session({
    secret: "KlaatuBaradaNikto",
    resave: false,
    saveUninitialized: true
}))
mongoose.connect('mongodb://localhost/password');
mongoose.Promise = global.Promise;
app.set('views', path.join(__dirname + '/views'));
app.set('view engine', 'ejs');

var UserSchema = new mongoose.Schema({
    email: {
        type: String, 
        unique: true,
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
    password: {type: String, required: true, validate: {
        validator: function(value){
            if (value.length < 8){
                return false;
            }
        },
        message: "Password must be longer than 8 characters."}
    },
    birthday: {type: Date, required: true}
});

UserSchema.methods.encryptPassword = function(input, done){
    var user = this;
    bcrypt.hash(input, saltRounds, function(errors, hash){
        user.password = hash;
        console.log(user);
        console.log(hash);
        done();
    })
};

UserSchema.methods.checkPassword = function(input, callback){
    var hash = this.password;
    bcrypt.compare(input, hash, function(errors, answer){
        callback(answer);
    })
}

UserSchema.pre('save', function(done){
    this.encryptPassword(this.password, done);
});

mongoose.model('User', UserSchema);
var User = mongoose.model('User');

//Routes

app.get('/', function(request, response){
    response.render('index');
})

app.post('/register', function(request, response){
    if (request.body.password === request.body.password_confirm){
        User.findOne({email: request.body.email}, function(errors, user){
            if (user === null){
                var newUser = new User({email: request.body.email, first_name: request.body.first_name, last_name: request.body.last_name, password: request.body.password, birthday: request.body.birthday});
                newUser.save()
                request.session.userID = newUser._id;
                console.log(newUser)
                response.redirect('/');
            } else {
                console.log("Email is in use.");
                response.redirect('/');
            }
        });
    } else {
        console.log("Passwords don't match.");
        response.redirect('/');
    }
})

app.post('/login', function(request, response){
    User.findOne({email: request.body.email}, function(errors, user){
        if (user != null){
            user.checkPassword(request.body.password, function(answer){
                if (answer){
                    request.session.userID = user.id;
                    console.log("You're logged in.");
                    response.redirect('/');
                } else {
                    console.log(answer);
                    console.log("You're not logged in.");
                    response.redirect('/');
                }
            });
        } else {
            console.log("User not found.");
            response.redirect('/');
        }
    })
})

app.get('/clear', function(request, response){
    User.remove({}, function(err){
        console.log("They're all dead, Dave.");
        response.redirect('/');
    })
})

app.listen(8000, function(){
    console.log("It's on 8000.")
})