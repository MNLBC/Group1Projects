{
    "xdsVersion": "3.1.0",
    "frameworkVersion": "ext42",
    "internals": {
        "type": "Ext.window.Window",
        "reference": {
            "name": "items",
            "type": "array"
        },
        "codeClass": null,
        "userConfig": {
            "designer|userClassName": "WinUserEdit",
            "header": false,
            "height": 236,
            "id": "winUserEdit",
            "itemId": "winUserEdit",
            "modal": true,
            "title": "My Window",
            "width": 329
        },
        "name": "MyWindow",
        "cn": [
            {
                "type": "Ext.panel.Panel",
                "reference": {
                    "name": "items",
                    "type": "array"
                },
                "codeClass": null,
                "userConfig": {
                    "header": false,
                    "html": [
                        "<center><div id=\"nav\"><h1 style = 'font-family: Arial; color:#565652;' >Manage User</h1></div></center>"
                    ],
                    "title": "Manage User"
                },
                "name": "MyPanel1"
            },
            {
                "type": "Ext.form.Panel",
                "reference": {
                    "name": "items",
                    "type": "array"
                },
                "codeClass": null,
                "userConfig": {
                    "bodyPadding": 10,
                    "header": false,
                    "id": "adminManageUserForm",
                    "itemId": "adminManageUserForm",
                    "title": "My Form"
                },
                "name": "MyForm5",
                "cn": [
                    {
                        "type": "Ext.form.field.ComboBox",
                        "reference": {
                            "name": "items",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "allowBlank": false,
                            "displayField": "type",
                            "fieldLabel": "User Type",
                            "fieldStyle": "text-align: center; font-family:'Abel' ; font-size:18px;",
                            "id": "UserManageType",
                            "itemId": "UserManageType",
                            "labelStyle": "text-align: center; font-family:'Abel' ; font-size:18px;",
                            "margin": 20,
                            "queryMode": "local",
                            "store": "UserTypeStore",
                            "valueField": "type"
                        },
                        "name": "MyComboBox"
                    },
                    {
                        "type": "Ext.form.field.Text",
                        "reference": {
                            "name": "items",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "allowBlank": false,
                            "fieldLabel": "Points",
                            "fieldStyle": "text-align: center; font-family:'Abel' ; font-size:18px;",
                            "id": "manageUserPoints",
                            "inputType": "number",
                            "itemId": "manageUserPoints",
                            "labelStyle": "text-align: center; font-family:'Abel' ; font-size:18px;",
                            "margin": 20
                        },
                        "name": "MyTextField20"
                    },
                    {
                        "type": "Ext.button.Button",
                        "reference": {
                            "name": "items",
                            "type": "array"
                        },
                        "codeClass": null,
                        "userConfig": {
                            "height": 30,
                            "id": "manageUserBtnConfirm",
                            "itemId": "manageUserBtnConfirm",
                            "margin": "0 0 0 100",
                            "padding": "",
                            "text": "Confirm",
                            "width": "50%"
                        },
                        "name": "MyButton35"
                    },
                    {
                        "type": "Ext.container.Container",
                        "reference": {
                            "name": "items",
                            "type": "array"
                        },
                        "codeClass": null,
                        "name": "MyContainer24"
                    }
                ]
            }
        ]
    },
    "linkedNodes": {},
    "boundStores": {
        "0b3725db-c59f-4494-81a1-4674fd039370": {
            "type": "Ext.data.Store",
            "reference": {
                "name": "items",
                "type": "array"
            },
            "codeClass": null,
            "userConfig": {
                "data": [
                    "[",
                    "    {",
                    "        \"type\": \"customer\"",
                    "    },",
                    "    {",
                    "        \"type\": \"admin\"",
                    "    }",
                    "]"
                ],
                "designer|userClassName": "UserTypeStore",
                "model": "UserTypeModel",
                "storeId": "UserTypeStore"
            },
            "name": "MyStore"
        }
    },
    "boundModels": {
        "94138199-9eac-4cdb-9d6c-961041c6dc90": {
            "type": "Ext.data.Model",
            "reference": {
                "name": "items",
                "type": "array"
            },
            "codeClass": null,
            "userConfig": {
                "designer|userClassName": "UserTypeModel"
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
                        "name": "type"
                    },
                    "name": "MyField37"
                }
            ]
        }
    }
}