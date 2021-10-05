// Call the dataTables jQuery plugin
$(document).ready(function() {
//Ejecuta siempre que se cargue la pagina
//On ready
});

async function registrarUsuarios(){

    let datos = {};
    datos.name = document.getElementById('txtNombre').value;
    datos.lastName = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    let repeatPass =  document.getElementById('txtRepeatPassword').value;

  if (repeatPass != datos.password){
    alert("Las contraseñas son diferentes!!");
    return;
  }

  const request = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    //La siguiente linea toma cualquier objeto de javascript y convertila en un stirng de json
    body: JSON.stringify(datos)
  });
  //const usuarios = await request.json();
  alert("La cuenta fue creada con éxito!")
  window.location.href = 'login.html';
}

