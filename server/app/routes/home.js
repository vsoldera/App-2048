module.exports = function (app) {
    // Resgata GET na raiz
    app.get('/', function (req, res) {
        app.app.controllers.home.home.index(app, req, res);
    });
    app.get('/getPos', function (req, res) {
        app.app.controllers.home.home.getPos(app, req, res);
    });
    app.post('/postInfo', function (req, res) {
        app.app.controllers.home.home.postInfo(app, req, res);
    });
    app.get('/confExistence', function (req, res) {
        app.app.controllers.home.home.confExistence(app, req, res);
    });
    app.get('/getHistory', function (req, res) {
        app.app.controllers.home.home.getHistory(app, req, res);
    });
};