Ext.define('School.view.StudentTab',
{
    extend: 'Ext.tab.Panel',
    requires: [
               'School.view.StudentGrid',
               'Ext.tab.Tab',
               'Ext.form.Panel',
               'Ext.grid.Panel'
           ],
    
    alias : 'widget.StudentTab',
    width : '100%',
    height : '90%',
    activeTab: 0,

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    title: 'Tab 1',
                    items: [
                            {
                                xtype: 'StudentGrid'
                            }
                    ]
                },
                {
                    xtype: 'panel',
                    title: 'Tab 2',
                    items: [
                            {
                                xtype: 'StudentGrid'
                            }
                    ]
                },
                {
                    xtype: 'panel',
                    title: 'Tab 3',
                    items: [
                            {
                                xtype: 'StudentGrid'
                            }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});