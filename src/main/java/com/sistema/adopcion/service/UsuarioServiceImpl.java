package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Fundacion;
import com.sistema.adopcion.models.Usuario;
import com.sistema.adopcion.repository.UsuarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Integer> implements UsuarioService {

    @Autowired
    UsuarioRespository usuarioRespository;

    @Override
    public CrudRepository<Usuario, Integer> getDao() {
        return usuarioRespository;
    }

    @Override
    public Usuario login(String username, String password) {
        return usuarioRespository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Usuario porIdPersona(Integer idPersona) {
        return usuarioRespository.findByPersonaIdPersona(idPersona);
    }

    @Override
    public boolean porUsername(String username) {
        if (usuarioRespository.findByUsername(username)!=null) {
            return true;
        }else {
            return false;
        }
    }


}
