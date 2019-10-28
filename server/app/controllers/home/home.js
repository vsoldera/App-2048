var bcrypt = require('bcryptjs');
const saltRounds = 10;

module.exports.index = function (app, req, res) {
    res.render('home/home');
}


