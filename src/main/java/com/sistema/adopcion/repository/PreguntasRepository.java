package com.sistema.adopcion.repository;

import com.sistema.adopcion.models.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PreguntasRepository extends JpaRepository<Pregunta, Integer> {

    @Query(value = "select * from pregunta order by id_pregunta", nativeQuery = true)
    List<Pregunta> listarPreguntas();

}
