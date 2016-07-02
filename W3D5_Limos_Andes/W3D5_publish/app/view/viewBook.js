/*
 * File: app/view/viewBook.js
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

Ext.define('BookingManagementSystem.view.viewBook', {
    extend: 'Ext.window.Window',

    requires: [
        'Ext.form.Panel',
        'Ext.form.FieldSet',
        'Ext.form.field.TextArea',
        'Ext.form.field.Number',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button'
    ],

    height: 321,
    id: 'viewBookWindow',
    width: 400,
    title: 'View/Edit Book',

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
                    xtype: 'form',
                    flex: 1,
                    width: 372,
                    bodyPadding: 10,
                    header: false,
                    title: 'My Form',
                    items: [
                        {
                            xtype: 'fieldset',
                            id: 'viewBookInformationContainer',
                            title: 'Book Information',
                            items: [
                                {
                                    xtype: 'textfield',
                                    anchor: '100%',
                                    id: 'titleView',
                                    fieldLabel: 'Title',
                                    name: 'title',
                                    allowBlank: false,
                                    allowOnlyWhitespace: false
                                },
                                {
                                    xtype: 'textfield',
                                    anchor: '100%',
                                    id: 'authorView',
                                    fieldLabel: 'Author',
                                    name: 'author',
                                    allowBlank: false,
                                    allowOnlyWhitespace: false
                                },
                                {
                                    xtype: 'textareafield',
                                    anchor: '100%',
                                    id: 'descriptionView',
                                    fieldLabel: 'Description',
                                    name: 'description',
                                    allowBlank: false,
                                    allowOnlyWhitespace: false
                                },
                                {
                                    xtype: 'numberfield',
                                    anchor: '100%',
                                    id: 'availableView',
                                    fieldLabel: 'Available for rental',
                                    name: 'available',
                                    allowBlank: false,
                                    allowOnlyWhitespace: false,
                                    allowDecimals: false,
                                    allowExponential: false,
                                    decimalPrecision: 0,
                                    minValue: 1
                                }
                            ]
                        }
                    ]
                }
            ],
            dockedItems: [
                {
                    xtype: 'toolbar',
                    flex: 1,
                    dock: 'bottom',
                    layout: {
                        type: 'hbox',
                        pack: 'end'
                    },
                    items: [
                        {
                            xtype: 'button',
                            id: 'viewSaveBookButton',
                            text: 'Save'
                        },
                        {
                            xtype: 'button',
                            id: 'viewCancelSaveBookButton',
                            text: 'Cancel'
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});