package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Seguimiento;
import com.sistema.adopcion.models.SolicitudAdopcion;
import com.sistema.adopcion.models.Voluntario;
import com.sistema.adopcion.repository.SolicitudDeAdopcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudAdopcionServiceImpl extends GenericServiceImpl<SolicitudAdopcion, Integer> implements SolicitudAdopcionService {

    @Autowired
    SolicitudDeAdopcionRepository solicitudDeAdopcionRepository;

    @Override
    public CrudRepository<SolicitudAdopcion, Integer> getDao() {
        return solicitudDeAdopcionRepository;
    }

    @Override
    public List<SolicitudAdopcion> listarSolicitudesPorFundacion(Integer id_fundacion) {
        return solicitudDeAdopcionRepository.findByMascotaFundacionIdFundacion(id_fundacion);
    }

    @Override
    public List<SolicitudAdopcion> listarPorEstado(String estado,Integer idFundacion) {
        return solicitudDeAdopcionRepository.findByEstados(estado,idFundacion);
    }


    @Override
    public List<SolicitudAdopcion> listarSolictudesPorUsuario(Integer idUsuario) {
        return solicitudDeAdopcionRepository.findByUsuarioIdUsuario(idUsuario);
    }
}
