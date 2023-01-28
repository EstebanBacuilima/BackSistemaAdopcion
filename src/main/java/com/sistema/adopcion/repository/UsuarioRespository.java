package com.sistema.adopcion.repository;

import com.sistema.adopcion.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRespository extends JpaRepository<Usuario, Integer> {

    Usuario findByUsernameAndPassword(String username, String password);

    Usuario findByUsername(String username);
    Usuario findByPersonaIdPersona(Integer idPersona);

}
