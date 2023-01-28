package com.sistema.adopcion.repository;

import com.sistema.adopcion.models.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MascotasRespository extends JpaRepository<Mascota, Integer> {

    @Query( value = "select * from mascota m where m.raza = :razas and m.estado_adopcion = true", nativeQuery = true)
    List<Mascota> buscarPorRaza(@Param("razas") String razas);

    @Query(value = "select * from mascota m where m.estado_adopcion = true", nativeQuery = true)
    List<Mascota> listarMascotasDisponibles();

    List<Mascota> findByFundacionIdFundacion(Integer id_fundacion);

    List<Mascota> findByUsuarioIdUsuario(Integer idUsuario);

}
