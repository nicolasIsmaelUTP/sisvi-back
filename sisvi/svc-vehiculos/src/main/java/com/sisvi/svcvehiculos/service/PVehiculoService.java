package com.sisvi.svcvehiculos.service;

import java.util.List;

import com.sisvi.svcvehiculos.entities.Vehiculo;
import com.sisvi.svcvehiculos.http.request.VehiculoRequest;
import com.sisvi.svcvehiculos.http.response.MantIngresoPorVehiculoResponse;
import com.sisvi.svcvehiculos.http.response.MantSalidaPorVehiculoResponse;

public interface PVehiculoService {

    List<Vehiculo> obtenerTodosVehiculos();
    
    List<Vehiculo> obtenerVehiculosActivos();

    List<Vehiculo> obtenerVehiculosInactivos();

    void registrarVehiculo(VehiculoRequest vehiculoRequest);

    void actualizarVehiculo(Long id, VehiculoRequest vehiculoRequest);

    void cambiarEstadoVehiculo(Long id);

    Vehiculo obtenerVehiculoPorId(Long id);

    Vehiculo obtenerPorPlaca(String placa);

    MantSalidaPorVehiculoResponse obtenerMantenimientosSalidaPorVehiculo(Long idVehiculo);

    MantIngresoPorVehiculoResponse obtenerMantenimientosIngresoPorVehiculo(Long idVehiculo);
    
}
