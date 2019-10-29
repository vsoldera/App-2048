async function showResults(data){

    document.getElementById("tabela").innerHTML += data.persons;

}




const getInfos = async() =>{

    var dados =  await axios.get("/getPos").then(function (response) {
        if (response.status == "error" || response.status == "undefined") console.log(response.status);
        else {
            //console.log( response.data);

            //console.log( response.status);
            console.log(response.data.data);

          showResults(response.data.data);




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