var elephants = require('../controllers/elephants.js');
module.exports = function(app){
    app.get('/', function(request, response){
        elephants.main(request, response)
    })
    app.post('/elephants', function(request, response){
        elephants.create(request, response)
    });
    
    app.get('/elephants/new', function(request, response){
        response.render('new');
    });
    
    app.get('/elephants/:id', function(request, response){
        elephants.show(request, response)
    });
    
    app.post('/elephants/:id', function(request, response){
        elephants.update(request, response)
    });
    
    app.get('/elephants/edit/:id', function(request, response){
        elephants.edit(request, response)
    });
    
    app.post('/elephants/destroy/:id', function(request, response){
        elephants.murder(request, response)
    });
}