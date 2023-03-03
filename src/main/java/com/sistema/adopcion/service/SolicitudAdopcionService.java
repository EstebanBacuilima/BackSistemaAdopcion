package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Seguimiento;
import com.sistema.adopcion.models.SolicitudAdopcion;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SolicitudAdopcionService extends GenericService<SolicitudAdopcion, Integer> {

    List<SolicitudAdopcion> listarSolicitudesPorFundacion(Integer id_fundacion);

    List<SolicitudAdopcion> listarSolictudesPorUsuario(Integer idUsuario);

    List<SolicitudAdopcion> listarPorEstado(String estado,Integer idFundacion);

    List<SolicitudAdopcion> findBySoliPorMascotaUsuario(Integer idMascota,Integer idUsuario);

}
