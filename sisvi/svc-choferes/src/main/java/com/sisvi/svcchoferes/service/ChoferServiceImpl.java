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
    public List<Chofer> obtenerTodosChoferes() {
        return (List<Chofer>) choferRepository.findAll();
    }

    @Override
    public Chofer obtenerChoferPorId(Long id) {
        return choferRepository.findById(id).orElse(null);
    }

    @Override
    public void registrarChofer(ChoferRequest choferRequest) {
        choferRepository.save(Chofer.builder()
                .dni(choferRequest.getDni())
                .primerNombre(choferRequest.getPrimerNombre())
                .segundoNombre(choferRequest.getSegundoNombre())
                .apellidoPaterno(choferRequest.getApellidoPaterno())
                .apellidoMaterno(choferRequest.getApellidoMaterno())
                .telefono(choferRequest.getTelefono())
                .licenciaConducir(choferRequest.getLicenciaConducir())
                .categoriaLicencia(choferRequest.getCategoriaLicencia())
                .fechaVencimientoLicencia(choferRequest.getFechaVencimientoLicencia())
                .fechaRegistro(new Date())
                .estado(true)
                .build());
    }

    @Override
    public void actualizarChofer(Long id, ChoferRequest choferRequest) {
        if (choferRepository.existsById(id)) {
            Chofer chofer = Chofer.builder()
                    .id(id)
                    .dni(choferRequest.getDni())
                    .primerNombre(choferRequest.getPrimerNombre())
                    .segundoNombre(choferRequest.getSegundoNombre())
                    .apellidoPaterno(choferRequest.getApellidoPaterno())
                    .apellidoMaterno(choferRequest.getApellidoMaterno())
                    .telefono(choferRequest.getTelefono())
                    .licenciaConducir(choferRequest.getLicenciaConducir())
                    .categoriaLicencia(choferRequest.getCategoriaLicencia())
                    .fechaVencimientoLicencia(choferRequest.getFechaVencimientoLicencia())
                    .fechaModificacion(new Date())
                    .build();

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
