package com.sistema.adopcion.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Pregunta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pregunta")
    private Integer idPregunta;

    @Column(name = "pregunta")
    private String pregunta;

    @Column(name = "estado")
    private Boolean estado;

    @JsonIgnore
    @OneToMany(mappedBy = "pregunta")
    private List<Pregunta> preguntas;


}
