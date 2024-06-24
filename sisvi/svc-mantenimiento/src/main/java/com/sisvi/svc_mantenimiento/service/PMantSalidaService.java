package com.sisvi.svc_mantenimiento.service;

import java.util.List;

import com.sisvi.svc_mantenimiento.entities.MantenimientoSalida;
import com.sisvi.svc_mantenimiento.http.request.MantSalidaRequest;

public interface PMantSalidaService {
    
    List<MantenimientoSalida> obtenerTodosMantenimientosSalida();

    MantenimientoSalida obtenerMantenimientoSalidaPorId(Long id);

    void guardarMantenimientoSalida(MantSalidaRequest request);

    void cambiarEstadoMantenimientoSalida(Long id);

    void eliminarMantenimientoSalidaPorId(Long id);

    // Filtrar por id de vehiculo
    List<MantenimientoSalida> obtenerMantenimientosSalidaPorVehiculo(Long idVehiculo);
}
