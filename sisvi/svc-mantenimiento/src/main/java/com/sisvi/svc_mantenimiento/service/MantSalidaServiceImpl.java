package com.sisvi.svc_mantenimiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisvi.svc_mantenimiento.entities.MantenimientoSalida;
import com.sisvi.svc_mantenimiento.persistence.MantSalidaRepository;

@Service
public class MantSalidaServiceImpl implements PMantSalidaService{

    @Autowired
    private MantSalidaRepository mantenimientoSalidaRepository;

    @Override
    public List<MantenimientoSalida> obtenerTodosMantenimientosSalida() {
        return (List<MantenimientoSalida>) mantenimientoSalidaRepository.findAll();
    }

    @Override
    public MantenimientoSalida obtenerMantenimientoSalidaPorId(Long id) {
        return mantenimientoSalidaRepository.findById(id).orElse(null);
    }

    @Override
    public MantenimientoSalida guardarMantenimientoSalida(MantenimientoSalida mantenimientoSalida) {
        return mantenimientoSalidaRepository.save(mantenimientoSalida);
    }

    @Override
    public void eliminarMantenimientoSalidaPorId(Long id) {
        mantenimientoSalidaRepository.deleteById(id);
    }
    
}
