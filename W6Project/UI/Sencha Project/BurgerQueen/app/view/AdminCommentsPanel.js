/*
 * File: app/view/AdminCommentsPanel.js
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

Ext.define('BurgerQueen.view.AdminCommentsPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.admincommentspanel1',

    requires: [
        'Ext.grid.Panel',
        'Ext.grid.View',
        'Ext.grid.column.Column',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button'
    ],

    height: 328,
    id: 'AdminCommentsPanel',
    itemId: 'AdminCommentsPanel',
    width: 638,
    header: false,
    title: 'My Panel',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'container',
                    html: '<link href=\'http://fonts.googleapis.com/css?family=Abel\'rel=\'stylesheet\' type=\'text/css\'>\n<center><div id="nav"><h1 style = \'font-family: Abel; color:#565652;\'>Comments</h1></div></center>'
                },
                {
                    xtype: 'gridpanel',
                    autoScroll: true,
                    header: false,
                    title: 'My Grid Panel',
                    store: 'CommentsStore',
                    viewConfig: {
                        id: 'commentsGrid',
                        itemId: 'commentsGrid'
                    },
                    columns: [
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'username',
                            text: 'Username',
                            flex: 0.5
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'comments',
                            text: 'Comments',
                            flex: 1
                        }
                    ]
                }
            ],
            dockedItems: [
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
                            height: 50,
                            id: 'btnAccept',
                            itemId: 'btnAccept',
                            width: 200,
                            text: 'Accept'
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});