var app = angular.module('app', ['ngRoute']);

app.controller('MainCtrl', ['$scope', '$routeParams', '$location', function($scope, $routeParams, $location){
$scope.myData = [
{
id: 01,
firstName:"Ana Katrina",
lastName:"De Leon",
email:"deleoan@oocl.com"
},
{
id: 02,
firstName:"John Paul",
lastName:"Limos",
email:"limosjo@oocl.com"
},
{
id: 03,
firstName:"Pauline Joyce",
lastName:"Racelis",
email:"racelpa@oocl.com"
},
{
id: 04,
firstName:"Aljun",
lastName:"Dequial",
email:"dequial@oocl.com"
},
{
id: 05,
firstName:"Mark Anthony",
lastName:"Andes",
email:"andesma@oocl.com"
},
{
id: 06,
firstName:"Peter Emmanuel",
lastName:"Barredo",
email:"barrepe@oocl.com"
},

];

$scope.viewId = $routeParams.id;
$scope.data = $scope.myData[$scope.viewId-1];
$scope.onSearchBtnClick = function() {
        angular.forEach($scope.myData, function(value, key) {
            if (value.firstName.indexOf( $scope.searchValue)>-1 || value.lastName.indexOf( $scope.searchValue)>-1 || value.email.indexOf( $scope.searchValue)>-1) {
                $scope.myData = [
                    {
                        firstName: value.firstName,
                        lastName: value.lastName,
                        email: value.email
                    }
                ];
                return myData;
            }
        });
    };

$scope.onDblClickView = function(data) {
	$location.path('/viewDetails/'+ data.id);
	$scope.message = data.firstName + " " + data.lastName + ", " + data.email;
};

}]);

app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/viewDetails/:id', {
        templateUrl: 'viewInfo.html',
        controller: 'MainCtrl'
      });
  }]);
