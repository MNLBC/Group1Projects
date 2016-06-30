Ext.application({
    requires: ['Ext.container.Viewport' ],
    name : 'School',
    controllers : ['StudentMaster'],

    launch: function () {
        
        Ext.create('School.view.StudentTab', 
        		{renderTo: Ext.getBody()});
    }
});