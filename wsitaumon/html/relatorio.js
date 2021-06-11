function alertas() {
    
    fetch("http://localhost:8080/alarmes")
        //document.getElementById("txtinicio").value + "/" +
        //document.getElementById("txttermino").value)
        .then(res => res.json())
        .then(res => {
            var tabela =
                "<table class='table table-striped' border='1' align='center' width='80%'>" +
                "<tr>" +
                "<th>Id do Alarme</th>" +
                "<th>Nome</th>" +
                "<th>Descrição</th>" +
                "</tr>";

            for (contador = 0; contador < res.length; contador++) {
                tabela +=
                    "<tr>" +
                    "<td>" + res[contador].idAlarme + "</td>" +
                    "<td>" + res[contador].nome + "</td>" +
                    "<td>" + res[contador].descricao + "</td>" +
                    "</tr>";
            }

            tabela += "</table>";

            document.getElementById("resultado").innerHTML = tabela;
            
        })
        .catch(err => { window.alert("Alarmes não encontrados"); });




}



function filtrar() {

    fetch("http://localhost:8080/intervalo/" +
        document.getElementById("txtinicio").value + "/" +
        document.getElementById("txttermino").value)
        .then(res => res.json())
        .then(res => {
            var tabela =
                "<table class='table table-striped' border='1' align='center' width='80%'>" +
                "<tr>" +
                "<th>Hostname do Equipamento</th>" +
                "<th>Tipo de Alarme</th>" +
                "<th>Data do Evento</th>" +
                "</tr>";

            for (contador = 0; contador < res.length; contador++) {
                tabela +=
                    "<tr>" +
                    "<td>" + res[contador].equipamento.hostname + "</td>" +
                    "<td>" + res[contador].alarme.nome + "</td>" +
                    "<td>" + res[contador].dataEvt + "</td>" +
                    "</tr>";
            }

            tabela += "</table>";
            document.getElementById("resultado").innerHTML = tabela;
           

        })
        .catch(err => { window.alert("Evento não encontrado"); });

}