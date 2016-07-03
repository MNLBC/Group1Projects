Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'Company',
    views: ['Company.view.HomePage'],
    controllers: ['HomePage'],

    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
            {
                xtype: 'HomePage'
            }]
        });
    }
});