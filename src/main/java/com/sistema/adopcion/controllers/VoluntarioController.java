package com.sistema.adopcion.controllers;

import com.sistema.adopcion.models.Mascota;
import com.sistema.adopcion.models.Voluntario;
import com.sistema.adopcion.service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/voluntario")
public class VoluntarioController {

    @Autowired
    VoluntarioService voluntarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Voluntario>> obtenerLista() {
        return new ResponseEntity<>(voluntarioService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Voluntario> crear(@RequestBody Voluntario c) {
        return new ResponseEntity<>(voluntarioService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        voluntarioService.delete(id);
    }

    @GetMapping("/listarVoluntariosPorFundacion/{id_fundacion}")
    public ResponseEntity<List<Voluntario>> getByEmpresa(@PathVariable Integer id_fundacion) {
        List<Voluntario> listaEncontrada= voluntarioService.listarPorEmpresa(id_fundacion);
        return new ResponseEntity<>(listaEncontrada, HttpStatus.OK);
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<Voluntario> actualizarVoluntario(@PathVariable Integer id, @RequestBody Voluntario c) {
        if (voluntarioService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        c.setArea_trabajo(c.getArea_trabajo());
        c.setCargo(c.getCargo());
        c.setEstado(c.isEstado());

        Voluntario newObjeto = voluntarioService.save(c);
        return ResponseEntity.ok(newObjeto);
    }
}
