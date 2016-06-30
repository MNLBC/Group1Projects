Ext.application({
	requires : [ 'Ext.container.Viewport' ],
	name : 'School',
	controllers : [ 'EmployeeMaster' ],

	launch : function() {

		Ext.create('School.view.EmployeeTab', {
			renderTo : Ext.getBody()
		});
	}
});