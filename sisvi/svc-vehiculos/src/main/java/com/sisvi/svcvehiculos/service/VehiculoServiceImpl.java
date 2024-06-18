package com.sisvi.svcvehiculos.service;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.sisvi.svcvehiculos.client.RMantService;
import com.sisvi.svcvehiculos.dto.MantIngresoDTO;
import com.sisvi.svcvehiculos.entities.Vehiculo;
import com.sisvi.svcvehiculos.http.request.VehiculoRequest;
import com.sisvi.svcvehiculos.http.response.MantIngresoPorVehiculoResponse;
import com.sisvi.svcvehiculos.http.response.MantSalidaPorVehiculoResponse;
import com.sisvi.svcvehiculos.persistence.VehiculoRepository;

@Service
public class VehiculoServiceImpl implements PVehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private RMantService rMantService;

    @Override
    public List<Vehiculo> obtenerTodosVehiculos() {
        return (List<Vehiculo>) vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo obtenerVehiculoPorId(Long id) {
        return vehiculoRepository.findById(id).orElse(null);
    }

    @Override
    public void registrarVehiculo(VehiculoRequest vehiculoRequest) {
        vehiculoRepository.save(Vehiculo.builder()
                .placa(vehiculoRequest.getPlaca())
                .numMotor(vehiculoRequest.getNumMotor())
                .numSerie(vehiculoRequest.getNumSerie())
                .marca(vehiculoRequest.getMarca())
                .modelo(vehiculoRequest.getModelo())
                .anioFabricacion(vehiculoRequest.getAnioFabricacion())
                .color(vehiculoRequest.getColor())
                .kilometraje(vehiculoRequest.getKilometraje())
                .tipoCombustible(vehiculoRequest.getTipoCombustible())
                .transmision(vehiculoRequest.getTransmision())
                .img(vehiculoRequest.getImg())
                .estado(true)
                .fechaRegistro(new Date())
                .build());
    }

    @Override
    public void actualizarVehiculo(Long id, VehiculoRequest vehiculoRequest) {
        if (vehiculoRepository.existsById(id)) {
            Vehiculo vehiculo = Vehiculo.builder()
                    .id(id)
                    .placa(vehiculoRequest.getPlaca())
                    .numMotor(vehiculoRequest.getNumMotor())
                    .numSerie(vehiculoRequest.getNumSerie())
                    .marca(vehiculoRequest.getMarca())
                    .modelo(vehiculoRequest.getModelo())
                    .anioFabricacion(vehiculoRequest.getAnioFabricacion())
                    .color(vehiculoRequest.getColor())
                    .kilometraje(vehiculoRequest.getKilometraje())
                    .tipoCombustible(vehiculoRequest.getTipoCombustible())
                    .transmision(vehiculoRequest.getTransmision())
                    .img(vehiculoRequest.getImg())
                    .fechaModificacion(new Date())
                    .build();

            Vehiculo vehiculoDB = vehiculoRepository.findById(id).orElse(null);

            for (Field field : vehiculo.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    Object value = field.get(vehiculo);
                    if (value != null) {
                        field.set(vehiculoDB, value);
                    }
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            vehiculoRepository.save(vehiculoDB);
        }
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

        Vehiculo vehiculo = vehiculoRepository.findById(idVehiculo).orElse(null);

        ResponseEntity<?> response = rMantService.obtenerMantenimientosSalidaPorVehiculo(idVehiculo);

        List<?> list = (List<?>) response.getBody();

        return MantSalidaPorVehiculoResponse.builder()
                .id(vehiculo.getId())
                .placa(vehiculo.getPlaca())
                .mantenimientosSalida(list)
                .build();
    }

    @Override
    public MantIngresoPorVehiculoResponse obtenerMantenimientosIngresoPorVehiculo(Long idVehiculo) {

        Vehiculo vehiculo = vehiculoRepository.findById(idVehiculo).orElse(null);

        List<MantIngresoDTO> mantenimientosIngreso = rMantService.obtenerMantenimientosIngresoPorVehiculo(idVehiculo);

        return MantIngresoPorVehiculoResponse.builder()
                .id(vehiculo.getId())
                .placa(vehiculo.getPlaca())
                .mantenimientosIngreso(mantenimientosIngreso)
                .build();
    }

    @Override
    public void cambiarEstadoVehiculo(Long id) {
        if (vehiculoRepository.existsById(id)) {
            Vehiculo vehiculo = vehiculoRepository.findById(id).orElse(null);
            vehiculo.setEstado(!vehiculo.getEstado());
            vehiculo.setFechaModificacion(new Date());
            vehiculoRepository.save(vehiculo);
        }
    }

}
