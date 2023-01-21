package com.sistema.adopcion.service;

import com.sistema.adopcion.models.SolicitudAdopcion;
import com.sistema.adopcion.repository.SolicitudDeAdopcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class SolicitudAdopcionServiceImpl extends GenericServiceImpl<SolicitudAdopcion, Integer> implements SolicitudAdopcionService {

    @Autowired
    SolicitudDeAdopcionRepository solicitudDeAdopcionRepository;

    @Override
    public CrudRepository<SolicitudAdopcion, Integer> getDao() {
        return solicitudDeAdopcionRepository;
    }

}