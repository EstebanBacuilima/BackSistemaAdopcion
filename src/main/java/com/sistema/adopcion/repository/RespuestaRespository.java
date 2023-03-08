package com.sistema.adopcion.repository;

import com.sistema.adopcion.models.Mascota;
import com.sistema.adopcion.models.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RespuestaRespository extends JpaRepository<Respuesta, Integer> {

   List<Respuesta> findBySolicitudAdopcionIdSolicitudAdopcion(Integer idSolicitudAdopcion);

   @Query(value = "select * from respuesta r where r.id_solicitud_adopcion = :idSolicitudAdopcion order by r.id_pregunta", nativeQuery = true)
   List<Respuesta> respuestasPreguntasOrdenadas(@Param("idSolicitudAdopcion") Integer idSolicitudAdopcion);

}
