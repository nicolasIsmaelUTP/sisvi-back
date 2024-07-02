package com.sisvi.svcchoferes.service;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisvi.svcchoferes.entities.Chofer;
import com.sisvi.svcchoferes.http.request.ChoferRequest;
import com.sisvi.svcchoferes.persistence.ChoferRepository;

@Service
public class ChoferServiceImpl implements PChoferService {

    @Autowired
    private ChoferRepository choferRepository;

    @Override
    public Boolean existeChoferPorDni(String dni) {
        return choferRepository.findByDni(dni) != null;
    }

    @Override
    public List<Chofer> obtenerTodosChoferes() {
        return (List<Chofer>) choferRepository.findAll();
    }

    @Override
    public List<Chofer> obtenerChoferesActivos() {
        return choferRepository.findByEstado(true);
    }

    @Override
    public List<Chofer> obtenerChoferesInactivos() {
        return choferRepository.findByEstado(false);
    }

    @Override
    public Chofer obtenerChoferPorId(Long id) {
        return choferRepository.findById(id).orElse(null);
    }

    @Override
    public void registrarChofer(ChoferRequest choferRequest) {
        Chofer chofer = construirChofer(choferRequest);
        chofer.setFechaRegistro(new Date());
        chofer.setEstado(true);
        choferRepository.save(chofer);
    }

    @Override
    public void actualizarChofer(Long id, ChoferRequest choferRequest) {
        if (choferRepository.existsById(id)) {
            Chofer chofer = construirChofer(choferRequest);
            chofer.setId(id);
            chofer.setFechaModificacion(new Date());

            Chofer choferDB = choferRepository.findById(id).orElse(null);

            for (Field field : chofer.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    Object value = field.get(chofer);
                    if (value != null) {
                        field.set(choferDB, value);
                    }
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            choferRepository.save(choferDB);
        }
    }

    private Chofer construirChofer(ChoferRequest choferRequest) {
        return Chofer.builder()
                .dni(choferRequest.getDni())
                .primerNombre(choferRequest.getPrimerNombre())
                .segundoNombre(choferRequest.getSegundoNombre())
                .apellidoPaterno(choferRequest.getApellidoPaterno())
                .apellidoMaterno(choferRequest.getApellidoMaterno())
                .telefono(choferRequest.getTelefono())
                .licenciaConducir(choferRequest.getLicenciaConducir())
                .categoriaLicencia(choferRequest.getCategoriaLicencia())
                .fechaVencimientoLicencia(choferRequest.getFechaVencimientoLicencia())
                .build();
    }

    @Override
    public void cambiarEstadoChofer(Long id) {
        if (choferRepository.existsById(id)) {
            Chofer chofer = choferRepository.findById(id).orElse(null);
            chofer.setEstado(!chofer.getEstado());
            chofer.setFechaModificacion(new Date());
            choferRepository.save(chofer);
        }
    }

    @Override
    public Chofer obtenerPorDni(String dni) {
        return choferRepository.findByDni(dni);
    }

    @Override
    public Chofer obtenerPorLicenciaConducir(String licenciaConducir) {
        return choferRepository.findByLicenciaConducir(licenciaConducir);
    }

}
