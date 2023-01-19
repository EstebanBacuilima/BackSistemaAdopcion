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

}
