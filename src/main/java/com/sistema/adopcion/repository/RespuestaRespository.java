package com.sistema.adopcion.repository;

import com.sistema.adopcion.models.Mascota;
import com.sistema.adopcion.models.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespuestaRespository extends JpaRepository<Respuesta, Integer> {

   List<Respuesta> findBySolicitudAdopcionIdSolicitudAdopcion(Integer idSolicitudAdopcion);
}
