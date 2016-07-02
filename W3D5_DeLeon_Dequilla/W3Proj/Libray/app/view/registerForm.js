/*
 * File: app/view/registerForm.js
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

Ext.define('Libray.view.registerForm', {
    extend: 'Ext.form.Panel',
    alias: 'widget.registerForm',

    requires: [
        'Ext.toolbar.Spacer',
        'Ext.form.FieldContainer',
        'Ext.form.field.Text',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button'
    ],

    height: 276,
    itemId: 'registerForm',
    width: 352,
    bodyPadding: 10,
    header: false,
    title: 'Register Account',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'container',
                    height: 62,
                    html: '<link href=\'http://fonts.googleapis.com/css?family=Abel\'\n	rel=\'stylesheet\' type=\'text/css\'>\n <center><div id="header"><h3 style = \'font-family: Abel;\'>Register Account!</h3></div></center>',
                    style: '#nav {\nline-height: 30px;\nbackground-color: #D4F5C9;\nheight: 460px;\nwidth: 180px;\nfloat: left;\npadding: 5px;\n}'
                },
                {
                    xtype: 'tbspacer',
                    height: 75,
                    maxHeight: 75,
                    maxWidth: 20,
                    minHeight: 75,
                    minWidth: 20,
                    width: 20
                },
                {
                    xtype: 'fieldcontainer',
                    height: 200,
                    items: [
                        {
                            xtype: 'textfield',
                            width: 330,
                            fieldLabel: 'First Name:',
                            labelWidth: 110
                        },
                        {
                            xtype: 'textfield',
                            width: 331,
                            fieldLabel: 'Last Name:',
                            labelWidth: 110
                        },
                        {
                            xtype: 'textfield',
                            width: 330,
                            fieldLabel: 'User name:',
                            labelWidth: 110
                        },
                        {
                            xtype: 'textfield',
                            width: 330,
                            fieldLabel: 'Password:',
                            labelWidth: 110,
                            inputType: 'password'
                        },
                        {
                            xtype: 'textfield',
                            width: 330,
                            fieldLabel: 'Confirm password:',
                            labelWidth: 110,
                            inputType: 'password'
                        },
                        {
                            xtype: 'toolbar',
                            width: 330,
                            layout: {
                                type: 'hbox',
                                pack: 'end'
                            },
                            items: [
                                {
                                    xtype: 'button',
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