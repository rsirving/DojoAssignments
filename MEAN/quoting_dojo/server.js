var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mongoose = require('mongoose');
var path = require('path');
var moment = require('moment');
app.use(bodyParser.urlencoded({ extended: true}));
mongoose.connect('mongodb://localhost/quotes');
mongoose.Promise = global.Promise;
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');
var QuoteSchema = new mongoose.Schema({
    name: String,
    quote: String,
}, {timestamps: true});
mongoose.model('Quote', QuoteSchema);
var Quote = mongoose.model("Quote");
app.get('/', function(request, response){
    response.render('index');
})
app.post('/quotes', function(request, response){
    var quote = new Quote({name: request.body.name, quote: request.body.quote})
    quote.save(function(errors){
        if (errors){
            response.render('errors');
        } else {
            console.log(quote);
            console.log("Successfully added a quote.");
        }
    })
    response.redirect('/quotes');
})
app.get('/quotes', function(request, response){
    Quote.find({}).sort({createdAt: -1}).exec(function(errors, quotes){
        if (errors){
            console.log("There was a problem.");
        } else {
            response.render('quotes', {quotes: quotes});
        }
    });
});
app.listen(8000, function(){
    console.log("Listening on port 8000.");
})