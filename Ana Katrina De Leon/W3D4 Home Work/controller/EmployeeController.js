Ext.define('Company.controller.EmployeeController', {
	extend : 'Ext.app.Controller',
	models : [ 'Company.model.EmployeeModel' ],
	stores : [ 'Company.store.EmployeeStore' ],
	views : [ 'Company.view.EmployeeView' ],
	refs : [ {
		ref : 'employeeGrid',
		selector : 'viewport EmployeeView'
	} ],

	init : function() {

		this.control({

			'viewport > EmployeeView button[itemId=btnCreate]' : {
				click : this.onCreateClick
			},
			'viewport > EmployeeView button[itemId=btnLoad]' : {
				click : this.onLoadClick
			},
			'viewport > EmployeeView button[itemId=btnSave]' : {
				click : this.onSaveClick
			},
			'viewport > EmployeeView button[itemId=btnDelete]' : {
				click : this.onDeleteClick
			}
		});
	},

	onCreateClick : function() {

		var employeeGrid = this.getEmployeeGrid();
		var employeeStore = employeeGrid.getStore();

		var employeeModel = Ext.create('Company.model.EmployeeModel');
		employeeModel.set("firstName", "New employee's first name");
		employeeModel.set("middleName", "New employees's middle name");
		employeeModel.set("lastName", "New employee's last name");
		employeeModel.set("birthDate", "11/01/2011");
		employeeModel.set("city", "New city");
		employeeModel.set("state", "New state");

		employeeStore.add(employeeModel);

		employeeGrid.editingPlugin.startEdit(employeeModel, 3);

	},

	onSaveClick : function() {
		var employeeGrid = this.getEmployeeGrid();
		var employeeStore = employeeGrid.getStore();

		// fires create, update and delete request when calling sync and commit
		// changes in the store when autoSync=false
		employeeStore.sync({
			success : function(batch, eOpts) {
				Ext.Msg.alert('Status', 'Changes saved successfully.');
			},
			failure : function(batch, eOpts) {
				Ext.Msg.alert('Status', 'Request failed.');
			}
		});
	},
	onLoadClick : function() {
		var employeeStore = Ext.getStore('Company.store.EmployeeStore');
		employeeStore.load();
	},

	onDeleteClick : function() {

		var employeeGrid = this.getEmployeeGrid();
		var employeeStore = employeeGrid.getStore();

		// delete selected rows if selModel is checkboxmodel
		var selectedRows = employeeGrid.getSelectionModel().getSelection();

		if (selectedRows.length)
			employeeStore.remove(selectedRows);
		else
			Ext.Msg.alert('Status',
					'Please select at least one record to delete!');
	}
});