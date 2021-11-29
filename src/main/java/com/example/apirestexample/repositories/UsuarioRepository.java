package com.example.apirestexample.repositories;

import com.example.apirestexample.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Reository --> Para indicar que la clase tenra aceso a la DB
@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    public abstract List<UsuarioModel> findByPrioridad(Integer prioridad);
    public abstract List<UsuarioModel> findByNombre(String nombre);
}
