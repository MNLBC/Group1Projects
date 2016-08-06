require('../model/todo-schema-model.js');

var mongoose = require('mongoose');
	Todo = mongoose.model('Todo');

exports.getAllTodos = function(req,res){

	Todo.find({username : req.params.id}, function(err, todo){
		if(err){
			console.log('Error getting all Users');
		}else{
			res.json(todo);
		}
	});
}

exports.addTodo = function(req, res){
	console.log(req.body);
	var todoEntity = new Todo(req.body);

	todoEntity.save(function (err,todo) {
		 if(err){
		 	console.log(err);
		 	res.send(err);
		 }else{
		 	console.log('Save successfully');
		 	res.send('success');
		 }
	});

}
exports.updateTodo = function(req, res){

	Todo.findOneAndUpdate({_id: req.body._id}, req.body , function(err){
		if(err){
			res.send(err);
		}else{
			res.send('success update');
		}
	})
	

}
exports.removeTodo = function(req, res){
	
	Todo.find(req.body).remove( function (err, todo) {
		 if(err){
		 	res.send(err);
		 }else{
		 	res.send('success');
		 }
	});	
}
