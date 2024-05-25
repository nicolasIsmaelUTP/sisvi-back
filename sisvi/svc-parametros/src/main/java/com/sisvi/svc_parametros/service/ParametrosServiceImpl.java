package com.sisvi.svc_parametros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisvi.svc_parametros.entities.Parametros;
import com.sisvi.svc_parametros.persistence.ParametrosRepository;

@Service
public class ParametrosServiceImpl implements PParametrosService{

    @Autowired
    private ParametrosRepository parametrosRepository;

    @Override
    public List<Parametros> obtenerTodosParametros() {
        return (List<Parametros>) parametrosRepository.findAll();
    }

    @Override
    public Parametros obtenerParametrosPorId(Long id) {
        return parametrosRepository.findById(id).orElse(null);
    }

    @Override
    public Parametros guardarParametros(Parametros parametros) {
        return parametrosRepository.save(parametros);
    }

    @Override
    public void eliminarParametrosPorId(Long id) {
        parametrosRepository.deleteById(id);
    }
    
}
