package com.sistema.adopcion.repository;

import com.sistema.adopcion.models.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotasRespository extends JpaRepository<Mascota, Integer> {
}
