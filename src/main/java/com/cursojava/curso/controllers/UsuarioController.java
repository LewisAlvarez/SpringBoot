package com.cursojava.curso.controllers;

/*
Esta clase sirve para controlar las URL que se redirecciona el usuario en la pagina web
 1. Para indicar que la clase es un controlador usamos la anotacion @RestController
 */


import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class UsuarioController {

    /*
    @Autowired --> Automaticamente hace que la clase UsuarioDaoImpl se cree un objeto y lo guarde dentro de la varibale usuarioDao.
     */
    @Autowired
    private UsuarioDao usuarioDao;

    /*
    Para idicar la URL que deberia ser para que devuelva el contenido del método se usa @RequestMapping.
    Para usar un parámetro para la modificación de una url de manera dinamica se usa @PathVariable.
     */

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUser(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setName("Car");
        usuario.setLastName("Alvarez");
        usuario.setEmail("lewis040@hotmail.es");
        usuario.setPhoneNumber("31587699453");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsers(){
        return usuarioDao.getUsuarios();
    }

    /*
    @RequestBody --> para convertir el json que se recibe en un objeto tipo Usuario automaticamente.
     */
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void addUsers(@RequestBody Usuario usuario){
         usuarioDao.registerUsuario(usuario);
    }

    @RequestMapping(value = "usuariohgj")
    public Usuario modifyUser(){
        Usuario usuario = new Usuario();
        usuario.setName("Car");
        usuario.setLastName("Alvarez");
        usuario.setEmail("lewis040@hotmail.es");
        usuario.setPhoneNumber("31587699453");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        usuarioDao.deleteUsuario(id);
    }

    @RequestMapping(value = "usuariol")
    public Usuario searchUser(){
        Usuario usuario = new Usuario();
        usuario.setName("Car");
        usuario.setLastName("Alvarez");
        usuario.setEmail("lewis040@hotmail.es");
        usuario.setPhoneNumber("31587699453");
        return usuario;
    }
}
