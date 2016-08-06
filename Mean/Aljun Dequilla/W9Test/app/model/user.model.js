var mongoose = require('mongoose');

var UserSchema = mongoose.Schema({
	name : String,
	username : String,
	password : String,
	task: [{
		entry:String,
		status:String
	}]
});

mongoose.model('user',UserSchema);