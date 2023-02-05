package com.sistema.adopcion.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuesta")
    private Integer idRespuesta;

    @Column(name = "respuestas")
    private String respuestas;

    @ManyToOne
    @JoinColumn(name="id_pregunta",referencedColumnName ="id_pregunta")
    private Pregunta pregunta;

    @ManyToOne
    @JoinColumn(name="id_solicitud_adopcion",referencedColumnName ="id_solicitud_adopcion")
    private SolicitudAdopcion solicitudAdopcion;

}
