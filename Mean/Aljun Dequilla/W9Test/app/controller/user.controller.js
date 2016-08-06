var mongoose = require('mongoose');
var db = mongoose.connection;

var UserSchema = mongoose.Schema({
	name : String,
	username : String,
	password : String,
	task: [{
		entry:String,
		status:String,
		priority:Number
	}]
});

var UserModel = db.model('usercollec',UserSchema);

var userController = {};

userController.getAll = function(req,res){
	UserModel.find({}, function(err,data){
		if(err){
			console.log(err);
		}
		res.json(data);
	})
}

userController.getUser = function(req,res){
	var user = {
		"username" : req.body.username,
		"password" : req.body.password
	};

	UserModel.find(user, function(err,data){
		if(err){
			console.log(err);
		}
		res.json(data);
	})
}

userController.saveTask = function(req,res){
	var task = {
		"entry": req.body.entry,
		"status": req.body.status,
		"priority": req.body.priority
	};

	UserModel.update(req.body.user, 
		{$push: { task: task }}, 
		function(err,data){
			if(err){
				console.log(err);
			}
			res.json(data);
		}
		)
}

userController.removeTask = function(req,res){
	var task = {
		"entry": req.body.entry,
		"status": req.body.status,
		"priority": req.body.priority
	};

	UserModel.update(req.body.user, 
		{$pull: { task: task }}, 
		function(err,data){
			if(err){
				console.log(err);
			}
			res.json(data);
		}
		)
}

userController.updateTask = function(req,res){

	var user = req.body.user,
	oldTask = {
		"entry":req.body.old.entry,
		"status":req.body.old.status,
		"priority": req.body.old.priority
	},
	newTask = {
		"entry":req.body.new.entry,
		"status":req.body.new.status,
		"priority": req.body.new.priority
	};

	UserModel.update(req.body.user, 
		{$pull: { task: req.body.old }}, 
		function(err,data){
			if(err){
				console.log(err);
			}else{
				UserModel.update(req.body.user, 
					{$push: { task: req.body.new }}, 
					function(err,data){
						if(err){
							console.log(err);
						}
						res.json(data);
					}
					);
			}
		}
		);
}

module.exports = userController;