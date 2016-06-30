Ext.onReady(function() {
 
    Ext.QuickTips.init();
 
    var win = new Ext.Window({
         id:'tblayout-win'
        ,width:400
        ,height:300
        ,layout:'table'
		,layoutConfig:{columns:3}
        ,border:false
        ,closable:false
        ,title:Ext.get('page-title').dom.innerHTML
		,defaults:{height:30}
		,items:[{
			 html:'cell 1'
		},{
			 html:'cell 2'
		},{
			 html:'cell 3'
		},{
			 html:'cell 4 - colspan 2'
			,colspan:2
		},{
			 html:'cell 5'
		},{
			 html:'cell 6 - colspan 2, rowspan 2'
			,rowspan:2
			,colspan:2
			,height:60
		},{
			 html:'cell 7'
		},{
			 html:'cell 8'
		},{
			 html:'cell 9'
		},{
			 html:'cell 10'
		},{
			 html:'cell 11'
		}]
    });
    win.show();
 
});