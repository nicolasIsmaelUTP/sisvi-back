package com.sisvi.svc_mantenimiento.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisvi.svc_mantenimiento.entities.MantenimientoIngreso;
import com.sisvi.svc_mantenimiento.entities.MantenimientoSalida;
import com.sisvi.svc_mantenimiento.http.request.MantSalidaRequest;
import com.sisvi.svc_mantenimiento.persistence.MantIngresoRepository;
import com.sisvi.svc_mantenimiento.persistence.MantSalidaRepository;

@Service
public class MantSalidaServiceImpl implements PMantSalidaService {

    @Autowired
    private MantSalidaRepository mantenimientoSalidaRepository;

    @Autowired
    private MantIngresoRepository mantenimientoIngresoRepository;

    @Override
    public List<MantenimientoSalida> obtenerTodosMantenimientosSalida() {
        return (List<MantenimientoSalida>) mantenimientoSalidaRepository.findAll();
    }

    @Override
    public MantenimientoSalida obtenerMantenimientoSalidaPorId(Long id) {
        return mantenimientoSalidaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarMantenimientoSalidaPorId(Long id) {
        mantenimientoSalidaRepository.deleteById(id);
    }

    /**
     * Obtiene una lista de los mantenimientos de salida asociados a un vehículo
     * específico.
     *
     * @param idVehiculo El ID del vehículo.
     * @return Una lista de los mantenimientos de salida asociados al vehículo.
     */
    @Override
    public List<MantenimientoSalida> obtenerMantenimientosSalidaPorVehiculo(Long idVehiculo) {

        List<MantenimientoSalida> mantenimientosSalida = obtenerTodosMantenimientosSalida();

        List<MantenimientoSalida> mantenimientosSalidaPorVehiculo = mantenimientosSalida.stream()
                .filter(mantenimientoSalida -> mantenimientoSalida.getMantenimientoIngreso()
                        .getIdVehiculo() == idVehiculo)
                .toList();
        return mantenimientosSalidaPorVehiculo;
    }

    @Override
    public void guardarMantenimientoSalida(MantSalidaRequest request) {
        if (mantenimientoIngresoRepository.existsById(request.getMantIngresoId())){

            MantenimientoIngreso mi = mantenimientoIngresoRepository.findById(request.getMantIngresoId()).get();

            mantenimientoSalidaRepository.save(MantenimientoSalida.builder()
                    .mantenimientoIngreso(mi)
                    .fechaSalida(new Date())
                    .nivelDanio(request.getNivelDanio())
                    .nivelCombustible(request.getNivelCombustible())
                    .nivelAceite(request.getNivelAceite())
                    .kilometrajeSalida(request.getKilometrajeSalida())
                    .observaciones(request.getObservaciones())
                    .estado(true)
                    .build());
        }

    }

    @Override
    public void cambiarEstadoMantenimientoSalida(Long id) {
        if (mantenimientoSalidaRepository.existsById(id)) {
            MantenimientoSalida ms = mantenimientoSalidaRepository.findById(id).get();
            ms.setEstado(!ms.getEstado());
            ms.setFechaActualizacion(new Date());
            mantenimientoSalidaRepository.save(ms);
        }
    }

}
