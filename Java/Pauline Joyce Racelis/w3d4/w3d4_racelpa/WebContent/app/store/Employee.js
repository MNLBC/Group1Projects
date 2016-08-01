Ext.define('Company.store.Employee',
{
    extend: 'Ext.data.Store',
    model: 'Company.model.Employee',
    autoLoad: false,
    storeId: 'Employee'
});