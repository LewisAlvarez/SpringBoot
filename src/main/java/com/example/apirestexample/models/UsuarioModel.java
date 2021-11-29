package com.example.apirestexample.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    private Long id;

    private String nombre;
    private String email;
    private Integer prioridad;

}
