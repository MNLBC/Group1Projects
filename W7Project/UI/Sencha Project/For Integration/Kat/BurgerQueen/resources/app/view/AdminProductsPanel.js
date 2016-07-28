/*
 * File: resources/app/view/AdminProductsPanel.js
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

Ext.define('BurgerQueen.view.AdminProductsPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.adminproductspanel',

    requires: [
        'Ext.grid.Panel',
        'Ext.grid.View',
        'Ext.grid.column.Column',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button'
    ],

    height: 434,
    id: 'AdminProductsPanel',
    itemId: 'AdminProductsPanel',
    width: 711,
    layout: 'fit',
    header: false,
    title: 'My Panel',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            dockedItems: [
                {
                    xtype: 'container',
                    dock: 'top',
                    height: 100,
                    width: 100
                },
                {
                    xtype: 'toolbar',
                    dock: 'bottom',
                    layout: {
                        type: 'hbox',
                        pack: 'end'
                    },
                    items: [
                        {
                            xtype: 'button',
                            id: 'adminCreateBtn',
                            itemId: 'adminCreateBtn',
                            text: 'Create Meal'
                        },
                        {
                            xtype: 'button',
                            id: 'adminDeleteBtn',
                            itemId: 'adminDeleteBtn',
                            text: 'Delete Meal'
                        },
                        {
                            xtype: 'button',
                            id: 'adminEditMealBtn',
                            itemId: 'adminEditMealBtn',
                            text: 'Edit Meal'
                        }
                    ]
                }
            ],
            items: [
                {
                    xtype: 'gridpanel',
                    id: '',
                    itemId: '',
                    header: false,
                    title: 'My Grid Panel',
                    store: 'ProductStore',
                    viewConfig: {
                        id: 'adminProductGridView',
                        itemId: 'adminProductGridView'
                    },
                    columns: [
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'Id',
                            text: 'Id',
                            flex: 0.5
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'Code',
                            text: 'Code',
                            flex: 0.5
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'Name',
                            text: 'Name',
                            flex: 1
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'Description',
                            text: 'Description',
                            flex: 1.5
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'Category',
                            text: 'Category',
                            flex: 1
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'Price',
                            text: 'Price',
                            flex: 1
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'Image',
                            text: 'Image',
                            flex: 1
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'Points',
                            text: 'Points',
                            flex: 0.5
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});