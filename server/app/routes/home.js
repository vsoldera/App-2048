module.exports = function (app) {
    // Resgata GET na raiz
    app.get('/', function (req, res) {
        app.app.controllers.home.home.index(app, req, res);
    })
  
};