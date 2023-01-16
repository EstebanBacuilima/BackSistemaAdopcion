package com.sistema.adopcion.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_persona;

    private String cedula;
    private String nombres;
    private String apellidos;
    private Date fechaNacimmiento;
    private String genero;
    private String direccion;
    private String correo;
    private String telefono;
    private String celular;

}
