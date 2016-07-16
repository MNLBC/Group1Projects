/*
 * File: app/model/TrayModel.js
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

Ext.define('BurgerQueen.model.TrayModel', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field'
    ],

    idProperty: 'Id',

    fields: [
        {
            name: 'Id',
            type: 'int'
        },
        {
            name: 'Name'
        },
        {
            name: 'Quantity',
            type: 'int'
        },
        {
            name: 'Price',
            type: 'auto'
        },
        {
            name: 'Total',
            type: 'auto'
        }
    ]
});