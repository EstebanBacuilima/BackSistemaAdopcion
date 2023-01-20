package com.sistema.adopcion.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
public class Seguimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSeguimiento;

    @Column(name="fecha_seguimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_seguimiento;

    @Column(name="descripcion_visita")
    private String descripcion_visita;

    @Column(name="descripcion_mascota")
    private String descripcion_mascota;

    @Column(name="estado_comportamiento")
    private String estado_comportamiento;

    @Column(name="estado_salud")
    private String estado_salud;

    @Column(name="foto_evidencia")
    private String foto_evidencia;

    @Column(name="estado")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name="id_mascota",referencedColumnName ="id_mascota")
    private Mascota mascota;
}
