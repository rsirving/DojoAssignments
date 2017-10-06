var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mongoose = require('mongoose');
var path = require('path');
app.use(bodyParser.urlencoded({extended:true}));
mongoose.connect('mongodb://localhost/messageboard');
mongoose.Promise = global.Promise;
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');
var Schema = mongoose.Schema;
var MessageSchema = new mongoose.Schema({
    name: {type: String, required: true, minlength: 4},
    message: {type: String, required:true},
    remarks: [{type: Schema.Types.ObjectId, ref: "Remark"}]
});
var RemarkSchema = new mongoose.Schema({
    _message: {type: Schema.Types.ObjectId, ref: "Message"},
    name: {type: String, required: true, minlength: 4},
    text: {type: String, required: true}
})
mongoose.model('Message', MessageSchema);
mongoose.model('Remark', RemarkSchema);
var Message = mongoose.model('Message');
var Remark = mongoose.model('Remark');

// ROUTES
app.get('/', function(request, response){
    Message.find({}).populate('remarks').exec(function(errors, messages){
        response.render('index', {messages:messages});
    })
});

app.post('/message', function(request, response){
    var message = new Message({name: request.body.name, message: request.body.message});
    message.save(function(errors){
        console.log(message);
        console.log("Message saved!");
    });
    response.redirect('/');
})
app.post('/remark/:id', function(request, response){
    Message.findOne({_id: request.params.id}, function(errors, message){
        var remark = new Remark({name: request.body.name, text: request.body.text});
        remark.save(function(errors){
            message.remarks.push(remark);
            message.save(function(errors){
                if (errors) { console.log("Whoops.");}
                else { response.redirect('/');}
            });
        });
    });
});

app.get('/clear', function(request, response){
    Message.remove({}, function(errors){
        console.log("Messages cleared.");
    });
    Remark.remove({}, function(errors){
        console.log("Remarks cleared.");
    })
    response.redirect('/');
})

app.listen(8000, function(){
    console.log("Listening to port.");
})