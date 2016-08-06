toDoListApp.factory('toDoListFactory', function($http) {
  var urlBase = '/login';
  var _usersService = {};

  _usersService.getUsers = function() {
    return $http.get(urlBase);
  };


  return _usersService;
});
