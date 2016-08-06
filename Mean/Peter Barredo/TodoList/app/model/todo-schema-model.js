var mongoose = require('mongoose');
	Schema = mongoose.Schema;


var TodoSchema = new Schema({
	description: String,
	priority: Number,
	status: String,
	username : String
},{
	collection: 'todo'
});

mongoose.model('Todo', TodoSchema);