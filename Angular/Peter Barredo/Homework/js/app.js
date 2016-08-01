var app = angular.module('app', ['ui.grid', 'ui.grid.selection','ngRoute']);
app.controller('MainCtrl',['$scope', '$routeParams', '$location', function($scope, $routeParams, $location) {
	$scope.name = '';
	$scope.displayView = false;
	$scope.rowSelectedEntity = false;

	$scope.myData = [{
		"name": "Peter Barredo",
		"email": "pvbarredo@gmail.com",
		"phone": "8264095"

	}, {
		"name": "Sebastian Briones",
		"email": "baste@oocl.com",
		"phone": "222644"

	}, {
		"name": "John Paul Limos",
		"email": "limos@yahoo.com",
		"phone": "454575"

	}];

	$scope.gridOptions = {
		enableRowSelection: true,
		enableRowHeaderSelection: false,
		multiSelect : false,
		columnDefs : [
		{ field: 'name', displayName: 'Name' },
		{ field: 'email', displayName: 'Email' },
		{ field: 'phone', displayName: 'Phone' }
		]
	};
	$scope.mySelections = [];

	
	$scope.gridOptions.onRegisterApi = function (gridApi) {
                $scope.gridApi = gridApi;
                gridApi.selection.on.rowSelectionChanged($scope, function(row){
                	if(row.isSelected){
						$scope.rowSelectedEntity = row.entity;
						$scope.displayView = true;
                	}else{
                		$scope.rowSelectedEntity = false;
                		$scope.displayView = false;
                	}
                	
                });
        };
    $scope.gridOptions.data = $scope.myData;
	

	$scope.searchButtonClicked = function(){
		$scope.gridOptions.data = [];
		angular.forEach($scope.myData, function(value, key) {
		  	var input = $scope.name.toLowerCase();
		  		name = value.name.toLowerCase();
		  	if(name.indexOf(input) != -1){
		  		$scope.gridOptions.data.push(value);
		  	}

		});
	}

	$scope.viewRecord = function(){
		$location.path('/view');
	}

}]);
app.config(['$routeProvider', function($routeProvider) {
		$routeProvider
		.when("/", {
       		 templateUrl : 'main.html',
       		 controller: 'MainCtrl'
    	})
		.when('/view', {
			templateUrl: 'view.html',
			controller: 'MainCtrl'
		});
	}
]);