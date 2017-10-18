var express = require('express');
var app = express();
const path = require('path');
app.use(express.static(path.join(__dirname, '/my-angular-app/dist')));
app.get('/', function(request, response){
    response.send("")
})