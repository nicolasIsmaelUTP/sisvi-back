package com.sisvi.svcrepuestos.service;

import java.util.List;
import com.sisvi.svcrepuestos.entities.Repuesto;
import com.sisvi.svcrepuestos.http.request.RepuestoRequest;

public interface PRepuestoService {

    List<Repuesto> obtenerTodosRepuestos();

    List<Repuesto> obtenerRepuestosActivos();

    List<Repuesto> obtenerRepuestosInactivos();
    
    Repuesto obtenerRepuestoPorId(Long id);

    Repuesto obtenerPorCodigoInterno(String codigoInterno);
    
    void crearRepuesto(RepuestoRequest repuestoRequest);

    void actualizarRepuesto(Long id, RepuestoRequest repuestoRequest);

    void cambiarEstadoRepuesto(Long id);

} 