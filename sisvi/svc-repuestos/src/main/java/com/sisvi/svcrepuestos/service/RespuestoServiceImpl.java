package com.sisvi.svcrepuestos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sisvi.svcrepuestos.entities.Repuesto;
import com.sisvi.svcrepuestos.persistence.RepuestoRepository;

@Service
public class RespuestoServiceImpl implements PRepuestoService{

    @Autowired
    private RepuestoRepository repuestoRepository;

    @Override
    public List<Repuesto> obtenerTodosRepuestos() {
        return (List<Repuesto>) repuestoRepository.findAll();
    }

    @Override
    public Repuesto obtenerRepuestoPorId(Long id) {
        return repuestoRepository.findById(id).orElse(null);
    }

    @Override
    public Repuesto guardarRepuesto(Repuesto repuesto) {
        return repuestoRepository.save(repuesto);
    }

    @Override
    public void eliminarRepuestoPorId(Long id) {
        repuestoRepository.deleteById(id);
    }
    
}
