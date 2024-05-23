package com.sisvi.svcvehiculos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisvi.svcvehiculos.client.RMantSalidaService;
import com.sisvi.svcvehiculos.dto.MantSalidaDTO;
import com.sisvi.svcvehiculos.entities.Vehiculo;
import com.sisvi.svcvehiculos.http.response.MantSalidaPorVehiculoResponse;
import com.sisvi.svcvehiculos.persistence.VehiculoRepository;

@Service
public class VehiculoServiceImpl implements PVehiculoService{

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private RMantSalidaService rMantSalidaService;

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

    @Override
    public Vehiculo obtenerPorPlaca(String placa) {
        List<Vehiculo> vehiculos = (List<Vehiculo>) vehiculoRepository.findAll();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;
            }
        }
        return null;
    }

    @Override
    public MantSalidaPorVehiculoResponse obtenerMantenimientosSalidaPorVehiculo(Long idVehiculo) {
        // Consultar vehiculo por id
        Vehiculo vehiculo = vehiculoRepository.findById(idVehiculo).orElse(null);

        // Obtener mantenimientos de salida
        List<MantSalidaDTO> mantenimientosSalida = rMantSalidaService.obtenerMantenimientosSalidaPorVehiculo(idVehiculo);

        return MantSalidaPorVehiculoResponse.builder()
                .id(vehiculo.getId())
                .placa(vehiculo.getPlaca())
                .mantenimientosSalida(mantenimientosSalida)
                .build();
    }
    
}
