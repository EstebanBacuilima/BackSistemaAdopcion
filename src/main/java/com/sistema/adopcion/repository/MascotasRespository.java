package com.sistema.adopcion.repository;

import com.sistema.adopcion.models.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MascotasRespository extends JpaRepository<Mascota, Integer> {

    List<Mascota> findByFundacionIdFundacion(Integer id_fundacion);
}
