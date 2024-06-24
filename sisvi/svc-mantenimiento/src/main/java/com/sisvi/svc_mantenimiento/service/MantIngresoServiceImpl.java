package com.sisvi.svc_mantenimiento.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisvi.svc_mantenimiento.client.RChoferService;
import com.sisvi.svc_mantenimiento.client.RVehiculoService;
import com.sisvi.svc_mantenimiento.dto.ChoferDTO;
import com.sisvi.svc_mantenimiento.dto.VehiculoDTO;
import com.sisvi.svc_mantenimiento.entities.MantenimientoIngreso;
import com.sisvi.svc_mantenimiento.http.request.MantIngresoRequest;
import com.sisvi.svc_mantenimiento.persistence.MantIngresoRepository;

@Service
public class MantIngresoServiceImpl implements PMantIngresoService {

    @Autowired
    private MantIngresoRepository mantenimientoIngresoRepository;

    @Autowired
    private RChoferService choferService;

    @Autowired
    private RVehiculoService vehiculoService;

    @Override
    public List<MantenimientoIngreso> obtenerTodosMantenimientosIngreso() {
        return (List<MantenimientoIngreso>) mantenimientoIngresoRepository.findAll();
    }

    @Override
    public MantenimientoIngreso obtenerMantenimientoIngresoPorId(Long id) {
        return mantenimientoIngresoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarMantenimientoIngresoPorId(Long id) {
        mantenimientoIngresoRepository.deleteById(id);
    }

    /**
     * Obtiene una lista de los mantenimientos de ingreso asociados a un vehículo
     * específico.
     *
     * @param idVehiculo El ID del vehículo para el cual se desean obtener los
     *                   mantenimientos de ingreso.
     * @return Una lista de los mantenimientos de ingreso asociados al vehículo
     *         especificado.
     */
    @Override
    public List<MantenimientoIngreso> obtenerMantenimientosIngresoPorVehiculo(Long idVehiculo) {

        List<MantenimientoIngreso> mantenimientosIngreso = obtenerTodosMantenimientosIngreso();

        List<MantenimientoIngreso> mantenimientosIngresoPorVehiculo = mantenimientosIngreso.stream()
                .filter(mantenimientoIngreso -> mantenimientoIngreso.getIdVehiculo() == idVehiculo)
                .toList();
        return mantenimientosIngresoPorVehiculo;
    }

    @Override
    public void guardarMantenimientoIngreso(MantIngresoRequest mantIngresoRequest) {
        ChoferDTO chofer = choferService.obtenerPorDni(mantIngresoRequest.getDniChofer());
        VehiculoDTO vehiculo = vehiculoService.obtenerPorPlaca(mantIngresoRequest.getPlacaVehiculo());

        if (chofer != null && vehiculo != null) {

            mantenimientoIngresoRepository.save(MantenimientoIngreso.builder()
                    .idVehiculo(vehiculo.getId())
                    .idChofer(chofer.getId())
                    .fechaIngreso(new Date())
                    .kilometrajeIngresado(mantIngresoRequest.getKilometrajeIngresado())
                    .observaciones(mantIngresoRequest.getObservaciones())
                    .estado(true)
                    .build());
        }
    }

    @Override
    public void cambiarEstadoMantenimientoIngreso(Long id) {
        if (mantenimientoIngresoRepository.existsById(id)){
            MantenimientoIngreso mantIngreso = mantenimientoIngresoRepository.findById(id).orElse(null);
            mantIngreso.setEstado(!mantIngreso.getEstado());
            mantIngreso.setFechaActualizacion(new Date());
            mantenimientoIngresoRepository.save(mantIngreso);
        }
    }

}
