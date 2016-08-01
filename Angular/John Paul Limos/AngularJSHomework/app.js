var app = angular.module('app', ['ngRoute']);

app.controller('MainCtrl', ['$scope', '$routeParams', '$location', function($scope, $routeParams, $location) {
	$scope.peopleData = [{
			id:1,
			firstname: "Imelda",
			lastname: "Papins",
			email: "itsmeimelda@famestar.com",
			phone: "0910910911"
		}, {
			id:2,
			firstname: "Noynoy",
			lastname: "Aquino",
			email: "akoyp@not.com",
			phone: "091091091"
		}, {
			id:3,
			firstname: "Taylor",
			lastname: "Swift",
			email: "taylor@yahoo.com",
			phone: "091091091"
		}, {
			id:4,
			firstname: "Chena",
			lastname: "Boom Boom",
			email: "chararat@mo.com",
			phone: "091091091"
		}, {
			id:5,
			firstname: "Keme",
			lastname: "Mo",
			email: "keme@ka.com",
			phone: "091091091"
		}];

$scope.viewId = $routeParams.id;
$scope.data = $scope.peopleData[$scope.viewId-1];
$scope.searchText = function() {
	angular.forEach($scope.peopleData, function(value, key) {
		if (value.firstname.indexOf($scope.searchKey) > -1 || value.lastname.indexOf($scope.searchKey) > -1 || value.email.indexOf($scope.searchKey) > -1 || value.phone.indexOf($scope.searchKey) > -1) {
			$scope.peopleData=[{
				firstname: value.firstname,
				lastname: value.lastname,
				email: value.email,
				phone: value.phone
			}];
			return $scope.peopleData;
		}
	});
};

$scope.gridDblClick = function(info) {
	$location.path('/viewDetails/'+ info.id);
	$scope.personData = info.firstname + " " + info.lastname + ", " + info.email+ ", " + info.phone;
};

}]);

app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/viewDetails/:id', {
        templateUrl: 'personDetails.html',
        controller: 'MainCtrl'
      });
  }]);
