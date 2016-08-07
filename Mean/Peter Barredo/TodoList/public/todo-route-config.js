(function() {
	angular.module('todo').config(config);

	config.$inject = ['$routeProvider'];

	function config($routeProvider) {
		$routeProvider
			.when('/login', {
				templateUrl: 'login/login.html',
				controller: 'todo.login.ctrl.LoginCtrl',
				controllerAs: 'vm'
			})
			.when('/main', {
				templateUrl: 'home/home.html',
				controller: 'todo.home.ctrl.HomeCtrl',
				controllerAs: 'vm'
			});
			
	}


})();