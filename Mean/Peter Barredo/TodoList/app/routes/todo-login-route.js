
var controller = require('../controller/user-controller.js');

module.exports = function(app){
	
	app.route('/getAllUsers').get(controller.getAllUsers);

	app.route('/login').post(controller.findUser);
}


