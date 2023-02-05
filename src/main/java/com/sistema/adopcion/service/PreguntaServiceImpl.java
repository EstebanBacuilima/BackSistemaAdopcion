package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Pregunta;
import com.sistema.adopcion.repository.PreguntasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PreguntaServiceImpl extends GenericServiceImpl<Pregunta, Integer> implements PreguntaService {

    @Autowired
    PreguntasRepository preguntasRepository;

    @Override
    public CrudRepository<Pregunta, Integer> getDao() {
        return preguntasRepository;
    }

}