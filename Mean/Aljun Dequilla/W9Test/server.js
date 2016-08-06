'use strict';

var express = require('express');
var path = require('path');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var mongoose = require('mongoose');
var routes = require('./routes/user.route');
var config = require('./config/config');


// Bootstrap db connection
if (config.mongodb.debug) {
    mongoose.set('debug', true);
}
var db = mongoose.connect(config.mongodb.uri, config.mongodb.options, function (err) {
    if (err) {
        console.error('Could not connect to MongoDB!');
        console.error(err);
        process.exit(-1);
    }
    else {
        console.log('Connected to MongoDB!');
    }
});



// Start the web server
var app = express();
// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.engine('html', require('ejs').renderFile);
app.set('view engine', 'html');

app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: true
}));
app.use(cookieParser());

app.use(express.static(__dirname));

app.all('*', function (req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE,OPTIONS');
    res.header("Access-Control-Allow-Headers", "X-Requested-With,X-Powered-By,Content-Type");
    if (req.method === 'OPTIONS') {
        res.status(200).end();
    } else {
        next();
    }
});

app.use('/', routes);

app.set('port', process.env.PORT || 3000);

var server = app.listen(app.get('port'), function () {
    console.log('Express server listening on port ' + server.address().port);
});

module.exports = app;

