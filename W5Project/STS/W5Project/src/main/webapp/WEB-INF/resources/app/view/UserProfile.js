/*
 * File: app/view/UserProfile.js
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

Ext.define('BurgerQueen.view.UserProfile', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.userprofile',

    requires: [
        'Ext.form.field.Display',
        'Ext.grid.Panel',
        'Ext.grid.column.Column',
        'Ext.grid.View'
    ],

    height: 431,
    id: 'UserProfile',
    itemId: 'UserProfile',
    width: 611,
    layout: 'fit',
    header: false,
    title: 'My Profile',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'container',
                    padding: '0, 100, 0, 100',
                    items: [
                        {
                            xtype: 'displayfield',
                            height: 50,
                            itemId: 'usernameProfile',
                            width: 800,
                            fieldLabel: 'Username',
                            value: 'Display Field',
                            inputId: 'userName'
                        },
                        {
                            xtype: 'displayfield',
                            height: 50,
                            itemId: 'firstnameProfile',
                            width: 800,
                            fieldLabel: 'First name',
                            value: 'Display Field',
                            inputId: 'firstName'
                        },
                        {
                            xtype: 'displayfield',
                            height: 50,
                            itemId: 'middlenameProfile',
                            width: 800,
                            fieldLabel: 'Middle name:',
                            value: 'Display Field',
                            inputId: 'middleName'
                        },
                        {
                            xtype: 'displayfield',
                            height: 50,
                            id: 'lastnameProfile',
                            itemId: 'lastnameProfile',
                            width: 800,
                            fieldLabel: 'Last name',
                            value: 'Display Field',
                            inputId: 'lastName'
                        },
                        {
                            xtype: 'displayfield',
                            height: 50,
                            id: 'addressProfile',
                            itemId: 'addressProfile',
                            width: 800,
                            fieldLabel: 'Address',
                            value: 'Display Field',
                            inputId: 'address'
                        },
                        {
                            xtype: 'displayfield',
                            height: 50,
                            id: 'emailProfile',
                            itemId: 'emailProfile',
                            width: 800,
                            fieldLabel: 'E-mail',
                            value: 'Display Field',
                            inputId: 'email'
                        },
                        {
                            xtype: 'displayfield',
                            height: 50,
                            id: 'contactnumProfile',
                            itemId: 'contactnumProfile',
                            width: 800,
                            fieldLabel: 'Contact:',
                            value: 'Display Field',
                            inputId: 'userProfileWindow'
                        },
                        {
                            xtype: 'gridpanel',
                            id: 'TransacHistoryGrid',
                            itemId: 'transactionHistoryGrid',
                            autoScroll: true,
                            title: 'My Grid Panel',
                            hideHeaders: true,
                            store: 'TransactionStore',
                            columns: [
                                {
                                    xtype: 'gridcolumn',
                                    dataIndex: 'Id',
                                    text: 'Transaction Id',
                                    flex: 1
                                },
                                {
                                    xtype: 'gridcolumn',
                                    dataIndex: 'Status',
                                    text: 'Transaction Status',
                                    flex: 1
                                }
                            ],
                            listeners: {
                                itemdblclick: {
                                    fn: me.onTransacHistoryGridItemDblClick,
                                    scope: me
                                }
                            }
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    },

    onTransacHistoryGridItemDblClick: function(dataview, record, item, index, e, eOpts) {
        //         var transactionStore = Ext.getStore('TransactionStore');

        //         var productGrid = Ext.getCmp('TransacHistoryGrid'),
        //             selectModel = productGrid.getSelectionModel(),
        //             selectedProduct = selectModel.getSelection()[0].data;

                console.log('record mo '+record);
                 Ext.create('BurgerQueen.view.TransactionDetails',{
                    transaction : record }).show();
    }

});