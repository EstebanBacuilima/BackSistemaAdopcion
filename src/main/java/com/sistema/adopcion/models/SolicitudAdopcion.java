package com.sistema.adopcion.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
public class SolicitudAdopcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud_adopcion")
    private Integer id_solicitud_adopcion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_solicitud_adopcion", nullable = false, updatable = false)
    private Date fecha_solicitud_adopcion;

    @Column(name = "razon")
    private String razon;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @Column(name="estado")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name="id_usuario",referencedColumnName ="id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_mascota",referencedColumnName ="id_mascota")
    private Mascota mascota;
}
