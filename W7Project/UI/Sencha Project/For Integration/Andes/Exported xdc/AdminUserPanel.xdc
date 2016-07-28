{
    "xdsVersion": "3.1.0",
    "frameworkVersion": "ext42",
    "internals": {
        "type": "Ext.panel.Panel",
        "reference": {
            "name": "items",
            "type": "array"
        },
        "codeClass": null,
        "userConfig": {
            "autoScroll": true,
            "designer|userAlias": "adminuserpanel",
            "designer|userClassName": "AdminUserPanel",
            "header": false,
            "height": 580,
            "id": "AdminUserPanel",
            "itemId": "AdminUserPanel",
            "title": "Admin",
            "width": 830
        },
        "name": "MyPanel1",
        "cn": [
            {
                "type": "Ext.container.Container",
                "reference": {
                    "name": "items",
                    "type": "array"
                },
                "codeClass": null,
                "userConfig": {
                    "html": [
                        "<center><div id=\"nav\"><h1 style = 'font-family: Arial; color:#565652;' >Users</h1></div></center>"
                    ]
                },
                "name": "MyContainer4"
            },
            {
                "type": "Ext.grid.Panel",
                "reference": {
                    "name": "items",
                    "type": "array"
                },
                "codeClass": null,
                "userConfig": {
                    "autoScroll": true,
                    "header": false,
                    "id": "userGrid",
                    "itemId": "userGrid",
                    "store": "UsersStore",
                    "title": "My Grid Panel"
                },
                "name": "MyGridPanel5",
                "cn": [
                    {
                        "type": "Ext.grid.View",
                        "reference": {
                            "name": "viewConfig",
                            "type": "object"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "id": "userGridView",
                            "itemId": "userGrid"
                        },
                        "name": "MyGridView5"
                    },
                    {
                        "type": "Ext.grid.column.Number",
                        "reference": {
                            "name": "columns",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "dataIndex": "id",
                            "flex": 0.7,
                            "format": "0000",
                            "text": "Id"
                        },
                        "name": "MyNumberColumn1"
                    },
                    {
                        "type": "Ext.grid.column.Column",
                        "reference": {
                            "name": "columns",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "dataIndex": "Username",
                            "flex": 1,
                            "text": "Username"
                        },
                        "name": "MyColumn12"
                    },
                    {
                        "type": "Ext.grid.column.Column",
                        "reference": {
                            "name": "columns",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "dataIndex": "Password",
                            "flex": 1,
                            "text": "Password"
                        },
                        "name": "MyColumn13"
                    },
                    {
                        "type": "Ext.grid.column.Column",
                        "reference": {
                            "name": "columns",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "dataIndex": "Firstname",
                            "flex": 1,
                            "text": "Firstname"
                        },
                        "name": "MyColumn14"
                    },
                    {
                        "type": "Ext.grid.column.Column",
                        "reference": {
                            "name": "columns",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "dataIndex": "Middlename",
                            "flex": 1,
                            "text": "Middlename"
                        },
                        "name": "MyColumn16"
                    },
                    {
                        "type": "Ext.grid.column.Column",
                        "reference": {
                            "name": "columns",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "dataIndex": "Lastname",
                            "flex": 1,
                            "text": "Lastname"
                        },
                        "name": "MyColumn15"
                    },
                    {
                        "type": "Ext.grid.column.Column",
                        "reference": {
                            "name": "columns",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "dataIndex": "Gender",
                            "flex": 0.8,
                            "text": "Gender"
                        },
                        "name": "MyColumn17"
                    },
                    {
                        "type": "Ext.grid.column.Column",
                        "reference": {
                            "name": "columns",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "dataIndex": "Email",
                            "flex": 1,
                            "text": "Email"
                        },
                        "name": "MyColumn19"
                    },
                    {
                        "type": "Ext.grid.column.Column",
                        "reference": {
                            "name": "columns",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "dataIndex": "Address",
                            "flex": 2,
                            "text": "Address"
                        },
                        "name": "MyColumn18"
                    },
                    {
                        "type": "Ext.grid.column.Column",
                        "reference": {
                            "name": "columns",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "dataIndex": "Contact",
                            "flex": 1,
                            "text": "Contact"
                        },
                        "name": "MyColumn20"
                    },
                    {
                        "type": "Ext.grid.column.Column",
                        "reference": {
                            "name": "columns",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "dataIndex": "Disabled",
                            "flex": 0.8,
                            "text": "Disabled"
                        },
                        "name": "MyColumn22"
                    },
                    {
                        "type": "Ext.grid.column.Column",
                        "reference": {
                            "name": "columns",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "dataIndex": "Type",
                            "flex": 0.5,
                            "text": "Type"
                        },
                        "name": "MyColumn23"
                    },
                    {
                        "type": "Ext.grid.column.Column",
                        "reference": {
                            "name": "columns",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "dataIndex": "Level",
                            "flex": 0.5,
                            "text": "Level"
                        },
                        "name": "MyColumn24"
                    },
                    {
                        "type": "Ext.grid.column.Column",
                        "reference": {
                            "name": "columns",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "dataIndex": "Points",
                            "flex": 0.5,
                            "text": "Points"
                        },
                        "name": "MyColumn25"
                    }
                ]
            },
            {
                "type": "Ext.toolbar.Toolbar",
                "reference": {
                    "name": "dockedItems",
                    "type": "array"
                },
                "codeClass": null,
                "userConfig": {
                    "container|pack": "end",
                    "dock": "bottom"
                },
                "name": "MyToolbar13",
                "cn": [
                    {
                        "type": "Ext.button.Button",
                        "reference": {
                            "name": "items",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "disabled": true,
                            "height": 45,
                            "id": "btnEnable",
                            "itemId": "btnEnable",
                            "layout|flex": null,
                            "text": "Enable",
                            "width": 100
                        },
                        "name": "MyButton30"
                    },
                    {
                        "type": "Ext.button.Button",
                        "reference": {
                            "name": "items",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "disabled": true,
                            "height": 45,
                            "id": "btnDisable",
                            "itemId": "btnDisable",
                            "layout|flex": null,
                            "text": "Disable",
                            "width": 100
                        },
                        "name": "MyButton31"
                    },
                    {
                        "type": "Ext.button.Button",
                        "reference": {
                            "name": "items",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "disabled": true,
                            "height": 45,
                            "id": "btnManage",
                            "itemId": "btnManage",
                            "layout|flex": null,
                            "text": "Manage",
                            "width": 100
                        },
                        "name": "MyButton36"
                    }
                ]
            }
        ]
    },
    "linkedNodes": {},
    "boundStores": {
        "35d4364c-86a6-4b98-b2e0-2b6878b1ab90": {
            "type": "Ext.data.Store",
            "reference": {
                "name": "items",
                "type": "array"
            },
            "codeClass": null,
            "userConfig": {
                "designer|userClassName": "UsersStore",
                "model": "UsersModel",
                "storeId": "UsersStore"
            },
            "name": "MyStore"
        }
    },
    "boundModels": {
        "c740ec8e-f6e7-445a-99b1-2ba69367fba5": {
            "type": "Ext.data.Model",
            "reference": {
                "name": "items",
                "type": "array"
            },
            "codeClass": null,
            "userConfig": {
                "designer|userClassName": "UsersModel"
            },
            "name": "MyModel",
            "cn": [
                {
                    "type": "Ext.data.Field",
                    "reference": {
                        "name": "fields",
                        "type": "array"
                    },
                    "codeClass": null,
                    "userConfig": {
                        "name": "id"
                    },
                    "name": "MyField21"
                },
                {
                    "type": "Ext.data.Field",
                    "reference": {
                        "name": "fields",
                        "type": "array"
                    },
                    "codeClass": null,
                    "userConfig": {
                        "name": "Username"
                    },
                    "name": "MyField22"
                },
                {
                    "type": "Ext.data.Field",
                    "reference": {
                        "name": "fields",
                        "type": "array"
                    },
                    "codeClass": null,
                    "userConfig": {
                        "name": "Password"
                    },
                    "name": "MyField23"
                },
                {
                    "type": "Ext.data.Field",
                    "reference": {
                        "name": "fields",
                        "type": "array"
                    },
                    "codeClass": null,
                    "userConfig": {
                        "name": "Firstname"
                    },
                    "name": "MyField24"
                },
                {
                    "type": "Ext.data.Field",
                    "reference": {
                        "name": "fields",
                        "type": "array"
                    },
                    "codeClass": null,
                    "userConfig": {
                        "name": "Middlename"
                    },
                    "name": "MyField25"
                },
                {
                    "type": "Ext.data.Field",
                    "reference": {
                        "name": "fields",
                        "type": "array"
                    },
                    "codeClass": null,
                    "userConfig": {
                        "name": "Lastname"
                    },
                    "name": "MyField26"
                },
                {
                    "type": "Ext.data.Field",
                    "reference": {
                        "name": "fields",
                        "type": "array"
                    },
                    "codeClass": null,
                    "userConfig": {
                        "name": "Gender"
                    },
                    "name": "MyField27"
                },
                {
                    "type": "Ext.data.Field",
                    "reference": {
                        "name": "fields",
                        "type": "array"
                    },
                    "codeClass": null,
                    "userConfig": {
                        "name": "Email"
                    },
                    "name": "MyField28"
                },
                {
                    "type": "Ext.data.Field",
                    "reference": {
                        "name": "fields",
                        "type": "array"
                    },
                    "codeClass": null,
                    "userConfig": {
                        "name": "Address"
                    },
                    "name": "MyField29"
                },
                {
                    "type": "Ext.data.Field",
                    "reference": {
                        "name": "fields",
                        "type": "array"
                    },
                    "codeClass": null,
                    "userConfig": {
                        "name": "Contact"
                    },
                    "name": "MyField30"
                },
                {
                    "type": "Ext.data.Field",
                    "reference": {
                        "name": "fields",
                        "type": "array"
                    },
                    "codeClass": null,
                    "userConfig": {
                        "name": "Disabled"
                    },
                    "name": "MyField31"
                },
                {
                    "type": "Ext.data.Field",
                    "reference": {
                        "name": "fields",
                        "type": "array"
                    },
                    "codeClass": null,
                    "userConfig": {
                        "name": "Type"
                    },
                    "name": "MyField32"
                },
                {
                    "type": "Ext.data.Field",
                    "reference": {
                        "name": "fields",
                        "type": "array"
                    },
                    "codeClass": null,
                    "userConfig": {
                        "name": "Level"
                    },
                    "name": "MyField33"
                },
                {
                    "type": "Ext.data.Field",
                    "reference": {
                        "name": "fields",
                        "type": "array"
                    },
                    "codeClass": null,
                    "userConfig": {
                        "name": "Points"
                    },
                    "name": "MyField34"
                }
            ]
        }
    }
}