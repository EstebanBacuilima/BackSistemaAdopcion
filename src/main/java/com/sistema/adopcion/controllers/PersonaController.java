package com.sistema.adopcion.controllers;

import com.sistema.adopcion.models.Persona;
import com.sistema.adopcion.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> obtenerLista() {
        return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{idPersona}", method = RequestMethod.GET)
    @ResponseBody
    public Persona porId(@PathVariable Integer idPersona){
        return personaService.findById(idPersona);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Persona crearpersona(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable Integer id) {
        return personaService.eliminar(id);
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

    @RequestMapping(value = "byCedula/{cedula}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Persona porCedula(@PathVariable String cedula){
        return personaService.porCedula(cedula);
    }
}
