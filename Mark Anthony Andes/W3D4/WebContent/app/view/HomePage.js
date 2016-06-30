Ext.define('Company.view.HomePage', {
	extend : 'Ext.form.Panel',
	alias : 'widget.HomePage',
	config : {},
	constructor : function(config) {
		this.initConfig(config);
		return this.callParent(arguments);
	},

	initComponent : function() {

		Ext.apply(this, {
			items : [ {
				xtype : 'button',
				text : '1st Page',
				itemId : 'btnEmpInfo'
			}, {
				xtype : 'button',
				text : '2nd Page',
				itemId : 'btnEmpCreate'
			},

			{
				xtype : 'button',
				text : '3rd Page (Dyanamic Table)',
				itemId : 'btnDynTbl'
			} ]
		});
		this.callParent(arguments);
	}
});