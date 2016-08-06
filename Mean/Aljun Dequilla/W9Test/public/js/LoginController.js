userApp.controller('userCtrl', function ($rootScope, $scope, $location, userFactory) {

	$scope.allusers = [];
	userdata = false;
	$scope.usertemp = false;
	$scope.hasError = false;

	$scope.loginBtn = function() {
		var uname = $scope.username,
		pword = $scope.password;
		if(uname !=null && pword!=null){
			var check = $scope.getUser(uname,pword);
			if(check){
				$location.path('/user');	
			} else{
				$scope.alertValid = "Username and Password are incorrect.";
				$scope.hasError = true;
			}
		}else{
			$scope.alertValid = "Please fill up all the fields.";
			$scope.hasError = true;
		}
	};

	$scope.getUser = function(username,password){
		var check = false;
		angular.forEach($scope.allusers, function(value,key){
			if(value.username === username && value.password === password){
				 userFactory.getUser({
				 	"username": username,
				 	"password": password
				 }).then(function(data){
					$scope.usertemp = data.data[0];
					userdata =$scope.usertemp ;
				 });
				 check = true;
			}
		});
		return check;
	};

    userFactory.getUsers().then(function (data) {
    	$scope.allusers = data.data;
    });
});