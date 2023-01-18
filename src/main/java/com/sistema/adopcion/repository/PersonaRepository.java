package com.sistema.adopcion.repository;

import com.sistema.adopcion.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
