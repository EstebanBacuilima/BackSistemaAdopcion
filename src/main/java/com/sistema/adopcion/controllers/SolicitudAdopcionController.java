package com.sistema.adopcion.controllers;

import com.sistema.adopcion.models.*;
import com.sistema.adopcion.service.MascotaService;
import com.sistema.adopcion.service.PreguntaService;
import com.sistema.adopcion.service.RespuestaService;
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

    // NUEVO
    @Autowired
    RespuestaService respuestaService;

    @Autowired
    PreguntaService preguntaService;


    @PostMapping("/responderPreguntas")
    public ResponseEntity<Respuesta> crearRespuesta(@RequestBody Respuesta c) {
        return new ResponseEntity<>(respuestaService.save(c), HttpStatus.CREATED);
    }
    @GetMapping("/listarRespuestas")
    public ResponseEntity<List<Respuesta>> obtenerListaRespuestas() {
        return new ResponseEntity<>(respuestaService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/listarRespuestasSolicitante/{idSolicitudAdopcion}")
    public ResponseEntity<List<Respuesta>> getRespuestasSolicitante(@PathVariable Integer idSolicitudAdopcion) {
        return new ResponseEntity<>(respuestaService.listarRespuestasSolicitante(idSolicitudAdopcion), HttpStatus.OK);
    }



    @GetMapping("/listarPreguntas")
    public ResponseEntity<List<Pregunta>> obtenerListaPreguntas() {
        return new ResponseEntity<>(preguntaService.findByAll(), HttpStatus.OK);
    }

    // NUEVO

    @GetMapping("/listar")
    public ResponseEntity<List<SolicitudAdopcion>> obtenerLista() {
        return new ResponseEntity<>(solicitudAdopcionService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/listarSolicitudesPorFundacion/{id_fundacion}")
    public ResponseEntity<List<SolicitudAdopcion>> getByEmpresa(@PathVariable Integer id_fundacion) {
        return new ResponseEntity<>(solicitudAdopcionService.listarSolicitudesPorFundacion(id_fundacion), HttpStatus.OK);
    }

    @GetMapping("/listarSolicitudesPorUsuario/{idUsario}")
    public ResponseEntity<List<SolicitudAdopcion>> getByUsuario(@PathVariable Integer idUsario) {
        return new ResponseEntity<>(solicitudAdopcionService.listarSolictudesPorUsuario(idUsario), HttpStatus.OK);
    }
    @GetMapping("/listarPorEstados/{estado}/{idFundacion}")
    public ResponseEntity<List<SolicitudAdopcion>> seguimientosPorEstados(@PathVariable String estado, @PathVariable Integer idFundacion) {
        return new ResponseEntity<>(solicitudAdopcionService.listarPorEstado(estado,idFundacion), HttpStatus.OK);
    }


    @PostMapping("/")
    public ResponseEntity<SolicitudAdopcion> crear(@RequestBody SolicitudAdopcion c) {
        return new ResponseEntity<>(solicitudAdopcionService.save(c), HttpStatus.CREATED);
    }

    @GetMapping("/porId/{idSolicitud}")
    @ResponseBody
    public SolicitudAdopcion porId(@PathVariable Integer idSolicitud){
        return solicitudAdopcionService.findById(idSolicitud);
    }

    @PutMapping("actualizarEstadoSolicitud/{idSolicitud}")
    public ResponseEntity<SolicitudAdopcion> actualizarEstadoSolicitud(@PathVariable Integer idSolicitud, @RequestBody SolicitudAdopcion c) {
        if (solicitudAdopcionService.findById(idSolicitud) == null) {
            return ResponseEntity.notFound().build();
        }
        c.setEstado(c.getEstado());
        SolicitudAdopcion newObjeto = solicitudAdopcionService.save(c);
        return ResponseEntity.ok(newObjeto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        solicitudAdopcionService.delete(id);
    }
}
