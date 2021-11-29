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
}
