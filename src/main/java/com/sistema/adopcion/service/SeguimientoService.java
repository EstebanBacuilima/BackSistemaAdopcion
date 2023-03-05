package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Seguimiento;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SeguimientoService extends GenericService<Seguimiento, Integer>{

    List<Seguimiento> listarSeguimientosPorMascota(Integer idMascota);

    List<Seguimiento> listarInformesSeguimientosPorMascota(Integer idMascota);
    boolean verificarRegistro(Integer idMascota, Date fechaSeguimiento);
}
