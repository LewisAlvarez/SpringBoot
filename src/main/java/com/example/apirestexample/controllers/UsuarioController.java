package com.example.apirestexample.controllers;

import com.example.apirestexample.models.UsuarioModel;
import com.example.apirestexample.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    //Inyectar el servicio
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> getUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuarioModel){
        return usuarioService.guardarUsuario(usuarioModel);
    }

    @GetMapping(path = "/{id}")
    public UsuarioModel buscarPorID(@PathVariable("id") Long id){
        return usuarioService.ObtenerUsuarioPorID(id).get();
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarUsuarioPorID(@PathVariable("id") Long id){
        return usuarioService.eliminarUsuario(id)
                ? "Usuario eliminado, ID:" + id
                : "El usuario con ID"+id+ "no se ha eliminado";
    }
}