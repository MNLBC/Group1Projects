Ext.define('Company.view.HomePage', 
{
    extend : 'Ext.form.Panel',
    alias : 'widget.HomePage',
    config : {},
    constructor : function(config){
        this.initConfig(config);
        return this.callParent(arguments);
    },
    
  
    initComponent : function(){
        
        Ext.apply(this, 
        {
            items : [{
            	 xtype : 'button',
                text : 'Employee Information',
                itemId : 'btnEmpInfo',
                id : 'btnEmpInfo2'
                
            }, 
            {
            	xtype : 'button',
                text : 'Employee Registration',
                itemId : 'btnEmpCreate'
            }, 
            
            {
            	xtype : 'button',
                text : 'Dynamic Table',
                itemId : 'btnDynTbl'
            },
            {
            xtype: 'panel',
            flex: 1,
            region: 'center',
            id: 'result',
            title: '',
            layout: {
                type: 'vbox',
                align: 'center',
                pack: 'center'
            }
            }
            ]
        });
        this.callParent(arguments);
    }
});