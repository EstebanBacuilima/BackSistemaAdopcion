package com.sistema.adopcion.repository;

import com.sistema.adopcion.models.SolicitudAdopcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudDeAdopcionRepository extends JpaRepository<SolicitudAdopcion, Integer> {
}
