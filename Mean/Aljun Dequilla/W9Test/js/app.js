userApp = angular.module('userApp', ['ui.grid', 'ui.grid.selection','ui.bootstrap','ngRoute'])
    .config(function ($routeProvider) {
        $routeProvider
        	.when('/', {
                templateUrl: '/partials/login.html',
                controller: 'userCtrl'
            })
            .when('/user', {
                templateUrl: '/partials/todo.html',
                controller: 'taskCtrl'
            });
    });
