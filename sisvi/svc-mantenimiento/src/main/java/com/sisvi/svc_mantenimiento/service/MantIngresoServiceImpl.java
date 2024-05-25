package com.sisvi.svc_mantenimiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisvi.svc_mantenimiento.entities.MantenimientoIngreso;
import com.sisvi.svc_mantenimiento.persistence.MantIngresoRepository;

@Service
public class MantIngresoServiceImpl implements PMantIngresoService {

    @Autowired
    private MantIngresoRepository mantenimientoIngresoRepository;

    @Override
    public List<MantenimientoIngreso> obtenerTodosMantenimientosIngreso() {
        return (List<MantenimientoIngreso>) mantenimientoIngresoRepository.findAll();
    }

    @Override
    public MantenimientoIngreso obtenerMantenimientoIngresoPorId(Long id) {
        return mantenimientoIngresoRepository.findById(id).orElse(null);
    }

    @Override
    public MantenimientoIngreso guardarMantenimientoIngreso(MantenimientoIngreso mantenimientoIngreso) {
        return mantenimientoIngresoRepository.save(mantenimientoIngreso);
    }

    @Override
    public void eliminarMantenimientoIngresoPorId(Long id) {
        mantenimientoIngresoRepository.deleteById(id);
    }

    /**
     * Obtiene una lista de los mantenimientos de ingreso asociados a un vehículo específico.
     *
     * @param idVehiculo El ID del vehículo para el cual se desean obtener los mantenimientos de ingreso.
     * @return Una lista de los mantenimientos de ingreso asociados al vehículo especificado.
     */
    @Override
    public List<MantenimientoIngreso> obtenerMantenimientosIngresoPorVehiculo(Long idVehiculo) {

        List<MantenimientoIngreso> mantenimientosIngreso = obtenerTodosMantenimientosIngreso();

        List<MantenimientoIngreso> mantenimientosIngresoPorVehiculo = mantenimientosIngreso.stream()
                .filter(mantenimientoIngreso -> mantenimientoIngreso.getIdVehiculo() == idVehiculo)
                .toList();
        return mantenimientosIngresoPorVehiculo;
    }

}
