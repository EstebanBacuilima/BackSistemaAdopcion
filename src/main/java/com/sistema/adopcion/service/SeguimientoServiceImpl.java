package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Seguimiento;
import com.sistema.adopcion.repository.SeguimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class SeguimientoServiceImpl extends GenericServiceImpl<Seguimiento, Integer> implements SeguimientoService {

    @Autowired
    SeguimientoRepository seguimientoRepository;

    @Override
    public CrudRepository<Seguimiento, Integer> getDao() {
        return seguimientoRepository;
    }

}