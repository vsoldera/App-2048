var controleExibicaoRepetidaUsed = 0;
var controleExibicaoRepetidaToUse = 0

function estiloTextoUso(dado){
    if(dado == "used"){
        return "<td style='color:#22AF80'> Sucesso! </td>";
    }
    if(dado == "toUse"){
        return "<td style='color:#CED509'> Aguardando... </td>";
    }
    if(dado == "fail"){
        return "<td style='color:#D5091B'> Falha! </td>";
    }
}
async function showResults(data){

    document.getElementById("tabela").innerHTML += "<tr> <td>"+ data.posicao+"</td>"+  estiloTextoUso(data.situacaoUso)+"<td>"+data.Origem+"</td></tr>";
 

}


const getInfos = async() =>{

    var dados =  await axios.get("/getPos").then(function (response) {
        if (response.status == "error" || response.status == "undefined") console.log(response.status);
        else {
            //console.log( response.data);

            //console.log( response.status);
            console.log(response.data);

           
            if(response.data.situacaoUso == "used") controleExibicaoRepetidaUsed++;
            else controleExibicaoRepetidaToUse++;

            if(controleExibicaoRepetidaUsed < 2 && response.data.situacaoUso == "used"){
                controleExibicaoRepetidaToUse = 0
                showResults(response.data);
            }
            else if(controleExibicaoRepetidaToUse < 2 && response.data.situacaoUso == "toUse"){
                controleExibicaoRepetidaUsed = 0;
                showResults(response.data);
                
            } 

          




        }


    });
}
const postInfos = async (conteudoJSON) =>{
    console.log(conteudoJSON);
    var dados = await axios.post("/postInfo", {
    content: conteudoJSON
}).then(function (response) {
  
        //console.log( response.data);

        //console.log( response.status);
        console.log(response.status);
        console.log(response.data.msg);

        //showResultsTR(response.data.data, filtro);




    


});

}