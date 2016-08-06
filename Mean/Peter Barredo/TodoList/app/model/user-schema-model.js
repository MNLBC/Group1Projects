var mongoose = require('mongoose');
	Schema = mongoose.Schema;


var UserProfileSchema = new Schema({
	firstname: String,
	middlename: String,
	lastname: String,
	username: String,
	password: String
},{
	collection: 'users'
});

mongoose.model('UserProfile', UserProfileSchema);