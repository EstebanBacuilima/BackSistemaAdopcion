package com.sistema.adopcion.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id_usuario;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "rol")
    private String rol;

    @Column(name = "foto_perfil")
    private String foto_perfil;

    @Column(name="estado")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name="id_persona",referencedColumnName ="id_persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name="id_fundacion",referencedColumnName ="id_fundacion")
    private Fundacion fundacion;

    // Reference
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<SolicitudAdopcion> solicitudAdopciones;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Mascota> mascotas;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Voluntario> voluntarios;
}
