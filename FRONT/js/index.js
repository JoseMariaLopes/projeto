function login(event) {
    event.preventDefault();
    let usuario = document.getElementById("user").value;
    let senha = document.getElementById("password").value;
   
    //alert(usuario + " " + senha);
    //contruindo objeto javascript para enviar
    let loginMsg = {
        email : usuario,
        racf : usuario,
        senha: senha
    }

    //construindo a mensagem que será enviada ao backend
    let msg = {
        method: 'POST',
        body: JSON.stringify(loginMsg),
        headers:{
            'Content-type':'application/json'
        }
    }
    
    fetch("http://localhost:8080/user/login", msg)
        .then(res => tratarRetorno(res));

}

function tratarRetorno(retorno) {
    if (retorno.status == 200) {
        //document.getElementById("output").innerHTML = "login com sucesso"
        retorno.json().then(res => acessoPermitido(res));
            }else{
        document.getElementById("output").innerHTML = "usuario/senha inválidos"
    }
}

function acessoPermitido(user) {
    localStorage.setItem("userLogged", JSON.stringify(user));
    //localStorage.setItem("racf", JSON.stringify(user));
    //localStorage.setItem("nome", JSON.stringify(user));
    window.location = "usuario.html"
}