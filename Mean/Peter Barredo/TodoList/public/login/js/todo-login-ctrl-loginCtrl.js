(function() {
	angular.module('todo.login').controller('todo.login.ctrl.LoginCtrl', loginCtrl);

	loginCtrl.$inject = ['$scope', 'todo.login.svc.LoginSvc'];

	function loginCtrl($scope, LoginSvc) {

		var vm = this;

		vm.login = login;
		vm.logout = logout;
		vm.cancel = cancel;

		function login() {

			var callbackFn = function(data) {

				if (!_.isEmpty(data)) {
					LoginSvc.loginSuccess(data[0])
				} else {
					sweetAlert("Invalid Credential", "Please check your username/password", "error");
				}
			}

			var username = vm.username.toLowerCase(),
				password = vm.password.toLowerCase();

			LoginSvc.login(username, password, callbackFn);

		}

		function logout() {
			LoginSvc.logout();
		}

		function cancel(){
			vm.username = '';
			vm.password = '';
		}

	}

})();