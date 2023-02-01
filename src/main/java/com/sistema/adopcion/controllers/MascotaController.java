package com.sistema.adopcion.controllers;

import com.sistema.adopcion.models.Mascota;
import com.sistema.adopcion.models.Persona;
import com.sistema.adopcion.models.Usuario;
import com.sistema.adopcion.service.MascotaService;
import com.sistema.adopcion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/mascota")
public class MascotaController {
    @Autowired
    MascotaService mascotaService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Mascota>> obtenerLista() {
        return new ResponseEntity<>(mascotaService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/listarDisponibles")
    public ResponseEntity<List<Mascota>> obtenerListaMascotasDisponibles() {
        return new ResponseEntity<>(mascotaService.listarMascotasDisponibles(), HttpStatus.OK);
    }

    @GetMapping("/listarMacotasPorFundacion/{id_fundacion}")
    public ResponseEntity<List<Mascota>> getByEmpresa(@PathVariable Integer id_fundacion) {
        List<Mascota> listaProductos = mascotaService.porIdFundacion(id_fundacion);
        return new ResponseEntity<>(listaProductos, HttpStatus.OK);
    }

    @GetMapping("/listarMacotasPorUsuarios/{idUsuario}")
    public ResponseEntity<List<Mascota>> getByUsuarios(@PathVariable Integer idUsuario) {
        List<Mascota> listaMascotas = mascotaService.porIdUsuario(idUsuario);
        return new ResponseEntity<>(listaMascotas, HttpStatus.OK);
    }

    @GetMapping("/listarPorRaza/{razas}")
    public ResponseEntity<List<Mascota>> obtenerListaMascotasRaza(@PathVariable String razas) {
        return new ResponseEntity<>(mascotaService.buscarPorRaza(razas), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Mascota> crear(@RequestBody Mascota c) {
        return new ResponseEntity<>(mascotaService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        mascotaService.delete(id);
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<Mascota> actualizarMascota(@PathVariable Integer id, @RequestBody Mascota c) {
        if (mascotaService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        c.setNombre_mascota(c.getNombre_mascota());
        c.setColor(c.getColor());
        c.setSexo(c.getSexo());
        c.setEspecie(c.getEspecie());
        c.setRaza(c.getRaza());
        c.setEspecie(c.getEspecie());
        c.setDescripcion(c.getDescripcion());
        c.setFoto(c.getFoto());
        c.setEstado_mascota(c.isEstado_mascota());
        c.setEstado_adopcion(c.isEstado_adopcion());

        Mascota newObjeto = mascotaService.save(c);
        return ResponseEntity.ok(newObjeto);
    }

    @PutMapping("actualizarDueño/{id}")
    public ResponseEntity<Mascota> actualizarDueñoDeMascota(@PathVariable Integer id, @RequestBody Mascota c) {
        if (mascotaService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        Usuario usuario = usuarioService.findById(c.getUsuario().getIdUsuario());

        c.setUsuario(usuario);
        c.setEstado_adopcion(c.isEstado_adopcion());

        Mascota newObjeto = mascotaService.save(c);
        return ResponseEntity.ok(newObjeto);
    }

    @RequestMapping(value = "byChipMascota/{chipMascota}", method = RequestMethod.GET)
    @ResponseBody
    public Mascota porChipMascota(@PathVariable String chipMascota){
        return mascotaService.buscarPorChipMascota(chipMascota);
    }

}
