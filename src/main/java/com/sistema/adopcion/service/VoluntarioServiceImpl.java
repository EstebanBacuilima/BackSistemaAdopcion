package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Fundacion;
import com.sistema.adopcion.models.Mascota;
import com.sistema.adopcion.models.Voluntario;
import com.sistema.adopcion.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioServiceImpl extends GenericServiceImpl<Voluntario, Integer> implements VoluntarioService {

    @Autowired
    VoluntarioRepository voluntarioRepository;

    @Override
    public CrudRepository<Voluntario, Integer> getDao() {
        return voluntarioRepository;
    }

    @Override
    public List<Voluntario> listarPorEmpresa(Integer id_fundacion) {
        return voluntarioRepository.findByUsuarioFundacionIdFundacion(id_fundacion);
    }
}