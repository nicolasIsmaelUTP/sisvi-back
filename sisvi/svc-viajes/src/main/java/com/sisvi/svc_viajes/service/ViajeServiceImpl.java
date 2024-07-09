package com.sisvi.svc_viajes.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisvi.svc_viajes.entities.Viaje;
import com.sisvi.svc_viajes.http.request.ViajeRequest;
import com.sisvi.svc_viajes.persistence.ViajeRepository;

@Service
public class ViajeServiceImpl implements PViajeService{
    @Autowired
    private ViajeRepository viajeRepository;

    @Override
    public List<Viaje> obtenerViajes() {
        return (List<Viaje>) viajeRepository.findAll();
    }

    @Override
    public List<Viaje> obtenerViajesPorConductor(Long conductorId) {
        return viajeRepository.findByConductorId(conductorId);
    }

    @Override
    public List<Viaje> obtenerViajesPorVehiculo(Long vehiculoId) {
        return viajeRepository.findByVehiculoId(vehiculoId);
    }

    @Override
    public List<Viaje> obtenerViajesPorEstado(Boolean estado) {
        return viajeRepository.findByEstado(estado);
    }

    @Override
    public Viaje obtenerViajePorId(Long id) {
        return viajeRepository.findById(id).orElse(null);
    }

    @Override
    public void nuevoViaje(ViajeRequest viajeRequest) {
        Viaje nuevo = Viaje.builder()
            .fechaHoraInicio(new Date())
            .ubicacionInicio(viajeRequest.getUbicacionInicio())
            .conductorId(viajeRequest.getConductorId())
            .vehiculoId(viajeRequest.getVehiculoId())
            .estado(true)
            .build();
        viajeRepository.save(nuevo);
    }

    @Override
    public void finalizarViaje(Long id, String ubicacionFin) {
        if (viajeRepository.existsById(id)) {
            Viaje viaje = viajeRepository.findById(id).get();
            viaje.setFechaHoraFin(new Date());
            viaje.setUbicacionFin(ubicacionFin);
            viajeRepository.save(viaje);
        }
    }

    @Override
    public void cambiarEstadoViaje(Long id) {
        if (viajeRepository.existsById(id)) {
            Viaje viaje = viajeRepository.findById(id).get();
            viaje.setEstado(!viaje.getEstado());
            viajeRepository.save(viaje);
        }
    }
    
}
