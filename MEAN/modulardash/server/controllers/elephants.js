var mongoose = require('mongoose');
var Elephant = mongoose.model('Elephant');
module.exports = {
    main: function(request, response){
        Elephant.find({}, function(errors, elephants){
            if (errors){
                console.log("Whoopsie.");
            } else {
                response.render('index', {elephants: elephants});
            }
        });
    },
    show: function(request, response){
        Elephant.findOne({_id: request.params.id}, function(errors, elephant){
            if (errors){
                response.redirect('/');
            } else {
                console.log(elephant);
                response.render('view', {elephant: elephant});
            }
        });
    },
    create: function(request, response){
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
    },
    update: function(request, response){
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
    },
    edit: function(request, response){
        Elephant.findOne({_id: request.params.id}, function(errors, elephant){
            if (errors){
                response.redirect('/');
            } else {
                response.render('edit', {elephant: elephant});
            }
        });
    },
    murder: function(request, response){
        Elephant.findOneAndRemove({_id: request.params.id}, function(errors, elephant){
            if (!errors){
                response.redirect('/');
            }
        })
    }
}