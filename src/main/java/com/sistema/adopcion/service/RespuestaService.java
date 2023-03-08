package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Respuesta;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RespuestaService extends GenericService<Respuesta, Integer>{

    List<Respuesta> listarRespuestasSolicitante(Integer idSolicitudAdopcion);

    List<Respuesta> respuestasPreguntasOrdenadas(Integer idSolicitudAdopcion);

}
