package com.sistema.adopcion.repository;

import com.sistema.adopcion.models.Mascota;
import com.sistema.adopcion.models.Seguimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SeguimientoRepository extends JpaRepository<Seguimiento, Integer> {

    List<Seguimiento> findByMascotaIdMascota(Integer idMascota);

    @Query( value = "select * from seguimiento s where s.id_mascota = :idMascota and s.fecha_seguimiento = :fechaSeguimiento and estado = true", nativeQuery = true)
    Seguimiento verificarRegistro(@Param("idMascota") Integer idMascota, @Param("fechaSeguimiento") Date fechaSeguimiento);

    @Query(value = "SELECT * FROM seguimiento where estado_informe = 'R' and id_mascota = :idMascota and estado = true", nativeQuery = true)
    List<Seguimiento> verificarInformesValidos(@Param("idMascota") Integer idMascota);

    List<Seguimiento> findByEstado(boolean estado);

    List<Seguimiento> findByMascota_IdMascotaAndEstado(Integer idMascota, boolean estado);



}
