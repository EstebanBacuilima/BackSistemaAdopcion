package com.sistema.adopcion.controllers;

import com.sistema.adopcion.models.Fundacion;
import com.sistema.adopcion.service.FundacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/fundacion")
public class FundacionController {

    @Autowired
    FundacionService fundacionService;

    @GetMapping("/listar")
    public ResponseEntity<List<Fundacion>> obtenerLista() {
        return new ResponseEntity<>(fundacionService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/porId/{idFundacion}")
    @ResponseBody
    public Fundacion porId(@PathVariable Integer idFundacion){
        return fundacionService.findById(idFundacion);
    }

    @PostMapping("/")
    public ResponseEntity<Fundacion> crear(@RequestBody Fundacion c) {
        return new ResponseEntity<>(fundacionService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        fundacionService.delete(id);
    }

    @PutMapping("actualizarEstado/{id}")
    public ResponseEntity<Fundacion> actualizarFundacionEstado(@PathVariable Integer id, @RequestBody Fundacion c) {
        if (fundacionService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        c.setEstado(c.isEstado());
        Fundacion newObjeto = fundacionService.save(c);
        return ResponseEntity.ok(newObjeto);
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<Fundacion> actualizarFundacion(@PathVariable Integer id, @RequestBody Fundacion c) {
        if (fundacionService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        c.setNombre_fundacion(c.getNombre_fundacion());
        c.setDireccion(c.getDireccion());
        c.setTelefono(c.getTelefono());
        c.setCorreo(c.getCorreo());
        c.setAcronimo(c.getAcronimo());
        c.setMision(c.getMision());
        c.setLogo(c.getLogo());
        c.setEstado(c.isEstado());

        Fundacion newObjeto = fundacionService.save(c);
        return ResponseEntity.ok(newObjeto);
    }

    @RequestMapping(value = "/porPersona/{idPersona}", method = RequestMethod.GET)
    @ResponseBody
    public Fundacion porIdPersona(@PathVariable Integer idPersona){
        return fundacionService.porIdPersona(idPersona);
    }

    @RequestMapping(value = "porRuc/{ruc}", method = RequestMethod.GET)
    @ResponseBody
    public boolean porRuc(@PathVariable String ruc){
        return fundacionService.porRuc(ruc);
    }
}
