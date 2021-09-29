package com.cursojava.curso.dao;

/*
E este paquete Dao van todas las clases para la conexion con la base de datos
Se declaran las funciones necesarios ara que despues sean implementadas por otra clase
 */

import com.cursojava.curso.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

}
