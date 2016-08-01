Ext.define('School.controller.EmployeeMaster',
{
    extend: 'Ext.app.Controller',
    models: ['School.model.Employee'],
    stores: ['School.store.Employee'],
    views: ['School.view.EmployeeGrid'],
    refs: [{
        ref: 'studentGrid',
        selector: 'viewport EmployeeGrid'
    }],

    init: function () {

        this.control({

            'viewport > EmployeeGrid button[itemId=btnCreate]':
            {
                click: this.onCreateClick
            },
            'viewport > EmployeeGrid button[itemId=btnLoad]':
            {
                click: this.onLoadClick
            },
            'viewport > EmployeeGrid button[itemId=btnSave]':
            {
                click: this.onSaveClick
            },
            'viewport > EmployeeGrid button[itemId=btnDelete]':
            {
                click: this.onDeleteClick
            }
        });
    },

    onCreateClick: function () {

        var studentGrid = this.getEmployeeGrid();
        var studentStore = studentGrid.getStore();

        var studentModel = Ext.create('School.model.Employee');
        studentModel.set("firstName", "New student's first name");
        studentModel.set("middleName", "New student's middle name");
        studentModel.set("lastName", "New student's last name");
        studentModel.set("birthDate", "11/01/2011");
        studentModel.set("city", "New city");
        studentModel.set("state", "New state");

        studentStore.add(studentModel);

        studentGrid.editingPlugin.startEdit(studentModel, 3);

    },

    onSaveClick: function () {
        var studentGrid = this.getEmployeeGrid();
        var studentStore = studentGrid.getStore();

        //fires create, update and delete request when calling sync and commit changes in the store when autoSync=false
        studentStore.sync({
            success: function (batch, eOpts) {
                Ext.Msg.alert('Status', 'Changes saved successfully.');
            },
            failure: function (batch, eOpts) {
                Ext.Msg.alert('Status', 'Request failed.');
            }
        });
    },
    onLoadClick: function () {
        var studentStore = Ext.getStore('School.store.Employee');
        studentStore.load();
    },

    onDeleteClick: function () {

        var studentGrid = this.getEmployeeGrid();
        var studentStore = studentGrid.getStore();

        //delete selected rows if selModel is checkboxmodel
        var selectedRows = studentGrid.getSelectionModel().getSelection();

        if (selectedRows.length)
            studentStore.remove(selectedRows);
        else
            Ext.Msg.alert('Status', 'Please select at least one record to delete!');
    }
});