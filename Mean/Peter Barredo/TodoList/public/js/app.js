var app = angular.module('app', ['ui.grid', 'ui.grid.selection', 'ngRoute']);

app.controller('MainCtrl', ['$scope', '$routeParams', '$location','$http', function($scope, $routeParams, $location, $http) {
	$scope.name = '';
	$scope.displayView = false;
	rowSelectedEntity = false;

	$http({
	      method: 'GET',
	      url: 'getAllTodos/'+ currentLoginUser.username
	  }).
	    success(function(data) {
	       $scope.gridOptions.data = data;
	    }).
	    error(function(error) {
	        console.error(error);
	    });

	
	$scope.gridOptions = {
		enableRowSelection: true,
		enableRowHeaderSelection: false,
		enableFiltering: true,
		multiSelect: false,
		appScopeProvider: {
			onDblClick: function(row) {
				$scope.selected = _.clone(row.entity);
				$('#myModal').modal('show');				
			}
		},
		rowTemplate: "<div ng-dblclick=\"grid.appScope.onDblClick(row)\" ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell ></div>",
		noUnselect: true,
		columnDefs: [{
			field: 'description',
			displayName: 'Description'
		}, {
			field: 'priority',
			displayName: 'Priority'
		}, {
			field: 'status',
			displayName: 'Status'
		}]
	};


	$scope.filterButtonClicked = function() {
		

		var filter = ($scope.filter) ? _.clone($scope.filter) : {};
		var description = (filter.description) ? filter.description : '',
			priority = (filter.priority) ? filter.priority : '', 
			status = (filter.status) ? filter.status : '';


		if(_.isEmpty(description) && _.isEmpty(priority) && _.isEmpty(status)){
			return;
		}

		if(description){
			var data = _.clone($scope.gridOptions.data);
			$scope.gridOptions.data = [];
			angular.forEach(data, function(value, key) {
				if (value.description.toLowerCase().indexOf(description.toLowerCase()) != -1 ) 
				{
					$scope.gridOptions.data.push(value);
				}

			});
		}

		if(priority){
			var data = _.clone($scope.gridOptions.data);
			$scope.gridOptions.data = [];
			angular.forEach(data, function(value, key) {
				if (priority == value.priority ) 
				{
					$scope.gridOptions.data.push(value);
				}

			});
		}

		if(status){
			var data = _.clone($scope.gridOptions.data);
			$scope.gridOptions.data = [];
			angular.forEach(data, function(value, key) {
				if (value.status.toLowerCase().indexOf(status.toLowerCase()) != -1 ) 
				{
					$scope.gridOptions.data.push(value);
				}
			});
		}


		
	}

	$scope.gridOptions.onRegisterApi = function(gridApi) {
		$scope.gridApi = gridApi;
		gridApi.selection.on.rowSelectionChanged($scope, function(row) {
			if (row.isSelected) {
				rowSelectedEntity = row.entity;
				$scope.displayView = true;
			} else {
				$scope.displayView = false;
			}

		});
	};

	$scope.addButtonClicked = function(){
	    $('#newTodoModal').modal('show');
	}

	$scope.addTodoButtonClicked = function(){
		var todo = {
			description: $scope.todo.description,
			priority : $scope.todo.priority,
			status : $scope.todo.status,
			username : currentLoginUser.username
		};


		$http({
	          method: 'POST',
	          url: 'add',
	           data: todo
	      }).
	        success(function(data) {
	           $scope.gridOptions.data.push(todo);
	        }).
	        error(function(error) {
	            console.log('error');
	           	console.log(error);
	        });

	}

	$scope.removeButtonClicked = function(){

		$http({
	          method: 'POST',
	          url: 'remove',
	          data: rowSelectedEntity
	      }).
	        success(function(data) {
	           console.log('Success');
	           console.log(data);

	           var index = $scope.gridOptions.data.indexOf(rowSelectedEntity);
 			   $scope.gridOptions.data.splice(index,1);

	        }).
	        error(function(error) {
	            console.log('error');
	           	console.log(error);
	        });

	}

	$scope.loadAllData = function(){
		console.log(currentLoginUser);
		$http({
	          method: 'GET',
	          url: 'getAllTodos/'+ currentLoginUser.username
	      }).
	        success(function(data) {
	           $scope.gridOptions.data = data;
	        }).
	        error(function(error) {
	            console.error(error);
	        });


	}

	$scope.updateTodoClicked = function(){

		var form = {
			selected : rowSelectedEntity,
			updated : $scope.selected
		};
		
		$http({
	          method: 'POST',
	          url: 'update',
	          data: $scope.selected
	      }).
	        success(function(data) {
	           console.log('Success');
	           console.log(data);
	          
 			   $scope.loadAllData();

	        }).
	        error(function(error) {
	            console.log('error');
	           	console.log(error);
	        });

	}


}]);

app.controller('loginCtrl', ['$scope','$http', '$location', function($scope,$http,$location) {

	$scope.username = 'pvbarredo';
	$scope.password = 'adminadmin';
	$scope.login = function(){
		var criteria = {
			username : $scope.username,
			password : $scope.password
		};
		 $http({
	          method: 'POST',
	          url: 'login',
	          data: criteria
	      }).
	        success(function(data) {
	           
	           if(!_.isEmpty(data)){
	          	 	currentLoginUser = data[0];
	           		$location.path('/main');
	           }
	           
	        }).
	        error(function(error) {
	            console.log('error');
	           	console.log(error);
	        });

	}
}]);

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when("/", {
			templateUrl: 'login/login.html'
		})
		.when("/main", {
			templateUrl: 'home/main.html',
		});
	
}]);