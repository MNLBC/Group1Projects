/*
 * File: app/view/MyForm.js
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

Ext.define('W3D3.view.MyForm', {
    extend: 'Ext.form.Panel',

    requires: [
        'Ext.container.Container',
        'Ext.form.field.TextArea',
        'Ext.button.Button'
    ],

    height: 273,
    width: 288,
    layout: 'auto',
    bodyPadding: 10,
    title: 'Week 3 Day 3',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'container',
                    height: 189,
                    width: 278,
                    items: [
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Name'
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Email',
                            maxLength: 0
                        },
                        {
                            xtype: 'textareafield',
                            fieldLabel: 'Address'
                        },
                        {
                            xtype: 'textfield',
                            fieldLabel: 'Phone'
                        }
                    ]
                },
                {
                    xtype: 'button',
                    height: 28,
                    width: 269,
                    text: 'This button does not do anything'
                }
            ]
        });

        me.callParent(arguments);
    }

});