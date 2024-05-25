package com.sisvi.svc_parametros.service;

import java.util.List;

import com.sisvi.svc_parametros.entities.Parametros;

public interface PParametrosService {
    
    List<Parametros> obtenerTodosParametros();

    Parametros obtenerParametrosPorId(Long id);

    Parametros guardarParametros(Parametros parametros);

    void eliminarParametrosPorId(Long id);
    
}
