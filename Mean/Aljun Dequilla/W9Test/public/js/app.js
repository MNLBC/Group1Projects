userApp = angular.module('userApp', ['ui.grid', 'ui.grid.selection','ui.bootstrap','ngRoute'])
    .config(function ($routeProvider) {
        $routeProvider
        	.when('/', {
                templateUrl: '/public/partials/login.html',
                controller: 'userCtrl'
            })
            .when('/user', {
                templateUrl: '/public/partials/todo.html',
                controller: 'taskCtrl'
            });
    });
