package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Seguimiento;
import com.sistema.adopcion.repository.SeguimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SeguimientoServiceImpl extends GenericServiceImpl<Seguimiento, Integer> implements SeguimientoService {

    @Autowired
    SeguimientoRepository seguimientoRepository;

    @Override
    public CrudRepository<Seguimiento, Integer> getDao() {
        return seguimientoRepository;
    }
    @Override
    public List<Seguimiento> listarSeguimientosPorMascota(Integer idMascota) {
        return seguimientoRepository.findByMascotaIdMascota(idMascota);
    }

    @Override
    public boolean verificarRegistro(Integer idMascota, Date fechaSeguimiento) {
        if (seguimientoRepository.verificarRegistro(idMascota,fechaSeguimiento)!=null) {
            return true;
        }else {
            return false;
        }
    }

}