/*
 * File: app/view/LoginPage.js
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

Ext.define('BookingManagementSystem.view.LoginPage', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Ext.form.Panel',
        'Ext.form.FieldSet',
        'Ext.form.Label',
        'Ext.form.field.Text',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button'
    ],

    layout: 'fit',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    layout: 'fit',
                    header: false,
                    title: 'My Panel',
                    items: [
                        {
                            xtype: 'form',
                            id: 'loginPage',
                            bodyPadding: '',
                            header: false,
                            title: 'My Form',
                            layout: {
                                type: 'hbox',
                                align: 'middle',
                                pack: 'center'
                            },
                            items: [
                                {
                                    xtype: 'fieldset',
                                    flex: 1,
                                    height: 300,
                                    itemId: '',
                                    width: 1024,
                                    title: '',
                                    layout: {
                                        type: 'vbox',
                                        align: 'center',
                                        pack: 'center'
                                    },
                                    items: [
                                        {
                                            xtype: 'label',
                                            margins: '',
                                            margin: '-50, 0, 0, 0',
                                            padding: '',
                                            style: 'font-size:30px; font-family:\'Monotype Corsiva\';',
                                            text: 'Welcome to Book Management System'
                                        },
                                        {
                                            xtype: 'textfield',
                                            id: 'userName',
                                            margin: 25,
                                            fieldLabel: 'Username',
                                            name: 'userName',
                                            allowBlank: false,
                                            allowOnlyWhitespace: false
                                        },
                                        {
                                            xtype: 'textfield',
                                            id: 'password',
                                            fieldLabel: 'Password',
                                            name: 'password',
                                            inputType: 'password',
                                            allowBlank: false,
                                            allowOnlyWhitespace: false
                                        },
                                        {
                                            xtype: 'toolbar',
                                            margins: '',
                                            margin: '',
                                            layout: {
                                                type: 'hbox',
                                                pack: 'center',
                                                padding: ''
                                            },
                                            items: [
                                                {
                                                    xtype: 'button',
                                                    itemId: 'loginButton',
                                                    text: 'Login'
                                                },
                                                {
                                                    xtype: 'button',
                                                    itemId: 'registerButton',
                                                    text: 'Register'
                                                }
                                            ]
                                        }
                                    ]
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