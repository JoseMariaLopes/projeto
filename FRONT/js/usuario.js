function validaLogin() {
    let userTxt = localStorage.getItem("userLogged");
    let nome    = localStorage.getItem("nome");
    let racf    = localStorage.getItem("racf");
   
    document.getElementById("divnome").innerHTML = nome;
    document.getElementById("divracf").innerHTML = racf;

    if ( !userTxt ) {
        window.location = "index.html"
    }    
}

function logout() {
    localStorage.removeItem("userLogged");
    window.location = "index.html";
}


    
