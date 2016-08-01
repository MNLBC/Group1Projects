var appJS = angular.module('appJS', [ 'ngRoute' ]);

appJS.controller('initController', [ '$scope', '$routeParams', '$location',
		function($scope, $routeParams, $location) {
			$scope.list = [ {
				name : 'Aljun Dequilla',
				email : 'aljun.dequilla@oocl.com',
				phone : '+1-202-555-0180'
			}, {
				name : 'Mark Anthony Andes',
				email : 'mark.anthony.andes@oocl.com',
				phone : '+1-021-615-0191'
			}, {
				name : 'Ana Katrina De Leon',
				email : 'ana.katrina.deleon@oocl.com',
				phone : '+1-768-572-0157'
			}, {
				name : 'John Paul Limos',
				email : 'john.paul.limos@oocl.com',
				phone : '+1-166-511-2415'
			}, {
				name : 'Pauline Joyce Racelis',
				email : 'pauline.joyse.racelis@oocl.com',
				phone : '+1-511-752-1144'
			}, {
				name : 'Peter Emmanuel Barredo',
				email : 'peter.barredo@oocl.com',
				phone : '+1-667-111-7146'
			}, {
				name : 'Jhunario Ganapin',
				email : 'jhunario.ganapin@oocl.com',
				phone : '+1-034-8817-5411'
			} ];

			$scope.showAlert = function(data) {
				$location.path('/' + data.name);
				$scope.passData = data;
			}

		} ]);

appJS.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/:name', {
		templateUrl : 'details.html',
		controller : 'initController'
	});
} ]);