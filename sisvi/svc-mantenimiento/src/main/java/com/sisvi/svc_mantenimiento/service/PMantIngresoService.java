package com.sisvi.svc_mantenimiento.service;

import java.util.List;

import com.sisvi.svc_mantenimiento.entities.MantenimientoIngreso;

public interface PMantIngresoService {

    List<MantenimientoIngreso> obtenerTodosMantenimientosIngreso();

    MantenimientoIngreso obtenerMantenimientoIngresoPorId(Long id);

    MantenimientoIngreso guardarMantenimientoIngreso(MantenimientoIngreso mantenimientoIngreso);

    void eliminarMantenimientoIngresoPorId(Long id);
}
