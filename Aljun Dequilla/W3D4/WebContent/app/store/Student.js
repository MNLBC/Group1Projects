Ext.define('School.store.Student',
{
    extend: 'Ext.data.Store',
    model: 'School.model.Student',
    autoLoad: false,
    storeId: 'Student'
});