package com.sisvi.svcvehiculos.service;

import java.util.List;

import com.sisvi.svcvehiculos.entities.Vehiculo;

public interface PVehiculoService {

    List<Vehiculo> obtenerTodosVehiculos();

    Vehiculo obtenerVehiculoPorId(Long id);

    Vehiculo guardarVehiculo(Vehiculo vehiculo);

    void eliminarVehiculoPorId(Long id);

}
