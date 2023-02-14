package com.sistema.adopcion.controllers;

import com.sistema.adopcion.models.Fundacion;
import com.sistema.adopcion.models.Usuario;
import com.sistema.adopcion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> obtenerLista() {
        return new ResponseEntity<>(usuarioService.findByAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/porPersona/{idPersona}", method = RequestMethod.GET)
    @ResponseBody
    public Usuario porIdPersona(@PathVariable Integer idPersona){
        return usuarioService.porIdPersona(idPersona);
    }

    @GetMapping("/porId/{idUsuario}")
    @ResponseBody
    public Usuario porId(@PathVariable Integer idUsuario){
        return usuarioService.findById(idUsuario);
    }

    @PostMapping("/")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario c) {
        return new ResponseEntity<>(usuarioService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable Integer id) {
        return usuarioService.eliminar(id);
    }

    @RequestMapping(value = "login/{username}/{password}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Usuario login(@PathVariable String username, @PathVariable String password){
        return usuarioService.login(username, password);
    }

//    @RequestMapping(value = "login/{username}/{password}", method = RequestMethod.GET)
//    @ResponseBody
//    @CrossOrigin
//    public Usuario login(@PathVariable String username, @PathVariable String password){
//        Usuario usuario = usuarioService.login(username, password);
//        if (usuario != null && usuario.getFundacion().isEstado() == true) {
//            return usuario;
//        }
//        return null;
//    }

    @GetMapping("porUsername/{username}")
    @ResponseBody
    public boolean porUsername(@PathVariable String username){
        return usuarioService.porUsername(username);
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Integer id, @RequestBody Usuario c) {
        if (usuarioService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        c.setUsername(c.getUsername());
        c.setPassword(c.getPassword());
        c.setRol(c.getRol());
        c.setFoto_perfil(c.getFoto_perfil());
        c.setEstado(c.isEstado());

        Usuario newObjeto = usuarioService.save(c);
        return ResponseEntity.ok(newObjeto);
    }
}

