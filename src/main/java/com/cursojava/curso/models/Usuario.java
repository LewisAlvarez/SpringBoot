package com.cursojava.curso.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "name")
    private String name;

    @Getter @Setter @Column(name = "last_name")
    private String lastName;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "phone_number")
    private String phoneNumber;

    @Getter @Setter @Column(name = "password")
    private String password;


}
