package com.example.apirestexample.repositories;

import com.example.apirestexample.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Reository --> Para indicar que la clase tenra aceso a la DB
@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
}
