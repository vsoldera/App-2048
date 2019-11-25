var ctrlLeitura = 0;


module.exports.index = function (app, req, res) {
    res.render('home/home');
}

module.exports.postInfo = function(app, req, res){
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
    
if(ctrlLeitura == 0){
    fs.writeFile("../server/app/public/history.json", jsonContent, 'utf8', function (err) { // escrever no arquivo
        if (err) {
            
            retorno.status = "Fail";
            retorno.msg = "Ocorreu um erro ao escrever o JSON Object no arquivo";
            
            
        }else {
            retorno.status = "Success";
            retorno.msg = "O aquivo JSON foi salvo!";
            ctrlLeitura = 1;

        }

        res.send(retorno);

    });
}else{
    retorno.status = "Fail";
    retorno.msg = "Não preparado ainda";
    res.send(retorno);

}


 

}
module.exports.getPos = function(app, req, res){

const fs = require('fs');
retorno = {
    "status": "",
    "msg": "",
    "data":{
        "posicao": "",
        "situacaoUso":"",
        "Origem": ""
    }
};

if(ctrlLeitura == 1){

    fs.readFile('../server/app/public/history.json', (err, data) => {
        if (err){
            retorno.status = "FAIL";
            retorno.data.situacaoUso ="fail";
            retorno.msg = "Ocorreu um erro ao ler o JSON Object no arquivo";
        } else{
            retorno.status = "Success";
            retorno.msg = "Arquivo lido com sucesso!";
            ctrlLeitura = 0;
        }
        let conteudo = JSON.parse(data);
        retorno.data = conteudo;
        res.send(retorno.data);
    });


}else{

        retorno.status = "FAIL";
        retorno.data.situacaoUso ="fail";
        retorno.msg = "Não preparado ainda";
        res.send(retorno.data);
}

}


