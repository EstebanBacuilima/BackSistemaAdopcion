package com.sistema.adopcion.controllers;

import com.sistema.adopcion.models.Voluntario;
import com.sistema.adopcion.service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/voluntario")
public class VoluntarioController {

    @Autowired
    VoluntarioService voluntarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Voluntario>> obtenerLista() {
        return new ResponseEntity<>(voluntarioService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Voluntario> crear(@RequestBody Voluntario c) {
        return new ResponseEntity<>(voluntarioService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        voluntarioService.delete(id);
    }
}
