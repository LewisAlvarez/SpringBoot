package com.example.apirestexample.controllers;

import com.example.apirestexample.models.UsuarioModel;
import com.example.apirestexample.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    /*
    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuarioModel){
        return usuarioService.guardarUsuario(usuarioModel);
    }
    */

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

    @PostMapping()
    public List<UsuarioModel> guardarUsuarios(@RequestBody List<UsuarioModel> usuarios){
        return usuarioService.guardarVariosUsuarios(usuarios);
    }

    /*
    Buscar usuarios por prioridad
    Consulta: http://localhost:8080/usuarios/query?prioridad=3
     */
    @GetMapping(path = "/query")
    public List<UsuarioModel> buscarUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return usuarioService.buscarUsuariosPorPrioridad(prioridad);
    }

    /*
    Buscar usuarios por Nombre
    Consulta: http://localhost:8080/usuarios/query2?nombre=juan
    */
    @GetMapping(path = "/query2")
    public List<UsuarioModel> buscarUsuarioPorNombre(@RequestParam("nombre") String nombre){
        return usuarioService.buscarUsuariosPorNombre(nombre);
    }

}