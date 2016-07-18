Ext.define('Company.view.Table', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.table',

    requires: [
        'Ext.grid.column.Number',
        'Ext.grid.column.Date',
        'Ext.grid.column.Boolean',
        'Ext.grid.View'
    ],

    viewModel: {
        type: 'table'
    },
    height: 217,
    id: '',
    width: 981,
    title: 'Table',

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