package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Mascota;
import com.sistema.adopcion.models.Persona;
import com.sistema.adopcion.models.Respuesta;
import com.sistema.adopcion.repository.PersonaRepository;
import com.sistema.adopcion.repository.RespuestaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaServiceImpl extends GenericServiceImpl<Respuesta, Integer> implements RespuestaService {

    @Autowired
    RespuestaRespository respuestaRespository;

    @Override
    public CrudRepository<Respuesta, Integer> getDao() {
        return respuestaRespository;
    }

    @Override
    public List<Respuesta> listarRespuestasSolicitante(Integer idSolicitudAdopcion) {
        return respuestaRespository.findBySolicitudAdopcionIdSolicitudAdopcion(idSolicitudAdopcion);
    }
}
