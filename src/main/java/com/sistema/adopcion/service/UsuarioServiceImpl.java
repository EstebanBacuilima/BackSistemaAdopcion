package com.sistema.adopcion.service;

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
}
