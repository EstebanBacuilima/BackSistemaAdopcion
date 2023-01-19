package com.sistema.adopcion.controllers;

import com.sistema.adopcion.models.Seguimiento;
import com.sistema.adopcion.service.SeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/seguimiento")
public class SeguimientoController {

    @Autowired
    SeguimientoService seguimientoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Seguimiento>> obtenerLista() {
        return new ResponseEntity<>(seguimientoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Seguimiento> crear(@RequestBody Seguimiento c) {
        return new ResponseEntity<>(seguimientoService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        seguimientoService.delete(id);
    }
}
