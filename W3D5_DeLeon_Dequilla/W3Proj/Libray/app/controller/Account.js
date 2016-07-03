/*
 * File: app/controller/Account.js
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

Ext.define('Libray.controller.Account', {
    extend: 'Ext.app.Controller',

    refs: [
        {
            ref: 'username',
            selector: '#userName'
        },
        {
            ref: 'password',
            selector: '#password'
        },
        {
            ref: 'registerForm',
            selector: '#registerForm'
        },
        {
            ref: 'booksCont',
            selector: '#mycontainer4'
        },
        {
            ref: 'loginRegisterCont',
            selector: '#mycontainer3'
        },
        {
            ref: 'borrowedCont',
            selector: '#mycontainer5'
        },
        {
            ref: 'welcome',
            selector: '#welcomeLabel'
        },
        {
            ref: 'firstNameReg',
            selector: '#fNameReg'
        },
        {
            ref: 'lastNameReg',
            selector: '#lNameReg'
        },
        {
            ref: 'userNameReg',
            selector: '#uNameReg'
        },
        {
            ref: 'passwordReg',
            selector: '#passswordReg'
        },
        {
            ref: 'confirmPassword',
            selector: '#cPasswordReg'
        }
    ],

    onLoginClick: function() {
        var userName = this.getUsername().getValue(),
            password = this.getPassword().getValue(),
            borrowerStore = Ext.getStore('BorrowersStore');
            isExisting = false;
           if (!(Ext.isEmpty(userName)) && !Ext.isEmpty(password)) {
                borrowerStore.each(function(record){
                var bUserName = record.get('uname'),
                    bPassword = record.get('password');

                    if ( userName == bUserName && password == bPassword){
                        isExisting = true;
                    }


                });
                           if (!isExisting) {
                        Ext.MessageBox.alert ('Warning', 'Incorrect user name/password');
                    } else {
                        this.getBooksCont().show();
                        this.getLoginRegisterCont().hide();
                        this.getWelcome().setValue(userName);
                    }

            } else {
                     Ext.MessageBox.alert ('Warning', 'Please complete all fields');
            }



    },

    onRegisterClick: function() {
        Ext.create('Ext.window.Window', {
            title: 'Hello',
        //     height: '80%',
        //     width: '80%',
            layout: 'fit',
            items: {  // Let's put an empty grid in just to illustrate fit layout
                xtype: 'registerForm'
            }
        }).show();

        // // Create new register form window
        // var register = Ext.create('widget.registerForm');
        // // Show window
        // register.show();
    },

    onManageBtnClick: function() {
            this.getBooksCont().hide();
            this.getBorrowedCont().show();
    },

    onBorrowBtnClick: function() {

    },

    onSubmitBtnClick: function(button) {
        alert('sad');
        var fName = this.getFirstNameReg(),
            lName = this.getLastNameReg(),
            uName = this.getUserNameReg(),
            pWord = this.getPasswordReg(),
            cPWord = this.getConfirmPassword(),
            store = Ext.getStore('BorrowersStore');

        if((!Ext.isEmpty(fName)) &&
               !Ext.isEmpty(fName) &&
               !Ext.isEmpty(fName) &&
               !Ext.isEmpty(fName) &&
               !Ext.isEmpty(fName)){
            if(pWord === cPWord){
                alert('success');
            }

        }else {
            Ext.MessageBox.alert ('Warning', 'Please complete all fields');
        }

    },

    init: function(application) {
        this.control({
            "#loginBtn": {
                click: this.onLoginClick
            },
            "#registerBtn": {
                click: this.onRegisterClick
            },
            "#manageBtn": {
                click: this.onManageBtnClick
            },
            "#borrowBtn": {
                click: this.onBorrowBtnClick
            },
            "#submitBtn": {
                click: this.onSubmitBtnClick
            }
        });
    }

});
