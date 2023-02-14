package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Fundacion;
import com.sistema.adopcion.repository.FundacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class FundacionServiceImpl extends GenericServiceImpl<Fundacion, Integer> implements FundacionService {

    @Autowired
    FundacionRepository fundacionRepository;

    @Override
    public CrudRepository<Fundacion, Integer> getDao() {
        return fundacionRepository;
    }

    @Override
    public Fundacion porIdPersona(Integer idPersona) {
        return fundacionRepository.findByPersonaIdPersona(idPersona);
    }

    @Override
    public boolean porRuc(String ruc) {
        if (fundacionRepository.findByRuc(ruc)!=null) {
            return true;
        }else {
            return false;
        }

    }

}