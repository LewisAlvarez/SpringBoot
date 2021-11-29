package com.example.apirestexample.services;

import com.example.apirestexample.models.UsuarioModel;
import com.example.apirestexample.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.ArrayList;
import java.util.Optional;

//@Service-->Para indicar a la clase que se comporte como un servicio para la logica empresarial
@Service
public class UsuarioService  {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /*
    Obtener todos los usuarios en la DB
     */

    public ArrayList<UsuarioModel>  obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    /*
    Guardar usuario en la DB, retorna el usuario agregado
     */

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    /*
    Buscar por ID
     */

    public Optional<UsuarioModel> ObtenerUsuarioPorID(Long id) {
        return usuarioRepository.findById(id);
    }

    /*
    Eliminar usuario por ID
     */

    public boolean eliminarUsuario(Long id){
        boolean eliminado = false;
        try{
            usuarioRepository.deleteById(id);
            eliminado = true;
        } catch(Exception e){
            e.printStackTrace();
        }
        return eliminado;
    }


}
