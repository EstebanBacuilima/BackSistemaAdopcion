package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Mascota;
import com.sistema.adopcion.models.Voluntario;

import java.util.List;

public interface VoluntarioService extends GenericService<Voluntario, Integer>{

    List<Voluntario> listarPorEmpresa(Integer id_fundacion);

}
