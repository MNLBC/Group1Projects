var config = require('./config/config'),
	http = require('http'),
	express = require('express'),
	bodyParser = require('body-parser'),
	cookieParser = require('cookie-parser'),
	mongoose = require('mongoose'),
	path = require('path'),
	session = require('express-session');
	

var db = mongoose.connect(config.mongodb.uri,config.mongodb.options, function(err){
	if(err){
		console.log('Could not connect to MONGO DB');
		console.error(err);
	}
});


mongoose.connection.on('error',function (err) {
	 console.error('MongoDB connection error ' + err );
	 process.exit(-1);
});

mongoose.connection.on('connected', function () {
	 console.log('Connection established in DB');
});

mongoose.connection.on('disconnected', function(){
	console.log('You lost connection in Mongo DB');
});

mongoose.connection.on('reconnected', function(){
	console.log('Reconnected to MongoDB');
});


var app = express();

app.use(bodyParser.urlencoded({
    limit: '8mb',
    extended: true
}));

app.use(bodyParser.json({limit: '8mb'}));

// Setting the app router and static folder
app.use(config.contextPath, express.static(path.resolve('./public')));

// CookieParser should be above session
app.use(cookieParser());

// Express MongoDB session storage
app.use(session({
    saveUninitialized: true,
    resave: true,
    secret: config.sessionSecret,
    name: config.sessionName
}));

var httpServer = http.createServer(app);
httpServer.on('error', function (err) {
    console.error(err);
});


process.on('uncaughtException', function (err) {
    console.error(JSON.stringify(err));
    console.error(err);
});

// ctrl-c graceful shutdown
process.on('SIGINT', function () {
    process.exit(0);
});

// Globbing express routing files
var router = express.Router();
config.getGlobbedFiles('./app/routes/*.js').forEach(function (routePath) {
    require(path.resolve(routePath))(router);
});


app.use(config.contextPath, router);

// Start the app by listening on <port>
httpServer.listen(config.port);

// Expose app
exports = module.exports = app;

// Logging initialization
console.log('------------------------------------');
console.log('application started');
console.log('Port:\t\t\t\t', config.port);
console.log('------------------------------------');

