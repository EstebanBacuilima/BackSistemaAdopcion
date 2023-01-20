package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Usuario;

public interface UsuarioService extends GenericService<Usuario, Integer>{

    Usuario login (String username, String password);

    //Usuario actualizar(Usuario usuario, Integer idUsuario);

}
