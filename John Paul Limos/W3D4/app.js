Ext.application({
	requires : [ 'Ext.container.Viewport' ],
	name : 'Company',
	controllers : [ 'EmployeeInfo' , 'EmployeeInfo2'],
	views : [ 'Company.view.EmployeeMaster' ],

	launch : function() {
		Ext.create('Ext.form.Panel', {
			renderTo : Ext.getBody(),
			title : "W3D4 Homework",
			layout : 'auto',
			collapsible : true,
			items : [ {
				xtype : 'toolbar',
				layout : {
					type : 'hbox',
					pack : 'center'
				},
				items : [ {
					xtype : 'button',
					text : 'View Employees',
					handler : function() {
						Ext.create('Ext.container.Viewport', {
							layout : 'anchor',
							closable: true,
							items : [ {
								xtype : 'EmployeeGrid'
							} ]
						});
					}
				}, {
					xtype : 'button',
					text : 'Add Employee',
					handler : function() {
						Ext.create('Ext.container.Viewport', {
							layout : 'fit',
							closable: true,
							items : [ {
								xtype : 'EmployeeMaster'
							} ]
						});
					}

				}, {
					xtype : 'button',
					text : 'Create Table',
					handler : function() {
						Ext.create('Ext.container.Viewport', {
							layout : 'fit',
							items : [ {
								xtype : 'grid',
								title : 'Table View',
								columns : [ {
									text : 'First Name'
								}, {
									text : 'Last Name'
								}, {
									text : 'Email'
								}, {
									text : 'Birthdate'
								} ]
							} ]
						});
					}

				} ]

			} ]
		});

	}
});