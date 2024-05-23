package com.sisvi.svcrepuestos.service;

import java.util.List;
import com.sisvi.svcrepuestos.entities.Repuesto;

public interface PRepuestoService {

    List<Repuesto> obtenerTodosRepuestos();

    Repuesto obtenerRepuestoPorId(Long id);

    Repuesto guardarRepuesto(Repuesto repuesto);

    void eliminarRepuestoPorId(Long id);
} 