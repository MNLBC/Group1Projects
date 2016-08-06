/**
 * Created by ANDESMA on 8/5/2016.
 */
'use strict';
var express = require('express');
var router = express.Router();

var userController = require('../controllers/UserController');

var urlBase = '/login';

/* GET home page. */
router.get('/', function (req, res) {
    res.render('index');
});

/**
 * Mapping URL: get all notes
 */
router.get(urlBase, function (req, res) {
    userController.getAllUsers(req, res);
});

router.post(urlBase, userController.getUsersInfo);

router.put(urlBase + "/removeItem", userController.removeItem);

router.put(urlBase + "/addTask", userController.addTask);

router.put(urlBase + "/updateTask", userController.updateTask);

router.post(urlBase + "/getTask", userController.getTask);

module.exports = router;

