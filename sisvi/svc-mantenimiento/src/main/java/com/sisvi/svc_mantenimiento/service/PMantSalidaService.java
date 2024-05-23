package com.sisvi.svc_mantenimiento.service;

import java.util.List;

import com.sisvi.svc_mantenimiento.entities.MantenimientoSalida;

public interface PMantSalidaService {
    List<MantenimientoSalida> obtenerTodosMantenimientosSalida();

    MantenimientoSalida obtenerMantenimientoSalidaPorId(Long id);

    MantenimientoSalida guardarMantenimientoSalida(MantenimientoSalida mantenimientoSalida);

    void eliminarMantenimientoSalidaPorId(Long id);
}
