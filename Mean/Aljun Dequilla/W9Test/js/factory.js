userApp.factory('userFactory', function($http) {
  var urlBase = '/user';
  var _userService = {};

  _userService.getUsers = function() {
    return $http.get(urlBase);
  };

  _userService.getUser = function(user) {
    return $http.post(urlBase+'/success',user);
  };

  _userService.saveTask = function(task) {
    return $http.put(urlBase+'/insert',task);
  };

  _userService.removeTask = function(task) {
    return $http.put(urlBase+'/remove',task);
  };

  _userService.updateTask = function(task) {
    return $http.put(urlBase+'/update',task);
  };

  return _userService;
});
