var ctrlLeitura = 0;


module.exports.index = function (app, req, res) {
    res.render('home/home');
}

module.exports.postInfo = function (app, req, res) {
    // file system module to perform file operations
    const fs = require('fs');
    var content = req.body.dado; // content é a variavel que é enviada no corpo

    //var jsonData = '{"persons":[{"name":"John1ewew4444","city":"New York"},{"name":"Phil","city":"Ohio"}]}';
    // parse to  json
    var jsonObj = JSON.parse(content);
    //console.log(jsonObj);
    // stringify JSON Object
    var jsonContent = JSON.stringify(jsonObj);

    retorno = {
        "status": "",
        "msg": ""
    };
    console.log("post request ");

    try {
        fs.writeFile("../server/app/public/history.json", jsonContent, 'utf8', function (err) { // escrever no arquivo
            if (err) {

                retorno.status = "Fail";
                retorno.msg = "There was an error trying to write the JSON file! ";


            } else {
                retorno.status = "Success";
                retorno.msg = "The JSON file was saved! ";
                ctrlLeitura = 1;

            }

        });
        fs.writeFile("../server/app/public/historyWeb.json", jsonContent, 'utf8', function (err) { // escrever no arquivo
            if (err) {

                retorno.status = "Fail";
                retorno.msg = "There was an error trying to write the JSON file! ";


            } else {
                retorno.status = "Success";
                retorno.msg = "The JSON file was saved! ";
            }



        });

        res.send(retorno);




    } catch (e) {

        retorno.status = "Fail";
        retorno.msg = "There was an error trying to write the JSON file! ";
        res.send(retorno);

    }






}
module.exports.getPos = function (app, req, res) {

    const fs = require('fs');
    retorno = {
        "status": "",
        "msg": "",
        "data": {
            "posicao": "",
            "situacaoUso": "",
            "Origem": ""
        }
    };

    console.log("get request ");
    try {
        fs.readFile('../server/app/public/history.json', (err, data) => {
            if (err) {
                retorno.status = "Fail";
                retorno.data.situacaoUso = "Fail";
                retorno.msg = "There was an error trying to read the JSON! ";
            } else {
                retorno.status = "Success";
                retorno.msg = "Sucess! The file was read! ";
                ctrlLeitura = 0;
            }
            let conteudo = JSON.parse(data);
            retorno.data = conteudo;
            res.send(retorno.data);

        });
    } catch (e) {

        retorno.status = "Fail";
        retorno.data.situacaoUso = "Fail";
        retorno.msg = "Not possible to read the file!  ";
        res.send(retorno);

    }


}



module.exports.confExistence = function (app, req, res) {
    retorno = {
        "status": "",
        "msg": ""
    };
    retorno.status = "Sucess!";
    retorno.msg = "Server found! ";
    res.send(retorno);

}

module.exports.getHistory = function (app, req, res) {

    const fs = require('fs');
    retorno = {
        "status": "",
        "msg": "",
        "data": {
            "posicao": "",
            "situacaoUso": "",
            "Origem": ""
        }
    };

    try {
        fs.readFile('../server/app/public/historyWeb.json', (err, data) => {
            if (err) {
                retorno.status = "Fail";
                retorno.data.situacaoUso = "Fail";
                retorno.msg = "There was an error trying to read the JSON! ";
            } else {
                retorno.status = "Success";
                retorno.msg = "Sucess! The file was read! ";
                ctrlLeitura = 0;
            }
            let conteudo = JSON.parse(data);
            retorno.data = conteudo;
            res.send(retorno.data);

        });
    } catch (e) {

        retorno.status = "Fail";
        retorno.data.situacaoUso = "Fail";
        retorno.msg = "Not possible to read the file!  ";
        res.send(retorno);

    }


}