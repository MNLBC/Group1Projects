var app = angular.module("myapp", [ 'ngRoute' ]);

app.controller('basicsCtrl', [ '$scope', '$routeParams', '$location',
		function($scope, $routeParams, $location) {
			$scope.rowCollection = [ {
				fullname : 'Mark Anthony Andes',
				email : 'andesma@oocl.com',
				phone : '123456789'
			}, {
				fullname : 'John Emmnauel Tero',
				email : 'jjtero@oocl.com',
				phone : '987654321'
			}, {
				fullname : 'Mark Joshua Ronquillo',
				email : 'mdronquillo@oocl.com',
				phone : '369852147'
			} , {
				fullname : 'Meynard Denoyo',
				email : 'mrdenoyo@oocl.com',
				phone : '2352362342'
			} , {
				fullname : 'Gene Anthony Kadano',
				email : 'gskadano@oocl.com',
				phone : '2346234236'
			} 
			];
			$scope.showInfo = function(data) {
				$location.path('/' + data.fullname);
				$scope.info = data;
				console.log(data.fullname)
			}
		} ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/:fullname', {
		templateUrl : 'informationForm.html'
	});
} ]);