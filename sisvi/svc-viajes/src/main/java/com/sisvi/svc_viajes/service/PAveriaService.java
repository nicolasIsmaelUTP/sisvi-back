package com.sisvi.svc_viajes.service;

import java.util.List;

import com.sisvi.svc_viajes.entities.Averia;
import com.sisvi.svc_viajes.http.request.AveriaRequest;

public interface PAveriaService {
    List<Averia> obtenerAverias();
    List<Averia> obtenerAveriasPorVehiculo(Long vehiculoId);
    List<Averia> obtenerAveriasPorEstado(Boolean estado);
    Averia obtenerAveriaPorId(Long id);
    void guardarAveria(AveriaRequest averiaRequest);
    void cambiarEstadoAveria(Long id);
}
