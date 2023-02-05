package com.sistema.adopcion.repository;

import com.sistema.adopcion.models.SolicitudAdopcion;
import com.sistema.adopcion.models.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudDeAdopcionRepository extends JpaRepository<SolicitudAdopcion, Integer> {

    List<SolicitudAdopcion> findByMascotaFundacionIdFundacion(Integer id_fundacion);

    List<SolicitudAdopcion> findByUsuarioIdUsuario(Integer idUsuario);

}
