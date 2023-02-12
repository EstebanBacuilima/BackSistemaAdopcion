package com.sistema.adopcion.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class SolicitudAdopcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud_adopcion")
    private Integer idSolicitudAdopcion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_solicitud_adopcion")
    private Date fecha_solicitud_adopcion;

    @Column(name="estado")
    private char estado;

    @ManyToOne
    @JoinColumn(name="id_usuario",referencedColumnName ="id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_mascota",referencedColumnName ="id_mascota")
    private Mascota mascota;
}
