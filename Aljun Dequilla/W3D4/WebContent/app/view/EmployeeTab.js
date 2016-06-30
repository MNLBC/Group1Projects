Ext.define('School.view.EmployeeTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'School.view.EmployeeGrid', 'School.view.EmployeeMaster',
			'Ext.tab.Tab', 'Ext.form.Panel', 'Ext.grid.Panel' ],

	alias : 'widget.EmployeeTab',
	width : '100%',
	height : '90%',
	activeTab : 0,

	initComponent : function() {

		Ext.applyIf(this, {
			items : [ {
				xtype : 'EmployeeGrid',

			}, {
				xtype : 'EmployeeMaster'

			}, {
//				xtype : 'EmployeeGrid'
			} ]
		});

		this.callParent(arguments);
	}

});