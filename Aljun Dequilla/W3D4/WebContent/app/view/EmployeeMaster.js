Ext
		.define(
				'School.view.EmployeeMaster',
				{
					extend : 'Ext.form.Panel',
					alias : 'widget.EmployeeMaster',
					config : {},
					constructor : function(config) {
						this.initConfig(config);
						return this.callParent(arguments);
					},
					width : '100%',
					height : 400,

					clearForm : function() {
						this.getForm().getFields().each(function(field) {
							field.validateOnChange = false;
							field.setValue('');
							field.resetOriginalValue();
						});
					},
					initComponent : function() {
						var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';

						Ext.apply(this, {
							id : 'EmployeeMasterId',
							title : 'Employee Information',
							resizable : false,
							collapsible : true,
							bodyPadding : '5',
							buttonAlign : 'center',
							border : false,
							trackResetOnLoad : true,
							layout : {
								type : 'vbox'
							},
							fieldDefaults : {
								xtype : 'textfield',
								msgTarget : 'side',
								labelAlign : 'top',
								labelStyle : 'font-weight:bold'
							},
							items : [ {
								xtype : 'fieldcontainer',
								layout : 'hbox',
								defaultType : 'textfield',
								width : '100%',
								fieldDefaults : {
									labelAlign : 'top',
									labelStyle : 'font-weight:bold'
								},
								items : [ {
									fieldLabel : 'Id',
									name : 'Id',
									readOnly : true,
									width : 35
								}, {
									fieldLabel : 'First Name',
									flex : 1,
									name : 'firstName',
									afterLabelTextTpl : required,
									margin : '0 0 0 5',
									allowBlank : false
								}, {
									name : 'middleName',
									width : 150,
									margin : '0 0 0 5',
									fieldLabel : 'Middle Name:'
								}, {
									fieldLabel : 'Last Name',
									flex : 1,
									margin : '0 0 0 5',
									name : 'lastName'

								} ]
							}, {
								xtype : 'datefield',
								fieldLabel : 'Date of Birth',
								name : 'birthDate'

							}, {
								xtype : 'textfield',
								fieldLabel : 'Address',
								width : '100%',
								name : 'address1'
							}, {
								xtype : 'textfield',
								hideLabel : true,
								name : 'address2',
								width : '100%',
								fieldLabel : 'address2'

							}, {
								xtype : 'textfield',
								fieldLabel : 'City',
								width : '100%',
								name : 'city'
							}, {
								xtype : 'textfield',
								fieldLabel : 'state',
								width : '100%',
								name : 'state'
							} ],
							buttons : [ {
								text : 'Create',
								itemId : 'btnCreate',
								formBind : true
							}, {
								text : 'Read Data',
								itemId : 'btnLoad'
							},

							{
								text : 'Update',
								itemId : 'btnUpdate',

								formBind : true
							}, {
								text : 'Delete',
								itemId : 'btnDelete',
								formBind : true
							}, {
								text : 'Reset',
								itemId : 'btnReset'
							}, {
								text : 'Clear',
								itemId : 'btnClear'
							} ]
						});
						this.callParent(arguments);
					}
				});