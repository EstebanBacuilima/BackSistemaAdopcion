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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/porId/{idMascota}")
    @ResponseBody
    public Mascota porId(@PathVariable Integer idMascota){
        return mascotaService.findById(idMascota);
    }


    @GetMapping("/listarDisponibles")
    public ResponseEntity<List<Mascota>> obtenerListaMascotasDisponibles() {
        return new ResponseEntity<>(mascotaService.listarMascotasDisponibles(), HttpStatus.OK);
    }

//    @GetMapping("/listarDisponibles")
//    public List<Mascota> listarMascotasDisponibles() {
//        List<Mascota> mascotasDisponibles = new ArrayList<>();
//        List<Mascota> todasLasMascotas = mascotaService.listarMascotasDisponibles();
//        for (Mascota mascota : todasLasMascotas) {
//            if (mascota.getFundacion().isEstado() == true) {
//                mascotasDisponibles.add(mascota);
//            }
//        }
//        return mascotasDisponibles;
//    }
//
//    @GetMapping("/listarMascotasEnSeguimiento")
//    public ResponseEntity<List<Mascota>> obtenerListaMascotasEnSeguimiento() {
//        List<Mascota> listAlmacenar = mascotaService.findByAll();
//        List<Mascota> listActivos = new ArrayList<>();
//        for (int i = 0 ; i < listAlmacenar.size() ; i++){
//            if (listAlmacenar.get(i).isEstado_seguimiento() == true){
//                listActivos.add(listAlmacenar.get(i));
//            }
//        }
//        return new ResponseEntity<>(listActivos, HttpStatus.OK);
//    }

    @GetMapping("/listarMascotasEnSeguimiento/{idFundacion}")
    public ResponseEntity<List<Mascota>> obtenerListaMascotasEnSeguimiento(@PathVariable Integer idFundacion) {
        List<Mascota> mascotasFundacion = mascotaService.porIdFundacion(idFundacion);
        List<Mascota> mascotasEnSeguimiento = mascotasFundacion.stream().filter(mascota -> mascota.isEstado_seguimiento()).collect(Collectors.toList());
        return new ResponseEntity<>(mascotasEnSeguimiento, HttpStatus.OK);
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

    @PutMapping("desactivar/{id}")
    public ResponseEntity<Mascota> desactivarMascota(@PathVariable Integer id, @RequestBody Mascota c) {
        if (mascotaService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        c.setEstado(c.isEstado());
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
        c.setEstado_seguimiento(c.isEstado_seguimiento());
        c.setEstado_adopcion(c.isEstado_adopcion());

        Mascota newObjeto = mascotaService.save(c);
        return ResponseEntity.ok(newObjeto);
    }

    @PutMapping("actualizarEstadoMascota/{id}")
    public ResponseEntity<Mascota> actualizarEstadoMascota(@PathVariable Integer id, @RequestBody Mascota c) {
        if (mascotaService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
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
