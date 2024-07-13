package com.sisvi.svc_viajes.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisvi.svc_viajes.entities.Averia;
import com.sisvi.svc_viajes.http.request.AveriaRequest;
import com.sisvi.svc_viajes.persistence.AveriaRepository;

@Service
public class AveriaServiceImpl implements PAveriaService{
    @Autowired
    private AveriaRepository averiaRepository;

    @Override
    public List<Averia> obtenerAverias() {
        return (List<Averia>) averiaRepository.findAll();
    }

    @Override
    public List<Averia> obtenerAveriasPorVehiculo(Long vehiculoId) {
        return averiaRepository.findByVehiculoId(vehiculoId);
    }

    @Override
    public List<Averia> obtenerAveriasPorEstado(Boolean estado) {
        return averiaRepository.findByEstado(estado);
    }

    @Override
    public Averia obtenerAveriaPorId(Long id) {
        return averiaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarAveria(AveriaRequest averiaRequest) {
        Averia averia = Averia.builder()
            .vehiculoId(averiaRequest.getVehiculoId())
            .tipo(averiaRequest.getTipo())
            .descripcion(averiaRequest.getDescripcion())
            .ubicacion(averiaRequest.getUbicacion())
            .fechaRegistro(new Date())
            .estado(true)
            .build();
        averiaRepository.save(averia);
    }

    @Override
    public void cambiarEstadoAveria(Long id) {
        if (averiaRepository.existsById(id)) {
            Averia averia = averiaRepository.findById(id).get();
            averia.setEstado(!averia.getEstado());
            averiaRepository.save(averia);
        }
    }
    
}
