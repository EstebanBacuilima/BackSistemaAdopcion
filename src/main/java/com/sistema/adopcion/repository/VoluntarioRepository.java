package com.sistema.adopcion.repository;

import com.sistema.adopcion.models.Mascota;
import com.sistema.adopcion.models.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Integer> {

    List<Voluntario> findByUsuarioFundacionIdFundacion(Integer id_fundacion);

}
