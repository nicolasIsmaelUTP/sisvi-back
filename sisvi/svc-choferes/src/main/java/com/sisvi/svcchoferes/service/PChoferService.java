package com.sisvi.svcchoferes.service;

import java.util.List;

import com.sisvi.svcchoferes.entities.Chofer;
import com.sisvi.svcchoferes.http.request.ChoferRequest;

public interface PChoferService {
    
    List<Chofer> obtenerTodosChoferes();

    Chofer obtenerChoferPorId(Long id);

    void registrarChofer(ChoferRequest choferRequest);

    void actualizarChofer(Long id, ChoferRequest choferRequest);

    void cambiarEstadoChofer(Long id);

    void eliminarChoferPorId(Long id);

    Chofer obtenerPorDni(String dni);

    Chofer obtenerPorLicenciaConducir(String licenciaConducir);
}
