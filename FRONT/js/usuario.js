function validaLogin() {
    let userTxt = localStorage.getItem("userLogged");
    
    

    if ( !userTxt ) {
        window.location = "index.html"
    }    
    let user = JSON.parse(userTxt);
    document.getElementById("divracf").innerHTML = user.racf;
    document.getElementById("divnome").innerHTML = user.nome;
}

function logout() {
    localStorage.removeItem("userLogged");
    window.location = "index.html";
}

function buscarComunidade() {
    let idUser = document.getElementById("idUser").value;
    
    fetch("http://localhost:8080/user/id/"+idUser)
    .then(res => tratarRetorno(res));
}
function tratarRetorno(dados) {
    if (dados.status == 200) {
        dados.json().then(res => exibirComunidades(res));
    } else {
        document.getElementById("dadosComunidades").innerHTML = "Usuário não existe"
    }
    
}
function exibirComunidades(usuario) {
    console.log(usuario);
    if (usuario.comunidades.length == 0) {
        document.getElementById("dadosComunidades").innerHTML = "Usuário não contém Comunidades"
    } else {
       // document.getElementById("dadosAnuncios").innerHTML = usuario.anuncios[0].descricao
       let anuncios = usuario.anuncios;
       let dados ='<table> <tr> <th> Descrição </th> <th> Valor </th> </tr>';

       for (let i=0; i < anuncios.length; i++){
            dados += '<tr><td>' + anuncios[i].descricao + "</td><td>" + anuncios[i].valor + "</td></tr>"
       }
       dados+='</table>'
       document.getElementById("dadosComunidades").innerHTML = dados;
    } 
    
}