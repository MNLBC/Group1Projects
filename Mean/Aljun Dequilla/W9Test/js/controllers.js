userApp.controller('userCtrl', function ($rootScope, $scope, $location, userFactory) {

	$scope.allusers = [];
	userdata = false;
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
					userdata = data.data[0];				 	
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

userApp.controller('taskCtrl', function ($scope,userFactory) {
	$scope.userdata = userdata;
	$scope.usertask = $scope.userdata.task;
	$scope.selectedRow = false;
	$scope.selectedRowIndex = false;

	$scope.gridOptions = {
		enableRowSelection: true,
		enableRowHeaderSelection: false,
		enableFiltering: true,
		data: $scope.usertask,
		multiSelect: false,
		appScopeProvider: {
			onDblClick: function(row) {
				$('#updateTaskModal').modal('show');
				$scope.selectedRow=row.entity;
				$scope.updateEntryText = row.entity.entry;
			}
		},
		rowTemplate: "<div ng-dblclick=\"grid.appScope.onDblClick(row)\" ng-repeat=\"(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name\" class=\"ui-grid-cell\" ng-class=\"{ 'ui-grid-row-header-cell': col.isRowHeader }\" ui-grid-cell ></div>",
		noUnselect: true,
		columnDefs: [{
			field: 'entry',
			displayName: 'Entry'
		}, {
			field: 'status',
			displayName: 'Status'
		}, {
			field: 'priority',
			displayName: 'Priority'
		}]
	};

	$scope.getUserTask = function(){
		$scope.gridOptions.data = [];
		userFactory.getUser({
			"username": userdata.username,
			"password": userdata.password
		}).then(function(data){
			$scope.gridOptions.data = data.data[0].task;				 	
		});
	}

	$scope.gridOptions.onRegisterApi = function(gridApi) {
		$scope.gridApi = gridApi;
		gridApi.selection.on.rowSelectionChanged($scope, function(row) {
			if (row.isSelected) {
				$scope.selectedRow = row.entity;
				$scope.selectedRowIndex = $scope.gridOptions.data.indexOf(row.entity);
			}else{
				$scope.selectedRow = false;
			}
		});
	};

	$scope.addTask = function(){
		var newTask = {
			entry:$scope.addTextEntry,
			status:"Not Completed",
			priority: 1
		};

		userFactory.saveTask({
			user:{
				"username":userdata.username,
				"password":userdata.password
			},
			entry:$scope.addTextEntry,
			status:"Not Completed",
			priority: 1
		}).then(function(data){
			// console.log(data);
		});
		$scope.getUserTask();
		// $scope.gridOptions.data.push(newTask);
	}

	$scope.removeTask = function(){
		var row = $scope.selectedRow;
		userFactory.removeTask({
			user:{
				"username":userdata.username,
				"password":userdata.password
			},
			entry:row.entry,
			status:row.status,
			priority: row.priority
		}).then(function(data){
			// console.log(data);
		});
		$scope.getUserTask();
		// $scope.gridOptions.data.splice($scope.selectedRowIndex, 1);
	}

	$scope.updateTask = function(){
		var row = $scope.selectedRow;

		userFactory.updateTask({	
			user:{
				"username":userdata.username,
				"password":userdata.password
			},
			old:{
				entry:row.entry,
				status:row.status,
				priority: row.priority
			},
			new:{
				entry:$scope.updateEntryText,
				status:row.status,
				priority: row.priority
			}
		}).then(function(data){
			// console.log(data);
		});
		$scope.getUserTask();
		// $scope.gridOptions.data.splice($scope.selectedRowIndex, 1);
	}
});