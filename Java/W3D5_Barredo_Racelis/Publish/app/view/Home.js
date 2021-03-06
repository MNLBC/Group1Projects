/*
 * File: app/view/Home.js
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

Ext.define('Project.view.Home', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Project.view.HomePanel',
        'Project.view.SearchPanel',
        'Project.view.InventoryPanel',
        'Project.view.UserPanel',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button',
        'Ext.menu.Menu',
        'Ext.menu.Item',
        'Ext.toolbar.Fill',
        'Ext.form.Label'
    ],

    itemId: 'homeViewport',
    layout: 'border',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    region: 'center',
                    title: 'Book Management System',
                    layout: {
                        type: 'vbox',
                        align: 'stretch'
                    },
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            dock: 'top',
                            items: [
                                {
                                    xtype: 'button',
                                    itemId: 'homeButton',
                                    ui: 'menubarbtn',
                                    text: 'Home'
                                },
                                {
                                    xtype: 'button',
                                    itemId: 'searchButton',
                                    ui: 'menubarbtn',
                                    text: 'Search'
                                },
                                {
                                    xtype: 'button',
                                    hidden: true,
                                    itemId: 'inventoryBtn',
                                    ui: 'menubarbtn',
                                    text: 'System',
                                    menu: {
                                        xtype: 'menu',
                                        items: [
                                            {
                                                xtype: 'menuitem',
                                                itemId: 'bookMenuBtn',
                                                text: 'Books'
                                            },
                                            {
                                                xtype: 'menuitem',
                                                itemId: 'userMenuBtn',
                                                text: 'Users'
                                            }
                                        ]
                                    }
                                }
                            ]
                        },
                        {
                            xtype: 'toolbar',
                            dock: 'bottom',
                            items: [
                                {
                                    xtype: 'tbfill'
                                },
                                {
                                    xtype: 'label',
                                    hidden: true,
                                    itemId: 'currentUsername',
                                    text: 'User Name'
                                },
                                {
                                    xtype: 'button',
                                    itemId: 'showLoginWindow',
                                    text: 'Login'
                                },
                                {
                                    xtype: 'button',
                                    itemId: 'signupBtn',
                                    text: 'Signup'
                                },
                                {
                                    xtype: 'button',
                                    hidden: true,
                                    itemId: 'logoutbtn',
                                    text: 'Logout'
                                }
                            ]
                        }
                    ],
                    items: [
                        {
                            xtype: 'mypanel12',
                            height: 20,
                            itemId: 'homePanel',
                            flex: 1
                        },
                        {
                            xtype: 'mypanel2',
                            hidden: true,
                            flex: 1
                        },
                        {
                            xtype: 'inventorypanel1',
                            hidden: true,
                            flex: 1
                        },
                        {
                            xtype: 'mypanel13',
                            hidden: true,
                            itemId: 'userPanel',
                            flex: 1
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});