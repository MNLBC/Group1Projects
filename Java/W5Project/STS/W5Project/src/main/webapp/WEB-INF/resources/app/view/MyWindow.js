/*
 * File: app/view/MyWindow.js
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

Ext.define('BurgerQueen.view.MyWindow', {
    extend: 'Ext.window.Window',

    requires: [
        'Ext.form.Panel',
        'Ext.form.field.TextArea',
        'Ext.form.RadioGroup',
        'Ext.form.field.Radio'
    ],

    height: 501,
    width: 463,
    layout: 'fit',
    header: false,
    title: 'My Window',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'form',
                    bodyPadding: 10,
                    header: false,
                    title: 'My Form',
                    layout: {
                        type: 'vbox',
                        align: 'stretch'
                    },
                    items: [
                        {
                            xtype: 'textfield',
                            flex: 1,
                            fieldLabel: 'User Name'
                        },
                        {
                            xtype: 'textfield',
                            flex: 1,
                            fieldLabel: 'Password'
                        },
                        {
                            xtype: 'textfield',
                            flex: 1,
                            fieldLabel: 'Confirm Password'
                        },
                        {
                            xtype: 'textfield',
                            flex: 1,
                            fieldLabel: 'First Name'
                        },
                        {
                            xtype: 'textfield',
                            flex: 1,
                            fieldLabel: 'Middle Name'
                        },
                        {
                            xtype: 'textfield',
                            flex: 1,
                            fieldLabel: 'Last Name'
                        },
                        {
                            xtype: 'textareafield',
                            flex: 1,
                            fieldLabel: 'Label'
                        },
                        {
                            xtype: 'textfield',
                            flex: 1,
                            fieldLabel: 'Label'
                        },
                        {
                            xtype: 'textfield',
                            flex: 1,
                            fieldLabel: 'Label'
                        },
                        {
                            xtype: 'radiogroup',
                            flex: 1,
                            width: 400,
                            fieldLabel: 'Gender',
                            items: [
                                {
                                    xtype: 'radiofield',
                                    boxLabel: 'Male'
                                },
                                {
                                    xtype: 'radiofield',
                                    boxLabel: 'Female'
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