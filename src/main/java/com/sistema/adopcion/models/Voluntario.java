package com.sistema.adopcion.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Setter
@Getter
@Entity
public class Voluntario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_voluntario")
    private Integer id_voluntario;

    @Column(name="area_trabajo")
    private String area_trabajo;

    @Column(name="cargo")
    private String cargo;

    @Column(name="estado")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name="id_usuario",referencedColumnName ="id_usuario")
    private Usuario usuario;


}
