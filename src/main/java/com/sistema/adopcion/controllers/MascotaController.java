package com.sistema.adopcion.controllers;

import com.sistema.adopcion.models.Mascota;
import com.sistema.adopcion.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mascota")
public class MascotaController {
    @Autowired
    MascotaService mascotaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Mascota>> obtenerLista() {
        return new ResponseEntity<>(mascotaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Mascota> crear(@RequestBody Mascota c) {
        return new ResponseEntity<>(mascotaService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        mascotaService.delete(id);
    }


}
