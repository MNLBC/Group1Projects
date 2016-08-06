
var controller = require('../controller/todo-controller.js');

module.exports = function(app){
	
	app.route('/getAllTodos/:id').get(controller.getAllTodos);
	app.route('/add').post(controller.addTodo);
	app.route('/update').post(controller.updateTodo);
	app.route('/remove').post(controller.removeTodo);
}





