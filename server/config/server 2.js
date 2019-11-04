
var express = require('express');
var consign = require('consign');
var bodyParser = require('body-parser');
var expressValidator = require('express-validator');
var expressSession = require('express-session');
var app = express();
app.set('view engine', 'ejs');
app.set('views', './app/views');

// app.use(expressSession({
// 	secret: 'segredo',
// 	resave: false,
// 	saveUninitialized: false
// }));



app.use(express.static('./app/public'));
// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({
	extended: false
}));

// parse application/json
app.use(bodyParser.json());
app.use(expressValidator());
app.use(function (req, res, next) {
	if (!req.user)
		res.header('Cache-Control', 'private, no-cache, no-store, must-revalidate');
	next();
});
consign()
	.include('app/routes')
	.then('app/models')
	.then('app/controllers')
	.into(app);

module.exports = app;