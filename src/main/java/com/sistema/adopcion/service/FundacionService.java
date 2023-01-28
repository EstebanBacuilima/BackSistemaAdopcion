package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Fundacion;

public interface FundacionService extends GenericService<Fundacion, Integer>{

    Fundacion porIdPersona(Integer idPersona);

    boolean porRuc(String ruc);
}
