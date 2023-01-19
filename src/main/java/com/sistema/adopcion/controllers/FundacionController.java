package com.sistema.adopcion.controllers;

import com.sistema.adopcion.models.Fundacion;
import com.sistema.adopcion.service.FundacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/fundacion")
public class FundacionController {

    @Autowired
    FundacionService fundacionService;

    @GetMapping("/listar")
    public ResponseEntity<List<Fundacion>> obtenerLista() {
        return new ResponseEntity<>(fundacionService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Fundacion> crear(@RequestBody Fundacion c) {
        return new ResponseEntity<>(fundacionService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        fundacionService.delete(id);
    }

}
