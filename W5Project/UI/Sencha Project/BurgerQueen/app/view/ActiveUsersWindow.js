/*
 * File: app/view/ActiveUsersWindow.js
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

Ext.define('BurgerQueen.view.ActiveUsersWindow', {
    extend: 'Ext.window.Window',

    requires: [
        'Ext.container.Container'
    ],

    height: 250,
    itemId: 'ActiveUsersWindow',
    width: 400,
    title: 'Active Users',
    modal: true,

    layout: {
        type: 'vbox',
        align: 'center',
        pack: 'center'
    },

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'container',
                    style: 'font-family: \'Century Gothic\';',
                    layout: {
                        type: 'vbox',
                        align: 'stretch'
                    }
                }
            ],
            listeners: {
                show: {
                    fn: me.onWindowShow,
                    scope: me
                }
            }
        });

        me.callParent(arguments);
    },

    onWindowShow: function(component, eOpts) {

            var activeUserStore = Ext.getStore('ActiveUserStore');
            activeUserStore.each(function(rec){
                        component.add(
                        {
                            xtype:'label',
                            text:rec.data.username
                        }
                    );
            });



    }

});