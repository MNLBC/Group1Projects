Ext
		.define(
				'Company.controller.EmployeeController2',
				{
					extend : 'Ext.app.Controller',
					models : [ 'Company.model.EmployeeModel2' ],
					views : [ 'Company.view.EmployeeView2' ],

					refs : [ {
						ref : 'employeeMasterForm',
						selector : 'viewport > EmployeeView2'
					} ],

					init : function() {
						this
								.control({

									'viewport > EmployeeView2 button[itemId=btnCreate]' : {
										click : this.onCreateClick
									},
									'viewport > EmployeeView2 button[itemId=btnLoad]' : {
										click : this.onLoadClick
									},
									'viewport > EmployeeView2 button[itemId=btnUpdate]' : {
										click : this.onUpdateClick
									},
									'viewport > EmployeeView2 button[itemId=btnDelete]' : {
										click : this.onDeleteClick
									},
									'viewport > EmployeeView2 button[itemId=btnReset]' : {
										click : this.onResetClick
									},
									'viewport > EmployeeView2 button[itemId=btnClear]' : {
										click : this.onClearClick
									}
								});
					},

					onUpdateClick : function() {

						var empMaster = this.getEmployeeMasterForm();

						if (!empMaster.isDirty()) {
							Ext.Msg.alert('Status',
									'No pending changes to save.');
							return;
						} else if (!empMaster.isValid()) {
							Ext.Msg.alert('Status', 'Invalid data.');
							return;
						}

						var employeeModel = Ext
								.create('Company.model.EmployeeModel2');

						employeeModel.set(empMaster.getValues());

						var mask = new Ext.LoadMask(empMaster, {
							msg : "Updating..."
						});
						mask.show();

						employeeModel
								.save({
									scope : this, // controller would be
													// accessible inside load
									success : function(record, operation) {
										try {
											var resp = Ext
													.decode(operation.response.responseText);
											if (resp.success) {
												// set the root in proxy to
												// indicate where the student
												// data in the response
												var employee = Ext
														.create('Company.model.EmployeeModel2');
												employee.set(resp.data[0]);
												this.getEmployeeMasterForm()
														.loadRecord(employee);

												Ext.Msg
														.alert('Status',
																'Employee updated successfully.');
											} else
												Ext.Msg.alert('Status',
														resp.message);
										} catch (ex) {
											Ext.Msg.alert('Status',
													'Invalid data in server response: '
															+ ex.Message);

										}
										mask.hide();
									},
									failure : function(record, operation) {
										Ext.Msg
												.alert(
														'Save Failed',
														operation.response.responseText);
										try {
											var resp = Ext
													.decode(operation.response.responseText);
											Ext.Msg.alert('Status',
													resp.message);

										} catch (ex) {
											Ext.Msg.alert('Status',
													'Not a valid data.'
															+ ex.Message);
										}
										mask.hide();
									}
								});

					},

					onLoadClick : function() {

						var existingEmployee = Ext.ModelMgr
								.getModel('Company.model.EmployeeModel2');
						var empMaster = this.getEmployeeMasterForm();
						var mask = new Ext.LoadMask(empMaster, {
							msg : "Loading..."
						});
						mask.show();

						existingEmployee.load(1, {
							scope : this, // controller would be accessible
											// inside load
							failure : function(record, operation) {
								mask.hide();
								Ext.Msg.alert('Status',
										'Service request failed.');
							},
							success : function(record, operation) { // do
																	// something
																	// if the
																	// load
																	// succeeded
								// if service response object has same
								// properties and heirarchy as model object then
								// you can model.loadRecord(record)
								// otherwise you have to decode
								// operation.response.responseText, create model
								// object and populate valudes of decoded
								// response into model and then use
								// model.loadRecord()
								try {
									this.getEmployeeMasterForm().loadRecord(
											record);
									Ext.Msg.alert('Status',
											'Records loaded successfully.');

								} catch (ex) {
									Ext.Msg.alert('Status',
											'Invalid data in server response: '
													+ ex.Message);

								}
								mask.hide();
							}
						});

					},

					onCreateClick : function() {
						var empMaster = this.getEmployeeMasterForm();

						if (!empMaster.isDirty()) {
							Ext.Msg.alert('Status', 'No new data to create.');
							return;
						} else if (!empMaster.isValid()) {
							Ext.Msg.alert('Status', 'Invalid data.');
							return;
						}

						var employeeModel = Ext
								.create('Company.model.EmployeeModel2');

						employeeModel.set(empMaster.getValues());

						var mask = new Ext.LoadMask(empMaster, {
							msg : "Saving..."
						});
						mask.show();

						employeeModel.save({
							scope : this, // controller would be accessible
											// inside load
							success : function(record, operation) { // do
																	// something
																	// if the
																	// load
																	// succeeded
								// if service response object has same
								// properties and heirarchy as model object then
								// you can model.loadRecord(record)
								// otherwise you have to decode
								// operation.response.responseText, create model
								// object and populate valudes of decoded
								// response into model and then use
								// model.loadRecord()
								try {
									this.getEmployeeMasterForm().loadRecord(
											record);
									Ext.Msg.alert('Status',
											'Employee Saved Successfully!');

								} catch (ex) {
									Ext.Msg.alert('Status',
											'Invalid data in server response: '
													+ ex.Message);
								}
								mask.hide();
							},
							failure : function(record, operation) {
								mask.hide();
								Ext.Msg.alert('Status',
										'Service request failed.');
							}

						});

					},

					onDeleteClick : function() {

						var empMaster = this.getEmployeeMasterForm();

						if (!empMaster.getValues(false, false, false, true).Id) {
							Ext.Msg.alert('Status', 'Invalid or no data.');
							return;
						}

						var employeeModel = empMaster.getRecord();
						var mask = new Ext.LoadMask(empMaster, {
							msg : "Deleting..."
						});
						mask.show();

						employeeModel
								.destroy({
									scope : this, // controller would be
													// accessible inside load
									failure : function(record, operation) {
										mask.hide();
										Ext.Msg.alert('Status',
												'Service request failed.');
									},
									success : function(record, operation) {
										try {
											var resp = Ext
													.decode(operation.response.responseText);
											if (resp.success) { // check if
																// delete
																// succeded at
																// server side
												this.getEmployeeMasterForm()
														.clearForm();
											}

											Ext.Msg.alert('Status',
													resp.message);
										} catch (ex) {
											Ext.Msg.alert('Status',
													'Exception: ' + ex.Message);
										}
										mask.hide();
									}
								});
					},
					onResetClick : function() {
						this.getEmployeeMasterForm().getForm().reset();
					},
					onClearClick : function() {
						this.getEmployeeMasterForm().clearForm();
					}
				});