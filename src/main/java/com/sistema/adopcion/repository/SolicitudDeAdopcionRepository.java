package com.sistema.adopcion.repository;

import com.sistema.adopcion.models.Seguimiento;
import com.sistema.adopcion.models.SolicitudAdopcion;
import com.sistema.adopcion.models.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SolicitudDeAdopcionRepository extends JpaRepository<SolicitudAdopcion, Integer> {

    List<SolicitudAdopcion> findByMascotaFundacionIdFundacion(Integer id_fundacion);

    List<SolicitudAdopcion> findByUsuarioIdUsuario(Integer idUsuario);


    @Query(value = "SELECT s.id_solicitud_adopcion,s.estado,s.fecha_solicitud_adopcion,s.id_mascota,s.id_usuario,s.estado_dos FROM solicitud_adopcion s, mascota m where s.estado = :estado and s.id_mascota = m.id_mascota and m.id_fundacion = :idFundacion", nativeQuery = true)
    List<SolicitudAdopcion> findByEstados(@Param("estado")String estado,@Param("idFundacion") Integer idFundacion);

    @Query(value = "select * from solicitud_adopcion sa  where id_mascota = :idMascota and id_usuario = :idUsuario", nativeQuery = true)
    List<SolicitudAdopcion> findBySoliPorMascotaUsuario(@Param("idMascota")Integer idMascota,@Param("idUsuario") Integer idUsuario);

    @Query(value = "select s.id_solicitud_adopcion,s.estado,s.fecha_solicitud_adopcion,s.id_mascota,s.id_usuario,s.estado_dos from solicitud_adopcion s, mascota m  where s.id_mascota = m.id_mascota and m.id_fundacion = :idFundacion and s.estado_dos = 'N'", nativeQuery = true)
    List<SolicitudAdopcion> findSolicitudesPorFundacion(@Param("idFundacion")Integer idFundacion);

    @Query(value = "select * from solicitud_adopcion s where s.id_usuario = :idUsuario and (s.estado_dos = 'N' or s.estado_dos = 'A' or s.estado_dos = 'E' or s.estado_dos = 'R')", nativeQuery = true)
    List<SolicitudAdopcion> findSolicitudesPorUsuario(@Param("idUsuario")Integer idUsuario);

}
