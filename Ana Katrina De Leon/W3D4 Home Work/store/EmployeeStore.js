Ext.define('Company.store.EmployeeStore', {
	extend : 'Ext.data.Store',
	model : 'Company.model.EmployeeModel',
	autoLoad : false,
	storeId : 'Employee'
});