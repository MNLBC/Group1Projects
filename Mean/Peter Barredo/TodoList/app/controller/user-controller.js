require('../model/user-schema-model.js');

var mongoose = require('mongoose');
	User = mongoose.model('UserProfile');

exports.findUser = function(req, res, next){
	var criteria = req.body;
	User.find(criteria, function (err, userProfile) {
		 if(err){
		 	console.log('Error Login');
		 }else{
		 	res.json(userProfile);
		 }
	});
}

exports.getAllUsers = function(req,res){
	User.find({}, function(err, userProfile){
		if(err){
			console.log('Error getting all Users');
		}else{
			res.json(userProfile);
		}
	});
}