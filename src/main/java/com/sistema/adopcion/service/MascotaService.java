package com.sistema.adopcion.service;

import com.sistema.adopcion.models.Mascota;

import java.util.List;

public interface MascotaService extends GenericService<Mascota, Integer>{

    List<Mascota> porIdFundacion(Integer id_fundacion);

    List<Mascota> porIdUsuario(Integer idUsuario);

    List<Mascota> listarMascotasDisponibles();

    List<Mascota> buscarPorRaza(String razas);

    Mascota buscarPorChipMascota(String chipMascota);

}
