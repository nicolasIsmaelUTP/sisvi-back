package com.sisvi.svcchoferes.service;

import java.util.List;

import com.sisvi.svcchoferes.entities.Chofer;

public interface PChoferService {
    
    List<Chofer> obtenerTodosChoferes();

    Chofer obtenerChoferPorId(Long id);

    Chofer guardarChofer(Chofer chofer);

    void eliminarChoferPorId(Long id);

    Chofer obtenerPorDni(String dni);

    Chofer obtenerPorLicenciaConducir(String licenciaConducir);
}
