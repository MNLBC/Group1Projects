/*
 * File: resources/app/view/UserProfile.js
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
        'Ext.Img',
        'Ext.form.field.Display',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button',
        'Ext.grid.Panel',
        'Ext.grid.column.Column',
        'Ext.grid.View'
    ],

    height: 691,
    id: 'UserProfile',
    itemId: 'UserProfile',
    width: 612,
    layout: 'fit',
    header: false,
    title: 'My Profile',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'container',
                    padding: '',
                    layout: {
                        type: 'vbox',
                        align: 'stretch'
                    },
                    items: [
                        {
                            xtype: 'container',
                            height: 20,
                            layout: 'anchor'
                        },
                        {
                            xtype: 'container',
                            height: 349,
                            layout: {
                                type: 'hbox',
                                align: 'stretch',
                                pack: 'center'
                            },
                            items: [
                                {
                                    xtype: 'container',
                                    flex: 1
                                },
                                {
                                    xtype: 'container',
                                    flex: 1,
                                    height: 325,
                                    rtl: true,
                                    layout: 'anchor',
                                    items: [
                                        {
                                            xtype: 'image',
                                            maxHeight: 300,
                                            maxWidth: 200,
                                            minHeight: 300,
                                            minWidth: 200,
                                            padding: '0px 0px 0px 80px',
                                            rtl: true,
                                            width: '',
                                            src: 'resources/avatar.png'
                                        }
                                    ]
                                },
                                {
                                    xtype: 'container',
                                    flex: 1,
                                    height: 309,
                                    width: 311,
                                    items: [
                                        {
                                            xtype: 'displayfield',
                                            height: 50,
                                            id: 'fullnameProfile',
                                            itemId: 'fullnameProfile',
                                            width: 800,
                                            fieldLabel: '',
                                            labelStyle: 'font-family: \'Abel\'; font-size: 15px;',
                                            value: 'Display Field',
                                            fieldStyle: 'font-family: \'Abel\'; font-size: 25px; font-weight: bold;',
                                            inputId: 'lastName'
                                        },
                                        {
                                            xtype: 'displayfield',
                                            height: 50,
                                            id: 'usernameProfile',
                                            itemId: 'usernameProfile',
                                            width: 800,
                                            fieldLabel: 'Username',
                                            labelStyle: 'font-family: \'Abel\'; font-size: 15px;',
                                            labelWidth: 70,
                                            value: 'Display Field',
                                            fieldStyle: 'font-family: \'Abel\'; font-size: 15px;',
                                            inputId: 'userName'
                                        },
                                        {
                                            xtype: 'displayfield',
                                            height: 50,
                                            id: 'addressProfile',
                                            itemId: 'addressProfile',
                                            width: 800,
                                            fieldLabel: 'Address',
                                            labelStyle: 'font-family: \'Abel\'; font-size: 15px;',
                                            labelWidth: 70,
                                            value: 'Display Field',
                                            fieldStyle: 'font-family: \'Abel\'; font-size: 15px;',
                                            inputId: 'address'
                                        },
                                        {
                                            xtype: 'displayfield',
                                            height: 50,
                                            id: 'emailProfile',
                                            itemId: 'emailProfile',
                                            width: 800,
                                            fieldLabel: 'E-mail',
                                            labelStyle: 'font-family: \'Abel\'; font-size: 15px;',
                                            labelWidth: 70,
                                            value: 'Display Field',
                                            fieldStyle: 'font-family: \'Abel\'; font-size: 15px;',
                                            inputId: 'email'
                                        },
                                        {
                                            xtype: 'displayfield',
                                            height: 50,
                                            id: 'contactnumProfile',
                                            itemId: 'contactnumProfile',
                                            width: 800,
                                            fieldLabel: 'Contact:',
                                            labelStyle: 'font-family: \'Abel\'; font-size: 15px;',
                                            labelWidth: 70,
                                            value: 'Display Field',
                                            fieldStyle: 'font-family: \'Abel\'; font-size: 15px;',
                                            inputId: 'userProfileWindow'
                                        },
                                        {
                                            xtype: 'displayfield',
                                            id: 'userLevel',
                                            fieldLabel: 'User Level',
                                            labelStyle: 'font-family: \'Abel\'; font-size: 15px;',
                                            labelWidth: 70,
                                            value: 'Display Field',
                                            fieldStyle: 'font-family: \'Abel\'; font-size: 15px;'
                                        }
                                    ]
                                },
                                {
                                    xtype: 'container',
                                    flex: 1,
                                    height: 293
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            height: 20,
                            layout: 'anchor'
                        },
                        {
                            xtype: 'toolbar',
                            layout: {
                                type: 'hbox',
                                pack: 'end'
                            },
                            items: [
                                {
                                    xtype: 'button',
                                    id: 'editProfileButton',
                                    itemId: 'editProfileButton',
                                    text: 'Edit Profile'
                                },
                                {
                                    xtype: 'button',
                                    id: 'profileOpenChangePasswordWindow',
                                    itemId: 'profileOpenChangePasswordWindow',
                                    text: 'Change Password'
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            flex: 1,
                            autoScroll: true,
                            items: [
                                {
                                    xtype: 'gridpanel',
                                    id: 'TransacHistoryGrid',
                                    itemId: 'transactionHistoryGrid',
                                    autoScroll: true,
                                    title: 'Recent Transactions',
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
                }
            ]
        });

        me.callParent(arguments);
    },

    onTransacHistoryGridItemDblClick: function(dataview, record, item, index, e, eOpts) {


                 Ext.create('BurgerQueen.view.TransactionDetails',{
                    transaction : record }).show();
    }

});