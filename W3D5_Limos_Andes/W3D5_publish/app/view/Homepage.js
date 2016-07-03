/*
 * File: app/view/Homepage.js
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

Ext.define('BookingManagementSystem.view.Homepage', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Ext.toolbar.Toolbar',
        'Ext.form.Label',
        'Ext.tab.Panel',
        'Ext.tab.Tab',
        'Ext.form.field.Text',
        'Ext.grid.Panel',
        'Ext.grid.View',
        'Ext.grid.column.Number',
        'Ext.selection.RowModel'
    ],

    id: 'homePage',
    layout: 'fit',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    layout: 'fit',
                    frameHeader: false,
                    header: false,
                    overlapHeader: false,
                    title: 'Booking Ma System',
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
                                    xtype: 'label',
                                    id: 'welcomeUserLabel',
                                    text: 'Welcome '
                                },
                                {
                                    xtype: 'button',
                                    text: 'Logout'
                                }
                            ]
                        }
                    ],
                    items: [
                        {
                            xtype: 'tabpanel',
                            activeTab: 0,
                            items: [
                                {
                                    xtype: 'panel',
                                    layout: 'fit',
                                    title: 'Books',
                                    tabConfig: {
                                        xtype: 'tab',
                                        flex: 1
                                    },
                                    dockedItems: [
                                        {
                                            xtype: 'toolbar',
                                            dock: 'top',
                                            items: [
                                                {
                                                    xtype: 'textfield',
                                                    fieldLabel: 'Enter Title'
                                                },
                                                {
                                                    xtype: 'button',
                                                    text: 'Search'
                                                }
                                            ]
                                        },
                                        {
                                            xtype: 'toolbar',
                                            dock: 'bottom',
                                            items: [
                                                {
                                                    xtype: 'button',
                                                    id: 'addBookButton',
                                                    text: 'Add Book'
                                                },
                                                {
                                                    xtype: 'button',
                                                    disabled: true,
                                                    id: 'viewBookButton',
                                                    text: 'View/Edit Book'
                                                },
                                                {
                                                    xtype: 'button',
                                                    disabled: true,
                                                    id: 'deleteBookButton',
                                                    text: 'Delete Book'
                                                }
                                            ]
                                        }
                                    ],
                                    items: [
                                        {
                                            xtype: 'gridpanel',
                                            id: 'booksGrid',
                                            title: 'All books',
                                            store: 'bookStore',
                                            columns: [
                                                {
                                                    xtype: 'gridcolumn',
                                                    dataIndex: 'title',
                                                    text: 'Title',
                                                    flex: 1
                                                },
                                                {
                                                    xtype: 'gridcolumn',
                                                    dataIndex: 'author',
                                                    text: 'Author',
                                                    flex: 1
                                                },
                                                {
                                                    xtype: 'gridcolumn',
                                                    dataIndex: 'description',
                                                    text: 'Description',
                                                    flex: 1
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'available',
                                                    text: 'Available for rental',
                                                    flex: 1,
                                                    format: '00'
                                                },
                                                {
                                                    xtype: 'gridcolumn',
                                                    dataIndex: 'checkoutBy',
                                                    text: 'CheckoutBy',
                                                    flex: 1
                                                }
                                            ],
                                            selModel: Ext.create('Ext.selection.RowModel', {

                                            })
                                        }
                                    ]
                                },
                                {
                                    xtype: 'panel',
                                    title: 'User Profile',
                                    tabConfig: {
                                        xtype: 'tab',
                                        flex: 1
                                    }
                                },
                                {
                                    xtype: 'panel',
                                    layout: 'fit',
                                    title: 'Users',
                                    tabConfig: {
                                        xtype: 'tab',
                                        flex: 1
                                    },
                                    items: [
                                        {
                                            xtype: 'gridpanel',
                                            title: 'All Users',
                                            store: 'userStore',
                                            columns: [
                                                {
                                                    xtype: 'gridcolumn',
                                                    dataIndex: 'firstName',
                                                    text: 'First Name',
                                                    flex: 1
                                                },
                                                {
                                                    xtype: 'gridcolumn',
                                                    dataIndex: 'lastName',
                                                    text: 'Last Name',
                                                    flex: 1
                                                },
                                                {
                                                    xtype: 'gridcolumn',
                                                    dataIndex: 'userName',
                                                    text: 'User Name',
                                                    flex: 1
                                                },
                                                {
                                                    xtype: 'gridcolumn',
                                                    dataIndex: 'password',
                                                    text: 'Password',
                                                    flex: 1
                                                },
                                                {
                                                    xtype: 'gridcolumn',
                                                    dataIndex: 'address',
                                                    text: 'Address',
                                                    flex: 1
                                                },
                                                {
                                                    xtype: 'gridcolumn',
                                                    dataIndex: 'contactNo',
                                                    text: 'Contact No',
                                                    flex: 1
                                                },
                                                {
                                                    xtype: 'gridcolumn',
                                                    dataIndex: 'email',
                                                    text: 'Email',
                                                    flex: 1
                                                },
                                                {
                                                    xtype: 'gridcolumn',
                                                    dataIndex: 'booksAtHand',
                                                    text: 'Books at hand',
                                                    flex: 1
                                                }
                                            ]
                                        }
                                    ],
                                    dockedItems: [
                                        {
                                            xtype: 'toolbar',
                                            dock: 'bottom',
                                            items: [
                                                {
                                                    xtype: 'button',
                                                    text: 'MyButton'
                                                },
                                                {
                                                    xtype: 'button',
                                                    text: 'MyButton'
                                                }
                                            ]
                                        },
                                        {
                                            xtype: 'toolbar',
                                            dock: 'top',
                                            items: [
                                                {
                                                    xtype: 'textfield',
                                                    fieldLabel: 'Enter UserName'
                                                },
                                                {
                                                    xtype: 'button',
                                                    text: 'Search'
                                                }
                                            ]
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});