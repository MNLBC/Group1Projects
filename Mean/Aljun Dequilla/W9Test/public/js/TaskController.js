userApp.controller('taskCtrl', function ($scope, $location,userFactory) {
	$scope.userdata = userdata;
	$scope.usertask = $scope.userdata.task;
	$scope.selectedRow = false;
	$scope.selectedRowIndex = false;
	$scope.addPriorityText = 1;

	$scope.logout = function(){
		$location.path('/');
	};

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
				$scope.updatePriorityText = row.entity.priority;
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
		userFactory.saveTask({
			user:{
				"username":userdata.username,
				"password":userdata.password
			},
			entry:$scope.addTextEntry,
			status:"Pending",
			priority: $scope.addPriorityText
		}).then(function(data){
			$scope.getUserTask();
		});
		
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
			$scope.getUserTask();
		});
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
				priority:row.priority
			},
			new:{
				entry:$scope.updateEntryText,
				status:row.status,
				priority:$scope.updatePriorityText
			}
		}).then(function(data){
			$scope.getUserTask();
		});

		// $scope.gridOptions.data.splice($scope.selectedRowIndex, 1);
	}

	$scope.markComplete = function(){
		var row = $scope.selectedRow;

		userFactory.updateTask({	
			user:{
				"username":userdata.username,
				"password":userdata.password
			},
			old:{
				entry:row.entry,
				status:row.status,
				priority:row.priority
			},
			new:{
				entry:row.entry,
				status:"Completed",
				priority:row.priority
			}
		}).then(function(data){
			$scope.getUserTask();
		});
	}
});