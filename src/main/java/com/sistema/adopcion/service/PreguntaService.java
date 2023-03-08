package com.sistema.adopcion.service;


import com.sistema.adopcion.models.Pregunta;

import java.util.List;

public interface PreguntaService extends GenericService<Pregunta, Integer>{

    List<Pregunta> listarPreguntas();

}
