// Call the dataTables jQuery plugin
$(document).ready(function() {
//Ejecuta siempre que se cargue la pagina
//On ready
});

async function iniciarSesion(){

    let datos = {};

    datos.email = document.getElementById('txtInputEmail').value;
    datos.password = document.getElementById('txtInputPassword').value;


//Llama al servidor
  const request = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    //La siguiente linea toma cualquier objeto de javascript y convertila en un stirng de json
    body: JSON.stringify(datos)
  });

  const response = await request.text();

console.log(response);
  if (response != 'FAIL') {
    localStorage.token = response;
    localStorage.email = datos.email;
    window.location.href = 'usuarios.html';
  }else{
    alert("las credenciales son incorrectas. Por favor intente nuevamente.");
  }

}

