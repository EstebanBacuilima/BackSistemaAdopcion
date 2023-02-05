package com.sistema.adopcion.repository;

import com.sistema.adopcion.models.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntasRepository extends JpaRepository<Pregunta, Integer> {
}
