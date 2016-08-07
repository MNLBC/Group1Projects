(function() {
	angular
		.module('todo.login')
		.factory('todo.login.svc.LoginSvc', loginSvc);

	loginSvc.$inject =
		[
			'$rootScope',
			'$http',
			'$location',
			'$cookies',
			'todo.val.TodoVal'
		];

	function loginSvc($rootScope, $http, $location, $cookies, TodoVal) {

		return {
			login: login,
			loginSuccess: loginSuccess,
			logout: logout
		};

		function login(username, password, callbackFn) {
			var criteria = {
				username: username,
				password: password
			}

			var request = {
				method: 'POST',
				url: 'login',
				data: criteria
			};

			$http(request).success(function(data) {
				callbackFn(data);
			});
		}

		function loginSuccess(user) {
			TodoVal.currentUserLogin = user;

			$cookies.put('USERNAME', user.username);
			$cookies.put('PASSWORD', user.password);

			$location.path('/main');
		}

		function logout() {
			$cookies.remove('USERNAME');
			$cookies.remove('PASSWORD');

			TodoVal.currentUserLogin = null;
			$location.path('/login');
		}

	}
})();