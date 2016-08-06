toDoListApp.controller('loginCtrl', function ($rootScope, $scope, toDoListFactory, $location, $http) {
    $scope.users = [];
    userLogin = '';
    userTodolist = [];
    // get all notes on Load
    $scope.login = function () {

        var validate = false;

        var userInfo = {
            username: $scope.username,
            password: $scope.password
        };
        //POST
        if ($scope.username != null && $scope.password != null) {
            $http({
                method: 'POST',
                url: 'login',
                data: userInfo
            }).success(function (data) {
                if (data.length == 0) {
                    $scope.error = "Username or password is incorrect!";
                    $location.path('/');
                } else {
                    console.log(data);
                    angular.forEach(data[0].todolist, function (value) {
                        userTodolist.push(value);
                    });
                    userLogin = userInfo;
                    $location.path('/toDoList');
                }
            }).error(function (error) {
                console.log(error);
            });
        } else {
            $scope.error = "Please fill up the blanks";
            $location.path('/');
        }
    };
});

toDoListApp.controller('toDoListCtrl', function ($scope, $routeParams, $rootScope, $location, $http) {
    $scope.displayView = false;
    rowSelectedEntity = false;

    $scope.username = userLogin.username;

    $scope.gridOptions = {
        enableRowSelection: true,
        enableRowHeaderSelection: false,
        enableFiltering: true,
        data: userTodolist,
        multiSelect: false,
        appScopeProvider: {
            onDblClick: function (row) {
                $scope.selected = _.clone(row.entity);
                $('#updateTask').modal('show');
            }
        },
        rowTemplate: "<div ng-dblclick=\"grid.appScope.onDblClick(row)\" ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell ></div>",

        noUnselect: true,
        columnDefs: [{
            field: 'message',
            displayName: 'What to do?'
        }, {
            field: 'status',
            displayName: 'Status'
        }, {
            field: 'priority',
            displayName: 'Priority'
        }
        ]
    };


    $scope.gridOptions.onRegisterApi = function (gridApi) {
        $scope.gridApi = gridApi;
        gridApi.selection.on.rowSelectionChanged($scope, function (row) {
            if (row.isSelected) {
                rowSelectedEntity = row.entity;
                SelectedList = {
                    message: rowSelectedEntity.message,
                    priority: rowSelectedEntity.priority,
                    status: rowSelectedEntity.status,
                    username: $scope.username
                };
                // console.log(rowSelectedEntity);
                $scope.displayView = true;
            } else {
                $scope.displayView = false;
            }
        });
    };

    $scope.removeToList = function () {

        if (!rowSelectedEntity) {
            alert('You dont have any selected item.')
        } else {

            //POST
            $http({
                method: 'PUT',
                url: 'login/removeItem',
                data: SelectedList
            }).success(function (data) {
                alert('Successfully Removed!')
                $scope.gridOptions.data.splice($scope.gridOptions.data.indexOf(rowSelectedEntity), 1);
            }).error(function (error) {
                console.log(error);
            });
        }
    };

    $scope.addButtonClicked = function () {
        $('#newTodoList').modal('show');
    };


    $scope.addTodoButtonClicked = function () {

        var newTask = {
            message: $scope.newTask,
            priority: $scope.priority,
            status: 'Pending',
            username: $scope.username
        };
        console.log(newTask);

        $http({
            method: 'PUT',
            url: 'login/addTask',
            data: newTask
        }).success(function (data) {
            $scope.gridOptions.data.push(newTask);
        }).error(function (error) {
            console.log(error);
        });
    };

    $scope.updateTodoClicked = function () {

        var updateTask = {
            newTask: {
                message: $scope.selected.message,
                priority: $scope.selected.priority,
                status: $scope.selected.status
            },
            oldTask:{
                message: rowSelectedEntity.message,
                priority: rowSelectedEntity.priority,
                status: rowSelectedEntity.status
            },
            username: $scope.username

        };

        console.log(updateTask);

        $http({
            method: 'PUT',
            url: 'login/updateTask',
            data: updateTask
        }).success(function () {
            $scope.refreshData();
        }).error(function (error) {
            console.log(error);
        });
    };

    $scope.refreshData = function () {
        var getUsername = {
            username:$scope.username
        };

        $http({
            method: 'POST',
            url: 'login/getTask',
            data: getUsername
        }).success(function (data) {
            console.log(data[0].todolist);
            $scope.gridOptions.data = data[0].todolist;
        }).error(function (error) {
            console.error(error);
        });
    };

    $scope.logoutButtonClicked = function () {
      $location.path('/');
    };

});

