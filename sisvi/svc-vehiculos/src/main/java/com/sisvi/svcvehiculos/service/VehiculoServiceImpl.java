package com.sisvi.svcvehiculos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisvi.svcvehiculos.entities.Vehiculo;
import com.sisvi.svcvehiculos.persistence.VehiculoRepository;

@Service
public class VehiculoServiceImpl implements PVehiculoService{

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public List<Vehiculo> obtenerTodosVehiculos() {
        return (List<Vehiculo>) vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo obtenerVehiculoPorId(Long id) {
        return vehiculoRepository.findById(id).orElse(null);
    }

    @Override
    public Vehiculo guardarVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public void eliminarVehiculoPorId(Long id) {
        vehiculoRepository.deleteById(id);
    }
    
}
