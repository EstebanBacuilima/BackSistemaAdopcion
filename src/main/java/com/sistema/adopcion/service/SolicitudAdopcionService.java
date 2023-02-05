package com.sistema.adopcion.service;

import com.sistema.adopcion.models.SolicitudAdopcion;

import java.util.List;

public interface SolicitudAdopcionService extends GenericService<SolicitudAdopcion, Integer> {

    List<SolicitudAdopcion> listarSolicitudesPorFundacion(Integer id_fundacion);

    List<SolicitudAdopcion> listarSolictudesPorUsuario(Integer idUsuario);

}
