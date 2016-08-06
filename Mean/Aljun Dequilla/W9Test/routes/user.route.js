var express = require('express'),
	router = express.Router(),
	userController = require('../controller/user.controller');

var urlBase = '/user';

router.get('/', function (req, res) {
    res.render('index');
});

router.get(urlBase, function (req, res) {
    userController.getAll(req, res);
});

router.post(urlBase + '/success', function (req, res) {
    userController.getUser(req, res);
});

router.put(urlBase + '/insert', function (req, res) {
    userController.saveTask(req, res);
});

router.put(urlBase + '/remove', function (req, res) {
    userController.removeTask(req, res);
});

router.put(urlBase + '/update', function (req, res) {
    userController.updateTask(req, res);
});



module.exports = router;