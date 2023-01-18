package com.sistema.adopcion.repository;

import com.sistema.adopcion.models.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Integer> {
}
