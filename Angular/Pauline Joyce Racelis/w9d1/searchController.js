var app = angular.module('myApp', ['ngRoute']);

app.config(['$routeProvider',function($routeProvider){
  $routeProvider.when('/',{
      templateUrl: 'default.html'
  }).when('/viewUser',{
      templateUrl: 'viewUser.html'
  });
}]);
app.controller('searchController', function($scope,$http,$location) {
    $scope.info = [{name: "Pau", email: "pau@test.com",phone:"1234343242"},
                     {name: "Bonnie", email:"bonnie@test.com",phone:"1234343242"},
                     {name: "Jacob", email: "jacob@test.com",phone:"1234343242"},
                     {name: "Nephi", email: "nephi@test.com",phone:"1234343242"},
                     {name: "Enos", email: "enos@test.com",phone:"1234343242"}];

    $scope.filterData = function(criteria){
      $scope.filter = criteria;
    };

    $scope.viewUser = function(selecteduser){
      $location.path('/viewUser');
      $scope.selectedUser = selecteduser;
    };
});