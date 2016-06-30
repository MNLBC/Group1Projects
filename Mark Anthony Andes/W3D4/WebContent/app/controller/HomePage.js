Ext.define('Company.controller.HomePage', {
	extend : 'Ext.app.Controller',
	views : [ 'Company.view.HomePage' ],

	refs : [ {
		ref : 'homePageForm',
		selector : 'viewport > HomePage'
	} ],

	init : function() {
		this.control({

			'viewport > HomePage button[itemId=btnEmpInfo]' : {
				click : this.onFirstPageClick
			},
			'viewport > HomePage button[itemId=btnEmpCreate]' : {
				click : this.onSecondPageClick
			},
			'viewport > HomePage button[itemId=btnDynTbl]' : {
				click : this.onThirdPageClick
			}
		});
	},
	onFirstPageClick : function() {
		window.location.assign("/W3D4/EmployeeInfo.html");

	},
	onSecondPageClick : function() {
		window.location.assign("/W3D4/EmployeeCreate.html");
	},
	onThirdPageClick : function() {
		window.location.assign("/W3D4/EmployeeCreate.html");
	}
});