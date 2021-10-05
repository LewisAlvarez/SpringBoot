package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;
import com.sun.tools.jconsole.JConsoleContext;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    @Override
    public void deleteUsuario(Long id) {
        //Primero se busca el usario por id en la db
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registerUsuario(Usuario usuario) {
        //Para guardar el usuario en laa base de datos usamos el metodo merge
        //entityManager.detach();
        entityManager.merge(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        //Va el nombre de la clase, NO en el nombre de la tabla
        String query = "FROM Usuario WHERE email = :email"; //Se está haciendo referencia a la clase usuario
        //El entityManager se encarga de hacer la consulta a la db
       List<Usuario> lista = entityManager.createQuery(query)
               .setParameter("email", usuario.getEmail())
               .getResultList();

       if (lista.isEmpty()){
           return null;
       }

       //Para verificar la contraseña
        //La sgte es la contraseña que se encuentra en la base de datos, que me retorna la consulta sql.
        String passwordHashed = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
       if( argon2.verify(passwordHashed, usuario.getPassword()) ){
           return lista.get(0);
       } else{
           return null;
       }
    }


}
