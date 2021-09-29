// Call the dataTables jQuery plugin
$(document).ready(function() {
//Ejecuta siempre que se cargue la pagina
//alert("123");
   cargarUsuarios();
  $('#usuarios').DataTable();
});

async function cargarUsuarios(){

  const request = await fetch('api/usuarios', {
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

    let botonEliminar = '<a href="#" onclick="eliminarUsuario('+ usuario.id +')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

  let userHTML = '<tr><td>'+usuario.id+'</td><td>'+usuario.name+' '+usuario.lastName+' </td><td>'+usuario.email+' </td><td>'+usuario.phoneNumber+' </td><td>'+botonEliminar+'</td></tr>';
  listHTML += userHTML;

  }

  document.querySelector('#usuarios tbody').outerHTML = listHTML;

}

async function eliminarUsuario(id){

    if(confirm("¿Desea eliminar este usuario?")){
              const request = await fetch('api/usuarios/' + id, {
                method: 'DELETE',
                headers: {
                  'Accept': 'application/json',
                  'Content-Type': 'application/json'
                },
                //body: JSON.stringify({a: 1, b: 'Textual content'})
              });
            //alert(id);
            location.reload();
    }else{
        return;
    }
}