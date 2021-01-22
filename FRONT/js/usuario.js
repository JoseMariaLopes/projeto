function validaLogin() {
    let userTxt = localStorage.getItem("userLogged");
    
    

    if ( !userTxt ) {
        window.location = "index.html"
    }    
    let user = JSON.parse(userTxt);
    document.getElementById("divracf").innerHTML = user.racf;
    document.getElementById("divnome").innerHTML = user.nome;
    carregar(user);
}

function logout() {
    localStorage.removeItem("userLogged");
    window.location = "index.html";
}

function carregar(user) {

    let usuario = {
        id: user.id
    }

    let msg = {
        method: 'POST',
        body: JSON.stringify(usuario),
        headers: {
            'Content-type': 'application/json'
        }
    }

    fetch("http://localhost:8080/comunidade/user", msg)
        .then(res => res.json())
        .then(res => exibirComunidades(res));
}

function exibirComunidades(comunidades) {
    let tabelaComunidades = '<table class="table table-sm"> <tr> <th>Nome</th> <th></th> </tr>';
    
    for (i = 0; i < comunidades.length; i++) {
        tabelaComunidades = tabelaComunidades + `<tr> 
                            <td> ${comunidades[i].nome_comunidade} </td> 
                            <td class="text-center"> <button class="btn btn-sm btn-outline-success" onclick="novaModernizacao(${comunidades[i].id_comunidade}, '${comunidades[i].nome_comunidade}')">NOVO</button> 
                            <button class="btn btn-sm btn-outline-primary" onclick="exibirModernizacao(${comunidades[i].id_comunidade}, '${comunidades[i].nome_comunidade}')">EXTRATO</button> </td> 
                        </tr>`;
    }
    tabelaComunidades += '</table>';
    document.getElementById("tabela").innerHTML = tabelaComunidades; 


}

function novaModernizacao(id_comunidade, nome_comunidade) {
    let comunidade ={
        id_comunidade,
        nome: nome_comunidade
    }
    localStorage.setItem("comunidade", JSON.stringify(comunidade));
    window.location = "novo.html";
}

function exibirModernizacao(id_comunidade, nome_comunidade) {
    let comunidade ={
        id_comunidade,
        nome: nome_comunidade
    }
    localStorage.setItem("comunidade", JSON.stringify(comunidade));
    window.location = "extrato.html";
}