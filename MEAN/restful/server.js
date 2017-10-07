var express = require('express');
var mongoose = require('mongoose');
var bodyParser = require('body-parser');
var app = express();
app.use(bodyParser.urlencoded({extended:true}));
app.use(bodyParser.json())
mongoose.connect('mongodb://localhost/restful');
mongoose.Promise = global.Promise;

var TaskSchema = new mongoose.Schema({
    title: {type: String},
    description: {type: String, default: ""},
    completed: {type: Boolean, default: false},
}, {timestamps: { createdAt: 'created_at', updatedAt: 'updated_at'}});
mongoose.model('Task', TaskSchema);
var Task = mongoose.model('Task');

app.get('/', function(request, response){
    response.redirect('/retrieve');
})

app.get('/retrieve', function(request, response){
    Task.find({}, function(errors, tasks){
        response.json(tasks);
    })
})

app.get('/retrieve/:id', function(request, response){
    Task.findOne({id: request.params.id}, function(errors, task){
        response.json(task);
    })
})

app.post('/create', function(request, response){
    var task = new Task({title: request.body.title});
    task.save(function(errors){
        response.redirect('/');
    })
})

app.put('/update/:id', function(request, response){
    Task.findOne({id: request.params.id}, function(errors, task){
        if (!errors){
            task.title = request.body.title;
            task.description = request.body.description;
            task.completed = request.body.completed;
            task.updated_at = Date.now();
            task.save(function(errors){
                console.log("Something went wrong.");
            })
        }
        response.redirect('/');
    })
})

app.delete('/delete/:id', function(request, response){
    Task.findByIdAndRemove({id: request.params.id});
    response.redirect('/');
})