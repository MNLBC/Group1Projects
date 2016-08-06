/**
 * Created by ANDESMA on 8/5/2016.
 */
var mongoose = require('mongoose');
var userSchema = require('../models/UserModel');
var userController = {};
var UserModel = mongoose.model('todolist');

userController.getAllUsers = function (req, res) {
    UserModel.find({}, function (err, data) {
        if (err) {
            console.error(err);
        }
        res.json(data);

    });
};


userController.getUsersInfo = function (req, res) {
    UserModel.find(req.body, function (err, user) {
        if (err) {
            console.error(err);
        } else {
            res.json(user);
        }
    });
};

userController.removeItem = function (req, res) {
    UserModel.update({username: req.body.username}, {
        $pull: {
            todolist: {
                status: req.body.status,
                priority: req.body.priority,
                message: req.body.message
            }
        }
    }, function (err, user) {
        if (err) {
            console.error(err);
        } else {
            res.json(user);
        }
    });
};
userController.addTask = function (req, res) {
    UserModel.update({username: req.body.username}, {
        $push: {
            todolist: {
                status: req.body.status,
                priority: req.body.priority,
                message: req.body.message
            }
        }
    }, function (err, user) {
        if (err) {
            console.error(err);
        } else {
            res.json(user);
        }
    });
};

userController.updateTask = function (req, res) {
    UserModel.update(
        {
            username: req.body.username,
            "todolist.status": req.body.oldTask.status,
            "todolist.priority": req.body.oldTask.priority,
            "todolist.message": req.body.oldTask.message
        },
        {
            $set: {
                "todolist.$.status": req.body.newTask.status,
                "todolist.$.priority": req.body.newTask.priority,
                "todolist.$.message": req.body.newTask.message
            }
        }, function (err, user) {
            if (err) {
                console.error(err);
            } else {
                res.json(user);
            }
        });

};

userController.getTask = function (req, res) {
    UserModel.find({username: req.body.username}, function (err, user) {
        if (err) {
            console.error(err);
        } else {
            res.json(user);
        }
    });
};

module.exports = userController;