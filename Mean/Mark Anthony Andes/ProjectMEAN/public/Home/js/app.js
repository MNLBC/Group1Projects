/**
 * Created by ANDESMA on 8/4/2016.
 */
 toDoListApp = angular.module('toDoListApp', ['ui.grid', 'ui.grid.selection', 'ngRoute'])
    .config(function ($routeProvider,$locationProvider) {
        $routeProvider
            .when('/', {
                templateUrl: '/public/Login/login.html',
                controller: 'loginCtrl'
            })
            .when('/toDoList',{
                templateUrl: '/public/Home/toDoList.html',
                controller: 'toDoListCtrl'
            })
    });

