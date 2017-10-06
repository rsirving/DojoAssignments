var mongoose = require('mongoose');
var ElephantSchema = new mongoose.Schema({
    name: { type: String, required: true, minlength: 2 },
    age: { type: Number, required: true, min: 0},
    gender: { type: String, required: true }
});
mongoose.model('Elephant', ElephantSchema);