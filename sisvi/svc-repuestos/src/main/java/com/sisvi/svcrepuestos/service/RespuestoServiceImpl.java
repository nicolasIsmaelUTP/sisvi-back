package com.sisvi.svcrepuestos.service;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sisvi.svcrepuestos.entities.Repuesto;
import com.sisvi.svcrepuestos.http.request.RepuestoRequest;
import com.sisvi.svcrepuestos.persistence.RepuestoRepository;

@Service
public class RespuestoServiceImpl implements PRepuestoService {

    @Autowired
    private RepuestoRepository repuestoRepository;

    @Override
    public List<Repuesto> obtenerTodosRepuestos() {
        return (List<Repuesto>) repuestoRepository.findAll();
    }

    @Override
    public List<Repuesto> obtenerRepuestosActivos() {
        return repuestoRepository.findByEstado(true);
    }

    @Override
    public List<Repuesto> obtenerRepuestosInactivos() {
        return repuestoRepository.findByEstado(false);
    }

    @Override
    public Repuesto obtenerRepuestoPorId(Long id) {
        return repuestoRepository.findById(id).orElse(null);
    }

    @Override
    public Repuesto obtenerPorCodigoInterno(String codigoInterno) {
        return repuestoRepository.findByCodigoInterno(codigoInterno);
    }

    @Override
    public void crearRepuesto(RepuestoRequest repuestoRequest) {
        Repuesto repuesto = construirRepuesto(repuestoRequest);
        repuesto.setFechaCreacion(new Date());
        repuesto.setEstado(true);
        repuestoRepository.save(repuesto);
    }

    @Override
    public void actualizarRepuesto(Long id, RepuestoRequest repuestoRequest) {
        if (repuestoRepository.existsById(id)) {
            Repuesto repuesto = construirRepuesto(repuestoRequest);
            repuesto.setId(id);
            repuesto.setFechaActualizacion(new Date());

            Repuesto repuestoDB = repuestoRepository.findById(id).orElse(null);

            for (Field field : repuesto.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    Object value = field.get(repuesto);
                    if (value != null) {
                        field.set(repuestoDB, value);
                    }
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            repuestoRepository.save(repuestoDB);
        }
    }

    private Repuesto construirRepuesto(RepuestoRequest repuestoRequest) {
        return Repuesto.builder()
                .codigoInterno(repuestoRequest.getCodigoInterno())
                .descripcion(repuestoRequest.getDescripcion())
                .fabricante(repuestoRequest.getFabricante())
                .fechaFabricacion(repuestoRequest.getFechaFabricacion())
                .cantidadStock(repuestoRequest.getCantidadStock())
                .build();   
    }

    @Override
    public void cambiarEstadoRepuesto(Long id) {
        if (repuestoRepository.existsById(id)) {
            Repuesto repuesto = repuestoRepository.findById(id).orElse(null);
            repuesto.setEstado(!repuesto.getEstado());
            repuesto.setFechaActualizacion(new Date());
            repuestoRepository.save(repuesto);
        }
    }
}
