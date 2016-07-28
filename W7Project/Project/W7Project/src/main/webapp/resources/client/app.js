/*
 * File: app.js
 *
 * This file was generated by Sencha Architect version 3.1.0.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 4.2.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 4.2.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

// @require @packageOverrides
Ext.Loader.setConfig({
    enabled: true
});


Ext.application({
	appFolder: 'resources/client/app',
	
    requires: [
        'Ext.rtl.*'
    ],
    models: [
             'ProductModel',
             'TrayModel',
             'TransactionModel',
             'ActiveUserModel',
             'TransactionDetailsModel',
             'CommentsModel',
             'UsersModel',
             'UserTypeModel'
         ],
         stores: [
             'ProductStore',
             'TrayStore',
             'TransactionStore',
             'ActiveUserStore',
             'TransactionDetailsStore',
             'CommentsStore',
             'UsersStore',
             'UserTypeStore'
         ],
         views: [
             'MyViewport',
             'RegisterWindow',
             'LoginWindow',
             'TrayWindow',
             'ProductViewWindow',
             'UserProfile',
             'ActiveUsersWindow',
             'TransactionDetails',
             'ContactUsWindow',
             'AdminUserPanel',
             'AdminCommentsPanel',
             'AdminTransactionsPanel',
             'AdminProductsPanel',
             'WinUserEdit'
         ],
    controllers: [
        'HomePage',
        'Windows',
        'AdminUser'
    ],
    name: 'BurgerQueen',

    launch: function() {
    	//Global task runner
    	   var runner = new Ext.util.TaskRunner();
    	   
    	   task = runner.newTask({
    	        run: function () {
    	        Ext.Ajax.request({
    	                  url : 'user/getAllUsers',
    	                  params : {
    	                      
    	                  },
    	                  scope : this,
    	                  success : function(response) {
    	                   Ext.MessageBox.alert('HI GROUP1','In my heart , we are the best group  ');
    	                  }
    	           });
    	        },
    	        interval: 60000
    	   });
    	
        Ext.create('BurgerQueen.view.MyViewport');
    }

});
