var app = angular.module('app', ['ui.grid', 'ui.grid.selection','ngRoute']);
app.controller('MainCtrl',['$scope', '$routeParams', '$location', function($scope, $routeParams, $location) {
	$scope.name = '';
	$scope.displayView = false;
	rowSelectedEntity = false;

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

	}, {
		"name": "Pauline Racelis",
		"email": "pau@yahoo.com",
		"phone": "232375"

	}];

	$scope.gridOptions = {
		enableRowSelection: true,
		enableRowHeaderSelection: false,
		data: $scope.myData,
		multiSelect : false,
		columnDefs : [
		{ field: 'name', displayName: 'Name' },
		{ field: 'email', displayName: 'Email' },
		{ field: 'phone', displayName: 'Phone' }
		]
	};

	
	$scope.gridOptions.onRegisterApi = function (gridApi) {
                $scope.gridApi = gridApi;
                gridApi.selection.on.rowSelectionChanged($scope, function(row){
                	if(row.isSelected){
						$scope.rowSelectedEntity = row.entity;
						rowSelectedEntity = row.entity;
						$scope.displayView = true;
                	}else{
                		$scope.rowSelectedEntity = false;
                		$scope.displayView = false;
                	}
                	
                });
        };
    
	

	$scope.searchButtonClicked = function(){
		$scope.gridOptions.data = [];
		angular.forEach($scope.myData, function(value, key) {
		  	var input = $scope.name.toLowerCase(),
		  		name = value.name.toLowerCase();
		  	if(name.indexOf(input) != -1){
		  		$scope.gridOptions.data.push(value);
		  	}

		});
	}

	$scope.viewRecord = function(){
		if(!$scope.rowSelectedEntity){
			alert('No Selected grid record');
		}
		$location.path('/view');
	}

}]);
app.controller('viewCtrl', ['$scope', function($scope){
	$scope.rowSelectedEntity = rowSelectedEntity;
}]);

app.config(['$routeProvider', function($routeProvider) {
		$routeProvider
		.when("/", {
       		 templateUrl : 'main.html',
       		 controller : 'MainCtrl'
    	})
		.when('/view', {
			templateUrl: 'view.html',
			controller : 'viewCtrl'
		});
	}
]);