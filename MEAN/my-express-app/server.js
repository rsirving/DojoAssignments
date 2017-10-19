const express = require('express');
const app = express();
const path = require('path');
app.use(express.static(path.join(__dirname, '/my-angular-app/dist')));

app.get('/', function(request, response){
    response.render('index');
})

app.listen(8000, function(){
    console.log("Listening on 8000");
})