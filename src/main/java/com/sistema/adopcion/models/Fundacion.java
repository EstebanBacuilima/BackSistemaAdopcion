package com.sistema.adopcion.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Fundacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fundacion")
    private Integer idFundacion;

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "nombre_fundacion")
    private String nombre_fundacion;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    @Column(name = "acronimo")
    private String acronimo;

    @Column(name = "mision")
    private String mision;

    @Column(name = "logo")
    private String logo;

    @Column(name = "estado")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name="id_persona",referencedColumnName ="id_persona")
    private Persona persona;

    //References
    @JsonIgnore
    @OneToMany(mappedBy = "fundacion")
    private List<Mascota> mascotas;

    @JsonIgnore
    @OneToMany(mappedBy = "fundacion")
    private List<Usuario> usuarios;

}
