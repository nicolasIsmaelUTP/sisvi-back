package com.sisvi.svc_infracciones.service;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisvi.svc_infracciones.entities.Infraccion;
import com.sisvi.svc_infracciones.http.request.InfraccionRequest;
import com.sisvi.svc_infracciones.persistence.InfraccionRepository;

@Service
public class InfraccionServiceImpl implements PInfraccionService{
    @Autowired
    private InfraccionRepository infraccionRepository;

    @Override
    public List<Infraccion> obtenerInfracciones() {
        return (List<Infraccion>) infraccionRepository.findAll();
    }

    @Override
    public List<Infraccion> obtenerInfraccionesPorChofer(Long choferId) {
        return infraccionRepository.findByChoferId(choferId);
    }

    @Override
    public List<Infraccion> obtenerInfraccionesPorVehiculo(Long vehiculoId) {
        return infraccionRepository.findByVehiculoId(vehiculoId);
    }

    @Override
    public List<Infraccion> obtenerInfraccionesPorEstado(Boolean estado) {
        return infraccionRepository.findByEstado(estado);
    }

    @Override
    public Infraccion obtenerInfraccionPorId(Long id) {
        return infraccionRepository.findById(id).orElse(null);
    }

    @Override
    public void registrarInfraccion(InfraccionRequest infraccionRequest) {
        Infraccion infraccion = construirInfraccion(infraccionRequest);
        infraccion.setFechaRegistro(new Date());
        infraccion.setEstado(true);
        infraccionRepository.save(infraccion);
    }

    @Override
    public void actualizarInfraccion(Long id, InfraccionRequest infraccionRequest) {
        if (infraccionRepository.existsById(id)) {
            Infraccion infraccion = construirInfraccion(infraccionRequest);
            infraccion.setId(id);
            infraccion.setFechaModificacion(new Date());
            
            Infraccion infraccionDB = infraccionRepository.findById(id).orElse(null);

            for (Field field : infraccion.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    Object value = field.get(infraccion);
                    if (value != null) {
                        field.set(infraccionDB, value);
                    }
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            infraccionRepository.save(infraccionDB);
        }
    }

    private Infraccion construirInfraccion(InfraccionRequest infraccionRequest) {
        return Infraccion.builder()
            .choferId(infraccionRequest.getChoferId())
            .vehiculoId(infraccionRequest.getVehiculoId())
            .observaciones(infraccionRequest.getObservaciones())
            .ubicacion(infraccionRequest.getUbicacion())
            .build();
    }

    @Override
    public void cambiarEstadoInfraccion(Long id) {
        if (infraccionRepository.existsById(id)) {
            Infraccion infraccion = infraccionRepository.findById(id).orElse(null);
            infraccion.setEstado(!infraccion.getEstado());
            infraccion.setFechaModificacion(new Date());
            infraccionRepository.save(infraccion);
        }
    }
    
}
