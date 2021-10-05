package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class AuthController {

    /*
        @Autowired --> Automaticamente hace que la clase UsuarioDaoImpl se cree un objeto y lo guarde dentro de la varibale usuarioDao.
    */
    @Autowired
    private UsuarioDao usuarioDao;

    /*
        @RequestBody --> para convertir el json que se recibe en un objeto tipo Usuario automaticamente.
    */
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        if (usuarioDao.verificarEmailPassword(usuario)){
            return "OK";
        }
        return "FAIL";
    }
}
