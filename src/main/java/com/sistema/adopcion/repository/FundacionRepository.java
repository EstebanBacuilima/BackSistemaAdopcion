package com.sistema.adopcion.repository;

import com.sistema.adopcion.models.Fundacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundacionRepository extends JpaRepository<Fundacion, Integer> {

    Fundacion findByPersonaIdPersona(Integer idPersona);

    Fundacion findByRuc(String ruc);
}
