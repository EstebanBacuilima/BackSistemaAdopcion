package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Fundacion;
import com.sistema.adopcion.models.Usuario;

public interface UsuarioService extends GenericService<Usuario, Integer>{

    Usuario login (String username, String password);
    boolean porUsername(String username);

    Usuario porIdPersona(Integer idPersona);


}
