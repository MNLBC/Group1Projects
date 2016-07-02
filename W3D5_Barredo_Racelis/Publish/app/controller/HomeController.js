/*
 * File: app/controller/HomeController.js
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

Ext.define('Project.controller.HomeController', {
    extend: 'Ext.app.Controller',

    views: [
        'Home'
    ],

    refs: [
        {
            ref: 'showLoginWindow',
            selector: '#showLoginWindow'
        },
        {
            ref: 'homePanel',
            selector: '#homePanel'
        },
        {
            ref: 'searchPanel',
            selector: '#searchPanel'
        },
        {
            ref: 'signupBtn',
            selector: '#signupBtn'
        }
    ],

    onShowLoginWindowClick: function() {
        Ext.create('Project.view.LoginWindow').show();
    },

    onSearchButtonClick: function() {
            this.getHomePanel().hide();
            this.getSearchPanel().show();
    },

    onHomeButtonClick: function() {
                this.getHomePanel().show();
                this.getSearchPanel().hide();
    },

    onSignupBtnClick: function() {
                Ext.create('Project.view.SignUpWindow').show();
    },

    init: function(application) {
        this.control({
            "#showLoginWindow": {
                click: this.onShowLoginWindowClick
            },
            "#searchButton": {
                click: this.onSearchButtonClick
            },
            "#homeButton": {
                click: this.onHomeButtonClick
            },
            "#signupBtn": {
                click: this.onSignupBtnClick
            }
        });
    }

});
