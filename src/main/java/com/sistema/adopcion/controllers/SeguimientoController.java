package com.sistema.adopcion.controllers;

import com.sistema.adopcion.models.Seguimiento;
import com.sistema.adopcion.service.SeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/seguimiento")
public class SeguimientoController {

    @Autowired
    SeguimientoService seguimientoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Seguimiento>> obtenerLista() {
        return new ResponseEntity<>(seguimientoService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/porId/{idSeguimiento}")
    @ResponseBody
    public Seguimiento porId(@PathVariable Integer idSeguimiento){
        return seguimientoService.findById(idSeguimiento);
    }


    @PostMapping("/")
    public ResponseEntity<Seguimiento> crear(@RequestBody Seguimiento c) {
        return new ResponseEntity<>(seguimientoService.save(c), HttpStatus.CREATED);
    }

    @GetMapping("/listarSeguimientosPorMascota/{idMascota}")
    public ResponseEntity<List<Seguimiento>> seguimientosPorMascoa(@PathVariable Integer idMascota) {
        return new ResponseEntity<>(seguimientoService.listarSeguimientosPorMascota(idMascota), HttpStatus.OK);
    }

    @GetMapping("/listarSeguimientosInformesPorMascota/{idMascota}")
    public ResponseEntity<List<Seguimiento>> seguimientosInformesPorMascoa(@PathVariable Integer idMascota) {
        return new ResponseEntity<>(seguimientoService.listarInformesSeguimientosPorMascota(idMascota), HttpStatus.OK);
    }


    @GetMapping("/validarRegistros/{idMascota}/{fechaSeguimiento}")
    public boolean validarRegistros(@PathVariable Integer idMascota, @PathVariable String fechaSeguimiento) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = formatter.parse(fechaSeguimiento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return seguimientoService.verificarRegistro(idMascota, fecha);
    }


    @PutMapping("actualizarEstadoSeguimiento/{id}")
    public ResponseEntity<Seguimiento> actualizarSeguimiento(@PathVariable Integer id, @RequestBody Seguimiento c) {
        if (seguimientoService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        c.setEstado(c.isEstado());
        Seguimiento newObjeto = seguimientoService.save(c);
        return ResponseEntity.ok(newObjeto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        seguimientoService.delete(id);
    }
}
