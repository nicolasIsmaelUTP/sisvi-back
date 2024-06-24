package com.sisvi.svc_mantenimiento.service;

import java.util.List;

import com.sisvi.svc_mantenimiento.entities.MantenimientoIngreso;
import com.sisvi.svc_mantenimiento.http.request.MantIngresoRequest;

public interface PMantIngresoService {

    List<MantenimientoIngreso> obtenerTodosMantenimientosIngreso();

    MantenimientoIngreso obtenerMantenimientoIngresoPorId(Long id);

    void guardarMantenimientoIngreso(MantIngresoRequest mantIngresoRequest);

    void eliminarMantenimientoIngresoPorId(Long id);

    void cambiarEstadoMantenimientoIngreso(Long id);

    // Filtrar por id de vehiculo
    List<MantenimientoIngreso> obtenerMantenimientosIngresoPorVehiculo(Long idVehiculo);
}
