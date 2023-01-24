package com.sistema.adopcion.controllers;

import com.sistema.adopcion.models.Mascota;
import com.sistema.adopcion.models.SolicitudAdopcion;
import com.sistema.adopcion.service.MascotaService;
import com.sistema.adopcion.service.SolicitudAdopcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/solicitudAdopcion")
public class SolicitudAdopcionController {

    @Autowired
    SolicitudAdopcionService solicitudAdopcionService;

    @GetMapping("/listar")
    public ResponseEntity<List<SolicitudAdopcion>> obtenerLista() {
        return new ResponseEntity<>(solicitudAdopcionService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<SolicitudAdopcion> crear(@RequestBody SolicitudAdopcion c) {
        return new ResponseEntity<>(solicitudAdopcionService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        solicitudAdopcionService.delete(id);
    }
}
