package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Mascota;
import com.sistema.adopcion.models.Persona;
import com.sistema.adopcion.repository.MascotasRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl extends GenericServiceImpl<Mascota, Integer> implements MascotaService {

    @Autowired
    MascotasRespository mascotasRespository;

    @Override
    public List<Mascota> porIdFundacion(Integer id_fundacion) {
        return mascotasRespository.findByFundacionIdFundacion(id_fundacion);
    }

    @Override
    public List<Mascota> porIdUsuario(Integer idUsuario) {
        return mascotasRespository.findByUsuarioIdUsuario(idUsuario);
    }

    @Override
    public List<Mascota> buscarPorRaza(String razas) {
        return mascotasRespository.buscarPorRaza(razas);
    }

    public List<Mascota> listarMascotasDisponibles() {
        return mascotasRespository.listarMascotasDisponibles();
    }

    @Override
    public Mascota buscarPorChipMascota(String chipMascota) {
        return mascotasRespository.findByChipMascota(chipMascota);
    }

    @Override
    public CrudRepository<Mascota, Integer> getDao() {
        return mascotasRespository;
    }



}