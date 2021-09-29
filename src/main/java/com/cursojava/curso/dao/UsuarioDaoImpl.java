package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/*
@Repository --> Funcionalidad de acceder al repositorio de la base de datos
@Transactional --> Como tratar las consultas de sql
 */

@Repository
@Transactional

public class UsuarioDaoImpl implements UsuarioDao{

    //Sirve para hacer la conexion con la base de datos
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        //Va el nombre de la clase, NO en el nombre de la tabla
        String query = "FROM Usuario"; //Se está haciendo referencia a la clase usuario
        //El entityManager se encarga de hacer la consulta a la db
        return entityManager.createQuery(query).getResultList();
    }
}
