/*
 * File: app/view/MyGridPanel2.js
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

Ext.define('BurgerQueen.view.MyGridPanel2', {
    extend: 'Ext.grid.Panel',

    requires: [
        'Ext.grid.column.Number',
        'Ext.grid.column.Date',
        'Ext.grid.column.Boolean',
        'Ext.grid.View'
    ],

    height: 250,
    width: 400,
    title: 'My Grid Panel',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            columns: [
                {
                    xtype: 'gridcolumn',
                    dataIndex: 'string',
                    text: 'String'
                },
                {
                    xtype: 'numbercolumn',
                    dataIndex: 'number',
                    text: 'Number'
                },
                {
                    xtype: 'datecolumn',
                    dataIndex: 'date',
                    text: 'Date'
                },
                {
                    xtype: 'booleancolumn',
                    dataIndex: 'bool',
                    text: 'Boolean'
                }
            ]
        });

        me.callParent(arguments);
    }

});