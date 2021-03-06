/*
 * File: app/view/BorrowedGrid.js
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

Ext.define('Libray.view.BorrowedGrid', {
    extend: 'Ext.grid.Panel',

    requires: [
        'Ext.grid.View',
        'Ext.grid.column.CheckColumn'
    ],

    height: 250,
    width: 705,
    title: 'Checked Out Book/s',
    store: 'BorrowedStore',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            columns: [
                {
                    xtype: 'checkcolumn',
                    width: 83,
                    text: ''
                },
                {
                    xtype: 'gridcolumn',
                    width: 142,
                    dataIndex: 'title',
                    text: 'Title'
                },
                {
                    xtype: 'gridcolumn',
                    width: 206,
                    dataIndex: 'author',
                    text: 'Author'
                },
                {
                    xtype: 'gridcolumn',
                    dataIndex: 'publisher',
                    text: 'Publisher',
                    flex: 1
                }
            ]
        });

        me.callParent(arguments);
    }

});