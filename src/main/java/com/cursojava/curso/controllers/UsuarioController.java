package com.cursojava.curso.controllers;

/*
Esta clase sirve para controlar las URL que se redirecciona el usuario en la pagina web
 1. Para indicar que la clase es un controlador usamos la anotacion @RestController
 */


import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class UsuarioController {

    /*
    Para idicar la URL que deberia ser para que devuelva el contenido del método se usa @RequestMapping.
    Para usar un parámetro para la modificación de una url de manera dinamica se usa @PathVariable.
     */

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUser(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setName("Car");
        usuario.setLastName("Alvarez");
        usuario.setEmail("lewis040@hotmail.es");
        usuario.setPhoneNumber("31587699453");
        return usuario;
    }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsers(){

        Usuario user1 = new Usuario();
        user1.setId(123L);
        user1.setName("Car");
        user1.setLastName("Alvarez");
        user1.setEmail("lewis040@hotmail.es");
        user1.setPhoneNumber("31587699453");

        Usuario user2 = new Usuario();
        user2.setId(456L);
        user2.setName("Juan");
        user2.setLastName("Gutierrez");
        user2.setEmail("juan123@hotmail.es");
        user2.setPhoneNumber("38565153");

        Usuario user3 = new Usuario();
        user3.setId(789L);
        user3.setName("Jose");
        user3.setLastName("Piñeda");
        user3.setEmail("jose@hotmail.es");
        user3.setPhoneNumber("4156456453");

        List<Usuario> users = new ArrayList<Usuario>();
        users.add(user1);
        users.add(user2);
        users.add(user3);


        return users;
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

    @RequestMapping(value = "usuariohfjg")
    public Usuario deleteUser(){
        Usuario usuario = new Usuario();
        usuario.setName("Car");
        usuario.setLastName("Alvarez");
        usuario.setEmail("lewis040@hotmail.es");
        usuario.setPhoneNumber("31587699453");
        return usuario;
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
