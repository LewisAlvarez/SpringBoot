// Call the dataTables jQuery plugin
$(document).ready(function() {
//Ejecuta siempre que se cargue la pagina
//alert("123");
   cargarUsuarios();
  $('#usuarios').DataTable();
});

async function cargarUsuarios(){

  const request = await fetch('usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    //body: JSON.stringify({a: 1, b: 'Textual content'})
  });
  const usuarios = await request.json();

  console.log(usuarios);

  let listHTML = '';
  for (let usuario of usuarios){

  let userHTML = '<tr><td>'+usuario.id+'</td><td>'+usuario.name+' '+usuario.lastName+' </td><td>'+usuario.email+' </td><td>'+usuario.phoneNumber+' </td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';
  listHTML += userHTML;

  }

  document.querySelector('#usuarios tbody').outerHTML = listHTML;

}
