/*
 * File: app/store/bookStore.js
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

Ext.define('MyApp.store.bookStore', {
    extend: 'Ext.data.Store',

    requires: [
        'MyApp.model.bookModel'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            model: 'MyApp.model.bookModel',
            storeId: 'bookStore',
            data: [
                {
                    bookId: 1,
                    title: 'Diary of a Wimpy Kid',
                    author: 'Jeffrey Kinning',
                    description: 'Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem.',
                    available: '20',
                    checkoutBy: 'iusto'
                },
                {
                    bookId: 2,
                    title: 'I Am Number Four',
                    author: 'Pittacus Lore',
                    description: 'Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.',
                    available: '20',
                    checkoutBy: 'accusamus'
                }
            ]
        }, cfg)]);
    }
});