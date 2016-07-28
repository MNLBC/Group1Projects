/*
 * File: resources/app/view/ContactUsWindow.js
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

Ext.define('BurgerQueen.view.ContactUsWindow', {
    extend: 'Ext.window.Window',

    requires: [
        'Ext.form.Label',
        'Ext.form.field.TextArea',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button'
    ],

    height: 330,
    width: 400,
    title: '',
    modal: true,

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'container',
                    html: '<center><div id="nav"><h1 style = \'font-family: Arial; color:#565652;\' >Contact Us!</h1></div></center>'
                },
                {
                    xtype: 'container',
                    layout: {
                        type: 'vbox',
                        align: 'stretch'
                    },
                    items: [
                        {
                            xtype: 'label',
                            style: 'font-family:\'Abel\';\nfont-size: 20px;\npadding-left:20px;',
                            text: 'Branch:Grand BayView Hotel Zhuhai, China'
                        },
                        {
                            xtype: 'label',
                            margins: '0 0 10 0',
                            height: 16,
                            margin: '',
                            padding: '0 0 0 20',
                            style: 'font-family:\'Abel\';\nfont-size: 20px;',
                            text: 'Contact Number: 09123456789'
                        },
                        {
                            xtype: 'textareafield',
                            flex: 1,
                            margins: '10,0,0,0',
                            height: 97,
                            hidden: true,
                            id: 'commentBox',
                            itemId: 'commentBox',
                            fieldLabel: 'Comments:',
                            labelStyle: 'font-family:\'Abel\';font-size:18px;'
                        },
                        {
                            xtype: 'container',
                            flex: 1
                        },
                        {
                            xtype: 'toolbar',
                            flex: 1,
                            layout: {
                                type: 'hbox',
                                pack: 'end'
                            },
                            items: [
                                {
                                    xtype: 'button',
                                    hidden: true,
                                    id: 'btnSubmitComment',
                                    itemId: 'btnSubmitComment',
                                    text: 'Submit'
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