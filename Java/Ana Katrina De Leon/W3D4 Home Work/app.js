Ext.application({
	requires : [ 'Ext.container.Viewport' ],
	name : 'Company',
	controllers : [ 'EmployeeController' , 'EmployeeController2'],
	views : [ 'Company.view.EmployeeView2' ],

	launch : function() {
		Ext.create('Ext.form.Panel', {
			renderTo : Ext.getBody(),
			title : "Select an action",
			layout : 'auto',
			collapsible : true,
			bodyPadding : '40',
			height : 150,
			items : [ {
				xtype : 'toolbar',
				layout : {
					type : 'hbox',
					pack : 'center'
				},
				items : [ {
					xtype : 'button',
					text : 'View Information',
					handler : function() {
						Ext.create('Ext.container.Viewport', {
							layout : 'anchor',
							closable: true,
							items : [ {
								xtype : 'EmployeeView'
							} ]
						});
					}
				}, {
					xtype : 'button',
					text : 'Register',
					handler : function() {
						Ext.create('Ext.container.Viewport', {
							layout : 'fit',
							closable: true,
							items : [ {
								xtype : 'EmployeeView2'
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