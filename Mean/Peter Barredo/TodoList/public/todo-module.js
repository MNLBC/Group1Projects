(function() {
	var dependency = 
		[
			'ui.grid', 
			'ui.grid.selection', 
			'ngCookies',
			'ngRoute', 
			'todo.login', 
			'todo.home'
		];

	angular.module('todo', dependency);
})();


(function() {
	angular
		.module('todo')
		.value('todo.val.TodoVal', {
			currentUserLogin : null
		})
		.run(run);

	run.$inject = 
		[
			'$cookies',
			'$location',
			'todo.val.TodoVal',
			'todo.login.svc.LoginSvc'
		];

	function run($cookies, $location, TodoVal, LoginSvc) {
		console.log($location.path().indexOf('login'));
		console.log($location.path());
		if($location.path().indexOf('login') >= 0){
			$cookies.remove('USERNAME');
			$cookies.remove('PASSWORD');
		}

		var username = $cookies.get('USERNAME'),
			password = $cookies.get('PASSWORD');

		if(!_.isEmpty(username) && !_.isEmpty(password)){

			var callbackFn = function(data) {
				LoginSvc.loginSuccess(data[0])
			};

			 LoginSvc.login(username, password, callbackFn);

		}else{

			if($location.path().indexOf('login') < 0){
				$location.path('/login');
			}

		}
	}

})();