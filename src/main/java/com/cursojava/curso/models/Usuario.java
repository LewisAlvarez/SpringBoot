package com.cursojava.curso.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
Le indicamos a esta clase que tabla debe de utilizar
@Entity --> para indicar que la clase va a ser una entidad de la base de datos
@Table para indicar a que tabla de la db hace referencia
 */

@Entity
@Table(name = "usuarios")
@ToString
public class Usuario {

    /*
    Se agrega las depencias lombok para simplificar el codio
    Para indicar cada atributo a cual columna de la db pertenece usamos @Collumn(name = nombreEnTabla)
    @Id es para indicar que esa es la llave primaria
     */

    @Id
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "name")
    private String name;

    @Getter @Setter @Column(name = "lastName")
    private String lastName;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "phoneNumber")
    private String phoneNumber;

    @Getter @Setter @Column(name = "password")
    private String password;


}
