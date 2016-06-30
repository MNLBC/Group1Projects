Ext.define('School.store.Employee',
{
    extend: 'Ext.data.Store',
    model: 'School.model.Employee',
    autoLoad: false,
    storeId: 'Employee'
});