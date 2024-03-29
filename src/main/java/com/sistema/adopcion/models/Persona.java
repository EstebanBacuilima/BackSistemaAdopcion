package com.sistema.adopcion.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;

    private String cedula;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String genero;
    private String direccion;
    private String correo;
    private String telefono;
    private String celular;

    //References
    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Fundacion> fundacion;

    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Usuario> usuario;

}
