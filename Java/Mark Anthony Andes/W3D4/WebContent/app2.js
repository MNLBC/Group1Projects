Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'Company',
    views: ['Company.view.EmployeeMaster'],
    controllers: ['EmployeeMaster2'],

    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
            {
                xtype: 'EmployeeMaster'
            }]
        });
    }
});