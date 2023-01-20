package com.sistema.adopcion.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Integer idMascota;

    @Column(name = "chip_mascota")
    private String chip_mascota;

    @Column(name = "nombre_mascota")
    private String nombre_mascota;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "especie")
    private String especie;

    @Column(name = "raza")
    private String raza;

    @Column(name = "color")
    private String color;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @Column(name = "foto", nullable = true)
    private String foto;

    @Column(name = "estado_mascota")
    private boolean estado_mascota;

    @Column(name = "estado_adopcion")
    private boolean estado_adopcion;

    @ManyToOne
    @JoinColumn(name="id_fundacion",referencedColumnName ="id_fundacion")
    private Fundacion fundacion;

    @ManyToOne
    @JoinColumn(name="id_usuario",referencedColumnName ="id_usuario")
    private Usuario usuario;

    //References
    @JsonIgnore
    @OneToMany(mappedBy = "mascota")
    private List<Seguimiento> seguimientos;

    @JsonIgnore
    @OneToMany(mappedBy = "mascota")
    private List<SolicitudAdopcion> solicitudAdopciones;

}
