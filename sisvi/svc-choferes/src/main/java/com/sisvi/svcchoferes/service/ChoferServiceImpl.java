package com.sisvi.svcchoferes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisvi.svcchoferes.entities.Chofer;
import com.sisvi.svcchoferes.persistence.ChoferRepository;

@Service
public class ChoferServiceImpl implements PChoferService{

    @Autowired
    private ChoferRepository choferRepository;

    @Override
    public List<Chofer> obtenerTodosChoferes() {
        return (List<Chofer>) choferRepository.findAll();
    }

    @Override
    public Chofer obtenerChoferPorId(Long id) {
        return choferRepository.findById(id).orElse(null);
    }

    @Override
    public Chofer guardarChofer(Chofer chofer) {
        return choferRepository.save(chofer);
    }

    @Override
    public void eliminarChoferPorId(Long id) {
        choferRepository.deleteById(id);
    }

    @Override
    public Chofer obtenerPorDni(String dni) {
        List<Chofer> choferes = (List<Chofer>) choferRepository.findAll();
        for (Chofer chofer : choferes) {
            if (chofer.getDni().equals(dni)) {
                return chofer;
            }
        }
        return null;
    }

    @Override
    public Chofer obtenerPorLicenciaConducir(String licenciaConducir) {
        List<Chofer> choferes = (List<Chofer>) choferRepository.findAll();
        for (Chofer chofer : choferes) {
            if (chofer.getLicenciaConducir().equals(licenciaConducir)) {
                return chofer;
            }
        }
        return null;
    }
    
}
