package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Respuesta;

import java.util.List;

public interface RespuestaService extends GenericService<Respuesta, Integer>{

    List<Respuesta> listarRespuestasSolicitante(Integer idSolicitudAdopcion);

}
