Ext.define('Company.model.Employee', 
{
    extend : 'Ext.data.Model',
    idProperty:'Id',
    fields: [
        { name: 'Id', type: 'int', defaultValue: 0 },
        { name: 'firstName', type: 'string' },
        { name: 'middleName', type: 'string' },
        { name: 'lastName', type: 'string' },
        { name: 'birthDate', type: 'date' },
        { name: 'address1', type: 'string' },
        { name: 'address2', type: 'string' },
        { name: 'city', type: 'string' },
        { name: 'state', type: 'string' }
    ],
    validations : [{
        type : 'presence',
        field : 'firstName'
    } ],
    proxy : 
    {
        type : 'ajax',
        reader : 
        {
        root:'data',
            type : 'json'
        },
        api : 
        {
            read : '/ExampleService.svc/employee/',
            create : '/ExampleService.svc/createemployee/',
            update : '/ExampleService.svc/updateemployee/',
            destroy : '/ExampleService.svc/deleteemployee/'
        },
        actionMethods : 
        {
            destroy : 'POST',
            read : 'GET',
            create : 'POST',
            update : 'POST'
        }
        
    }
});