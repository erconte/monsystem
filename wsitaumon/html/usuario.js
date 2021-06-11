// função Logoff

function LogOff(){
    alert("Deseja sair da página");
    localStorage.removeItem("userlogado");
    window.location.href="index.html";
}


// Função exibir usuario

// var userstr (user string) podia ser qualquer nome 
function exibirusuario() {
    var userstr = localStorage.getItem("userlogado");
    if (userstr == null) {
        windows.location = "login.html";
    } else {
        var userjson = JSON.parse(userstr);
        document.getElementById("foto").innerHTML = // sintaxe para puxar a foto na tela
            "<img width='70%' src=imagens/" + userjson.foto + ">";

        document.getElementById("dados").innerHTML = // sintaxe para puxar os dados na tela
            "<h5> <i> Olá, </i>" + userjson.nome + "<br> </h5> <h6>" + userjson.email + "<br>ID: " + userjson.id + "</h6>";
    }
}

// Função Logar

function logar() {

    var carta = {
        email: document.getElementById("txtemail").value,
        senha: document.getElementById("txtsenha").value
    };

    var envelope = {
        method: "POST",
        body: JSON.stringify(carta),
        headers: {
            "content-type": "application/json"
        }
    };

    fetch("http://localhost:8080/login", envelope)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("userlogado", JSON.stringify(res));
            window.location = "usuario.html"
        })
        .catch(err => {
            window.alert("não foi possivel validar seus dados");
        });

}
