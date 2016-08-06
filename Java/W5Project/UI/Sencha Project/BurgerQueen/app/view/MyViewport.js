/*
 * File: app/view/MyViewport.js
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

Ext.define('BurgerQueen.view.MyViewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'BurgerQueen.view.Products',
        'BurgerQueen.view.UserProfile',
        'Ext.panel.Panel',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button',
        'Ext.form.field.Display',
        'Ext.Img'
    ],

    html: '<link href=\'http://fonts.googleapis.com/css?family=Abel\' rel=\'stylesheet\' type=\'text/css\'>',
    layout: 'fit',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    id: 'BurgerQueen',
                    itemId: 'BurgerQueen',
                    layout: 'fit',
                    header: false,
                    title: 'My Panel',
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            dock: 'top',
                            layout: {
                                type: 'hbox',
                                pack: 'end'
                            },
                            items: [
                                {
                                    xtype: 'button',
                                    itemId: 'loginButton',
                                    ui: 'menubarbtn',
                                    text: 'Login'
                                },
                                {
                                    xtype: 'button',
                                    id: 'registerButton',
                                    itemId: 'registerButton',
                                    ui: 'menubarbtn',
                                    text: 'Register'
                                },
                                {
                                    xtype: 'button',
                                    hidden: true,
                                    id: 'myProfileButton',
                                    itemId: 'myProfileButton',
                                    ui: 'menubarbtn',
                                    text: 'My Profile'
                                },
                                {
                                    xtype: 'button',
                                    hidden: true,
                                    id: 'trayButton',
                                    itemId: 'trayButton',
                                    ui: 'menubarbtn',
                                    text: 'My Tray'
                                },
                                {
                                    xtype: 'button',
                                    hidden: true,
                                    itemId: 'logoutButton',
                                    ui: 'menubarbtn',
                                    text: 'Logout'
                                },
                                {
                                    xtype: 'button',
                                    itemId: 'showUsersWindow',
                                    ui: 'menubarbtn',
                                    text: 'Active Users'
                                },
                                {
                                    xtype: 'displayfield',
                                    itemId: 'activeUsersCount',
                                    fieldLabel: '',
                                    labelWidth: 50,
                                    value: '0'
                                }
                            ]
                        },
                        {
                            xtype: 'toolbar',
                            dock: 'top',
                            layout: {
                                type: 'hbox',
                                pack: 'center'
                            },
                            items: [
                                {
                                    xtype: 'image',
                                    height: 60,
                                    width: 60,
                                    src: 'resources/images/burgerQueenLogo.png'
                                },
                                {
                                    xtype: 'button',
                                    id: 'allCategoriesButton',
                                    itemId: 'allCategoriesButton',
                                    style: 'font-family: \'Abel\';\n    font-size:30px;',
                                    ui: 'menubarbtn',
                                    text: 'All Categories |'
                                },
                                {
                                    xtype: 'button',
                                    itemId: 'beveragesButton',
                                    style: 'font-family: \'Abel\';\n    font-size:30px;',
                                    ui: 'menubarbtn',
                                    text: 'Beverages |'
                                },
                                {
                                    xtype: 'button',
                                    itemId: 'burgersButton',
                                    style: 'font-family: \'Abel\';\n    font-size:30px;',
                                    ui: 'menubarbtn',
                                    text: 'Burgers |'
                                },
                                {
                                    xtype: 'button',
                                    itemId: 'chickensButton',
                                    style: 'font-family: \'Abel\';\n    font-size:30px;',
                                    ui: 'menubarbtn',
                                    text: 'Chickens |'
                                },
                                {
                                    xtype: 'button',
                                    itemId: 'dessertsButton',
                                    style: 'font-family: \'Abel\';\n    font-size:30px;',
                                    ui: 'menubarbtn',
                                    text: 'Desserts |'
                                },
                                {
                                    xtype: 'button',
                                    itemId: 'sidesButton',
                                    style: 'font-family: \'Abel\';\n    font-size:30px;',
                                    ui: 'menubarbtn',
                                    text: 'Sides'
                                }
                            ]
                        }
                    ],
                    items: [
                        {
                            xtype: 'Products'
                        },
                        {
                            xtype: 'userprofile',
                            hidden: true
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});