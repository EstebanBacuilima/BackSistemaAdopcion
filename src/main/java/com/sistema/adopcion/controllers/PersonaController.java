package com.sistema.adopcion.controllers;

import com.sistema.adopcion.models.Persona;
import com.sistema.adopcion.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> obtenerLista() {
        return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Persona> crear(@RequestBody Persona c) {
        return new ResponseEntity<>(personaService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        personaService.delete(id);
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Integer id, @RequestBody Persona c) {
        if (personaService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        c.setNombres(c.getNombres());
        c.setApellidos(c.getApellidos());
        c.setFechaNacimiento(c.getFechaNacimiento());
        c.setGenero(c.getGenero());
        c.setDireccion(c.getDireccion());
        c.setCorreo(c.getCorreo());
        c.setTelefono(c.getTelefono());
        c.setCelular(c.getCelular());

        Persona newObjeto = personaService.save(c);
        return ResponseEntity.ok(newObjeto);
    }
}
