package com.sisvi.svcvehiculos.service;

import java.util.List;

import com.sisvi.svcvehiculos.entities.Vehiculo;
import com.sisvi.svcvehiculos.http.request.VehiculoRequest;
import com.sisvi.svcvehiculos.http.response.MantIngresoPorVehiculoResponse;
import com.sisvi.svcvehiculos.http.response.MantSalidaPorVehiculoResponse;

public interface PVehiculoService {

    void registrarVehiculo(VehiculoRequest vehiculoRequest);

    void actualizarVehiculo(Long id, VehiculoRequest vehiculoRequest);

    void cambiarEstadoVehiculo(Long id);

    void eliminarVehiculoPorId(Long id);

    List<Vehiculo> obtenerTodosVehiculos();

    Vehiculo obtenerVehiculoPorId(Long id);

    Vehiculo obtenerPorPlaca(String placa);

    MantSalidaPorVehiculoResponse obtenerMantenimientosSalidaPorVehiculo(Long idVehiculo);

    MantIngresoPorVehiculoResponse obtenerMantenimientosIngresoPorVehiculo(Long idVehiculo);
    
}
