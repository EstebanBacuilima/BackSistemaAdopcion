package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Persona;
import com.sistema.adopcion.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Integer> implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public CrudRepository<Persona, Integer> getDao() {
        return personaRepository;
    }

    @Override
    public Persona porCedula(String cedula) {
        return personaRepository.findByCedula(cedula);
    }
}
