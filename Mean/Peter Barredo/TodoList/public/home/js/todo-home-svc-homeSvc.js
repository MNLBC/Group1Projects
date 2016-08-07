(function() {
	angular.module('todo.home').factory('todo.home.svc.HomeSvc', homeSvc);

	homeSvc.$inject = 
		[
			'$rootScope', 
			'$http', 
			'$location', 
			'todo.val.TodoVal', 
			'todo.login.svc.LoginSvc'
		];

	function homeSvc($rootScope, $http, $location, TodoVal, LoginSvc) {

		return {
			getAllTodos: getAllTodos,
			addTodo: addTodo,
			removeTodo: removeTodo,
			updateTodo: updateTodo,
			logout : logout
		}

		function getAllTodos(callbackFn) {

			var username = TodoVal.currentUserLogin.username;
			var request = {
				method: 'GET',
				url: 'getAllTodos/' + username
			};

			$http(request).success(function(data) {
				callbackFn(data);
			});
		}

		function addTodo(todo, callbackFn) {
			var request = {
				method: 'POST',
				url: 'add',
				data: todo
			};

			$http(request).
			success(function(data) {
				callbackFn(data);
			});

		}

		function removeTodo(selected, callbackFn) {
			var request = {
				method: 'POST',
				url: 'remove',
				data: selected
			};

			$http(request).success(function(data) {
				callbackFn(data);
			});
		}

		function updateTodo(selected, callbackFn) {
			var request = {
				method: 'POST',
				url: 'update',
				data: selected
			};

			$http(request).success(function(data) {
				callbackFn(data);
			});
		}

		function logout() {
			LoginSvc.logout();
		}
	}

})();