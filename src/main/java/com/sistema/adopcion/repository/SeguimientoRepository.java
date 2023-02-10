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

    @Query( value = "select * from seguimiento s where s.id_mascota = :idMascota and s.fecha_seguimiento = :fechaSeguimiento", nativeQuery = true)
    Seguimiento verificarRegistro(@Param("idMascota") Integer idMascota, @Param("fechaSeguimiento") Date fechaSeguimiento);
}
