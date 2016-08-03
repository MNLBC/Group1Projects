var app = angular.module('app', ['ui.grid', 'ui.grid.selection', 'ngRoute']);
app.controller('MainCtrl', ['$scope', '$routeParams', '$location', function($scope, $routeParams, $location) {
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
		multiSelect: false,
		appScopeProvider: {
			onDblClick: function(row) {
				$location.path('/view');
			}
		},
		rowTemplate: "<div ng-dblclick=\"grid.appScope.onDblClick(row)\" ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell ></div>",
		noUnselect: true,
		columnDefs: [{
			field: 'name',
			displayName: 'Name'
		}, {
			field: 'email',
			displayName: 'Email'
		}, {
			field: 'phone',
			displayName: 'Phone'
		}]
	};



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



	$scope.searchButtonClicked = function() {
		$scope.gridOptions.data = [];
		angular.forEach($scope.myData, function(value, key) {
			var input = $scope.name.toLowerCase(),
				name = value.name.toLowerCase();
			if (name.indexOf(input) != -1) {
				$scope.gridOptions.data.push(value);
			}

		});
	}


}]);
app.controller('viewCtrl', ['$scope', function($scope) {
	$scope.rowSelectedEntity = rowSelectedEntity;
}]);

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when("/", {
			templateUrl: 'main.html',
			controller: 'MainCtrl'
		})
		.when('/view', {
			templateUrl: 'view.html',
			controller: 'viewCtrl'
		});
}]);