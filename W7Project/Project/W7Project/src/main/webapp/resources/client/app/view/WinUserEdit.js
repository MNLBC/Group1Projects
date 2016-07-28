/*
 * File: resources/app/view/WinUserEdit.js
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

Ext.define('BurgerQueen.view.WinUserEdit', {
    extend: 'Ext.window.Window',

    requires: [
        'Ext.panel.Panel',
        'Ext.form.field.ComboBox',
        'Ext.button.Button'
    ],

    height: 229,
    id: 'winUserEdit',
    itemId: 'winUserEdit',
    width: 329,
    header: false,
    title: 'My Window',
    modal: true,

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    html: '<center><div id="nav"><h1 style = \'font-family: Arial; color:#565652;\' >Manage User</h1></div></center>',
                    header: false,
                    title: 'Manage User'
                },
                {
                    xtype: 'combobox',
                    id: 'UserManageType',
                    itemId: 'UserManageType',
                    margin: 20,
                    fieldLabel: 'User Type',
                    labelStyle: 'text-align: center; font-family:\'Abel\' ; font-size:18px;',
                    fieldStyle: 'text-align: center; font-family:\'Abel\' ; font-size:18px;',
                    displayField: 'type',
                    queryMode: 'local',
                    store: 'UserTypeStore',
                    valueField: 'type'
                },
                {
                    xtype: 'textfield',
                    id: 'manageUserPoints',
                    itemId: 'manageUserPoints',
                    margin: 20,
                    fieldLabel: 'Points',
                    labelStyle: 'text-align: center; font-family:\'Abel\' ; font-size:18px;',
                    fieldStyle: 'text-align: center; font-family:\'Abel\' ; font-size:18px;',
                    inputType: 'number'
                },
                {
                    xtype: 'button',
                    height: 30,
                    id: 'manageUserBtnConfirm',
                    itemId: 'manageUserBtnConfirm',
                    margin: '0 0 0 100',
                    padding: '',
                    width: '50%',
                    text: 'Confirm'
                },
                {
                    xtype: 'container'
                }
            ]
        });

        me.callParent(arguments);
    }

});