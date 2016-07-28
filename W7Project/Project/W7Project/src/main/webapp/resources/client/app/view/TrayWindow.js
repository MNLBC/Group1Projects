/*
 * File: resources/app/view/TrayWindow.js
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

Ext.define('BurgerQueen.view.TrayWindow', {
    extend: 'Ext.window.Window',

    requires: [
        'Ext.form.FieldContainer',
        'Ext.grid.Panel',
        'Ext.grid.View',
        'Ext.grid.plugin.CellEditing',
        'Ext.form.field.Text',
        'Ext.grid.column.Number',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button',
        'Ext.form.field.Display'
    ],

    height: 399,
    id: 'TrayWindow',
    itemId: 'TrayWindow',
    style: 'font-family: \'Century Gothic\';',
    width: 619,
    autoScroll: true,
    bodyStyle: 'font-family: \'Century Gothic\';',
    header: false,
    title: 'My Tray',
    modal: true,

    layout: {
        type: 'vbox',
        align: 'stretch'
    },

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'fieldcontainer',
                    height: 60,
                    html: '<center><div id="nav"><h1 style = \'font-family: Arial; color:#565652;\' >My Tray</h1></div></center>',
                    width: 619,
                    fieldLabel: ''
                },
                {
                    xtype: 'gridpanel',
                    id: 'trayGrid',
                    itemId: 'trayGrid',
                    autoScroll: true,
                    header: false,
                    title: 'My Grid Panel',
                    store: 'TrayStore',
                    viewConfig: {
                        id: 'trayGridView',
                        itemId: 'trayGrid'
                    },
                    columns: [
                        {
                            xtype: 'gridcolumn',
                            id: 'orderName',
                            itemId: 'orderName',
                            style: 'font-family: \'Abel\';',
                            dataIndex: 'Name',
                            text: 'Name',
                            flex: 0.8
                        },
                        {
                            xtype: 'gridcolumn',
                            id: 'orderQty',
                            itemId: 'orderQty',
                            style: 'font-family: \'Abel\';',
                            dataIndex: 'Quantity',
                            text: 'Quantity',
                            flex: 0.5,
                            editor: {
                                xtype: 'textfield',
                                id: 'orderQtyField',
                                itemId: 'orderQtyField',
                                inputId: 'orderQtyId',
                                inputType: 'number',
                                maxLength: 2,
                                regex: /^([1-9]|10)$/
                            }
                        },
                        {
                            xtype: 'numbercolumn',
                            id: 'orderPrice',
                            itemId: 'orderPrice',
                            style: 'font-family: \'Abel\';',
                            dataIndex: 'Price',
                            text: 'Price',
                            flex: 0.5
                        },
                        {
                            xtype: 'gridcolumn',
                            renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
                                var price = record.data.Price,
                                    quantity = record.data.Quantity,
                                    trayStore = Ext.getStore('TrayStore'),
                                    idEdit = record.data.Id;
                                record = trayStore.getById(idEdit);
                                var newTotal = price * quantity;
                                record.set('Total', newTotal);
                                return newTotal;

                            },
                            id: 'total',
                            itemId: 'total',
                            style: 'font-family: \'Abel\';',
                            dataIndex: 'Total',
                            text: 'Total'
                        },
                        {
                            xtype: 'gridcolumn',
                            renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {

                                var  quantity = record.data.Quantity,
                                    trayStore = Ext.getStore('TrayStore'),
                                    idEdit = record.data.Id;
                                record = trayStore.getById(idEdit);
                                var productRecord = Ext.getStore('ProductStore').getById(idEdit),
                                    points = productRecord.data.Points;

                                var newPoints = points * quantity;
                                record.set('Points', newPoints);

                                return Ext.util.Format.number(newPoints, '00.00');
                            },
                            dataIndex: 'Points',
                            text: 'Points'
                        }
                    ],
                    plugins: [
                        Ext.create('Ext.grid.plugin.CellEditing', {
                            pluginId: 'cellEdit',
                            listeners: {
                                edit: {
                                    fn: me.onCellEditingEdit,
                                    scope: me
                                }
                            }
                        })
                    ]
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
                            id: 'removeItemBtn',
                            itemId: 'removeItemBtn',
                            text: 'Remove Item'
                        }
                    ]
                },
                {
                    xtype: 'container',
                    flex: 1,
                    items: [
                        {
                            xtype: 'displayfield',
                            id: 'totalPoints',
                            itemId: 'totalPoints',
                            fieldLabel: 'Total Points',
                            labelStyle: 'font-family: \'Abel\'; font-size: 15px;',
                            labelWidth: 80,
                            value: '0',
                            fieldStyle: 'font-family: \'Abel\'; font-size: 15px;'
                        },
                        {
                            xtype: 'displayfield',
                            id: 'totalItems',
                            itemId: 'totalItems',
                            rtl: false,
                            fieldLabel: '',
                            labelStyle: 'font-family: \'Abel\'; font-size: 15px;',
                            value: '0',
                            fieldStyle: 'font-family: \'Abel\'; font-size: 15px;'
                        },
                        {
                            xtype: 'displayfield',
                            id: 'totalAmount',
                            itemId: 'totalAmount',
                            fieldLabel: 'Total (RMB)',
                            labelStyle: 'font-family: \'Abel\'; font-size: 20px;font-weight: bold;',
                            labelWidth: 120,
                            value: '0',
                            fieldStyle: 'font-family: \'Abel\'; font-size: 20px; font-weight: bold;',
                            listeners: {
                                change: {
                                    fn: me.onTotalAmountChange,
                                    scope: me
                                }
                            }
                        },
                        {
                            xtype: 'displayfield',
                            id: 'totalDiscountedAmount',
                            itemId: 'totalDiscountedAmount',
                            fieldLabel: 'Grand Total (RMB) w/ Discount',
                            labelStyle: 'font-family: \'Abel\'; font-size: 18px; font-weight: bold;',
                            labelWidth: 260,
                            value: '0',
                            fieldStyle: 'font-family: \'Abel\'; font-size: 20px; font-weight: bold;'
                        }
                    ]
                }
            ],
            dockedItems: [
                {
                    xtype: 'toolbar',
                    flex: 1,
                    dock: 'bottom',
                    layout: {
                        type: 'hbox',
                        pack: 'center'
                    },
                    items: [
                        {
                            xtype: 'button',
                            id: 'checkoutBtn',
                            itemId: 'checkoutBtn',
                            text: 'CheckOut'
                        },
                        {
                            xtype: 'button',
                            id: 'cancelCheckoutBtn',
                            itemId: 'cancelCheckoutBtn',
                            text: 'Cancel'
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    },

    onCellEditingEdit: function(editor, e, eOpts) {
        var grid = Ext.getCmp('trayGrid'),
            store = grid.getStore(),
            totalQuantity = 0,
            totalAmount = 0,
            totalPoints = 0,
            records = store.getRange();

        Ext.each(records,function(record){
            totalQuantity += record.data.Quantity;
            totalAmount += record.data.Total;
            totalPoints += record.data.Points;
        });

        totalPoints = Ext.util.Format.number(totalPoints, '00.00');
        Ext.getCmp('totalItems').setValue('Total '+totalQuantity + ' item(s)');
        Ext.getCmp('totalAmount').setValue(totalAmount);
        Ext.getCmp('totalPoints').setValue(totalPoints);

    },

    onTotalAmountChange: function(field, newValue, oldValue, eOpts) {
                  var points = currentLoginUser.points;
                    var discount = 0;
                    if(points > 10){
                        discount = .05;
                    }else if(points > 50){
                        discount = .10;
                    }else if(points >200){
                        discount = .15;
                    }



               var totalAmount = Ext.getCmp('totalAmount').getValue();
        if(discount!==0){
                var discountedAmount = totalAmount * discount;
        }else{
             var discountedAmount = 0;
        }
                var totalDiscountedAmount = totalAmount - discountedAmount;
                Ext.getCmp('totalDiscountedAmount').setValue(totalDiscountedAmount);

    }

});