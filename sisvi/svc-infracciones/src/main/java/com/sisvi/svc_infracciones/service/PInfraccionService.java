package com.sisvi.svc_infracciones.service;

import java.util.List;

import com.sisvi.svc_infracciones.entities.Infraccion;
import com.sisvi.svc_infracciones.http.request.InfraccionRequest;

public interface PInfraccionService {
    List<Infraccion> obtenerInfracciones();
    List<Infraccion> obtenerInfraccionesPorChofer(Long choferId);
    List<Infraccion> obtenerInfraccionesPorVehiculo(Long vehiculoId);
    List<Infraccion> obtenerInfraccionesPorEstado(Boolean estado);
    Infraccion obtenerInfraccionPorId(Long id);
    void registrarInfraccion(InfraccionRequest infraccionRequest);
    void actualizarInfraccion(Long id, InfraccionRequest infraccionRequest);
    void cambiarEstadoInfraccion(Long id);
}
