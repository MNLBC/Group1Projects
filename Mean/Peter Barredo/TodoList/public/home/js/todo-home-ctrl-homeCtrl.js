(function() {
	angular.module('todo.home').controller('todo.home.ctrl.HomeCtrl', homeCtrl);

	homeCtrl.$inject = ['$scope', '$routeParams', '$location', '$http', 'todo.home.svc.HomeSvc', 'todo.val.TodoVal'];

	function homeCtrl($scope, $routeParams, $location, $http, HomeSvc, TodoVal) {

		var vm = this;


		vm.loadAllTodos = loadAllTodos;
		vm.showAddModalButtonClicked = showAddModalButtonClicked;
		vm.addTodoButtonClicked = addTodoButtonClicked;
		vm.removeButtonClicked = removeButtonClicked;
		vm.updateTodoClicked = updateTodoClicked;
		vm.logout = logout;

		loadAllTodos();

		var columnDefs = [{
			field: 'description',
			displayName: 'Description'
		}, {
			field: 'priority',
			displayName: 'Priority'
		}, {
			field: 'status',
			displayName: 'Status'
		}];

		function onDoubleClick(row) {
			$('#myModal').modal('show');
		}

		function onRowClick(row) {
			vm.selected = _.clone(row.entity);
		}

		var rowTemplate = "<div ng-click=\"grid.appScope.onRowClick(row)\" ng-dblclick=\"grid.appScope.onDoubleClick(row)\" " +
			"ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" " +
			"class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell ></div>";

		vm.gridOptions = {
			enableRowSelection: true,
			enableRowHeaderSelection: false,
			enableFiltering: true,
			multiSelect: false,
			appScopeProvider: {
				onDoubleClick: onDoubleClick,
				onRowClick: onRowClick
			},
			rowTemplate: rowTemplate,
			noUnselect: true,
			columnDefs: columnDefs
		};


		function loadAllTodos() {

			var callbackFn = function(data) {
				vm.gridOptions.data = data;
			};

			HomeSvc.getAllTodos(callbackFn);

		}

		function showAddModalButtonClicked() {

			$('#newTodoModal').modal('show');

		}

		function addTodoButtonClicked() {
			var todo = {
				description: vm.todo.description,
				priority: vm.todo.priority,
				status: vm.todo.status,
				username: TodoVal.currentUserLogin.username
			};

			var callbackFn = function(data) {
				vm.gridOptions.data.push(todo);
			};

			HomeSvc.addTodo(todo, callbackFn);
		}

		function removeButtonClicked() {

			var callbackFn = function(data) {
				var index = vm.gridOptions.data.indexOf(vm.selected);
				vm.gridOptions.data.splice(index, 1);
			};

			HomeSvc.removeTodo(vm.selected, callbackFn);
		}

		function updateTodoClicked() {

			var callbackFn = function(data) {
				vm.loadAllTodos();
			}

			HomeSvc.updateTodo(vm.selected, callbackFn);

		}

		function logout() {
			HomeSvc.logout();
		}
	}
})();