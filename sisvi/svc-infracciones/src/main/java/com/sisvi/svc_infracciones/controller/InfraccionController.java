package com.sisvi.svc_infracciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.sisvi.svc_infracciones.http.request.InfraccionRequest;
import com.sisvi.svc_infracciones.service.PInfraccionService;

@RestController
@RequestMapping("/api/infracciones")
public class InfraccionController {
    @Autowired
    private PInfraccionService infraccionService;

    @GetMapping("/listar")
    public ResponseEntity<?> listarInfracciones() {
        return ResponseEntity.ok(infraccionService.obtenerInfracciones());
    }

    @GetMapping("/listar/chofer/{choferId}")
    public ResponseEntity<?> listarInfraccionesPorChofer(@PathVariable Long choferId) {
        return ResponseEntity.ok(infraccionService.obtenerInfraccionesPorChofer(choferId));
    }

    @GetMapping("/listar/vehiculo/{vehiculoId}")
    public ResponseEntity<?> listarInfraccionesPorVehiculo(@PathVariable Long vehiculoId) {
        return ResponseEntity.ok(infraccionService.obtenerInfraccionesPorVehiculo(vehiculoId));
    }

    @GetMapping("/listar/estado/{estado}")
    public ResponseEntity<?> listarInfraccionesPorEstado(@PathVariable Boolean estado) {
        return ResponseEntity.ok(infraccionService.obtenerInfraccionesPorEstado(estado));
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerInfraccionPorId(@PathVariable Long id) {
        return ResponseEntity.ok(infraccionService.obtenerInfraccionPorId(id));
    }

    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void registrarInfraccion(@RequestBody InfraccionRequest infraccionRequest) {
        infraccionService.registrarInfraccion(infraccionRequest);
    }

    @PutMapping("/actualizar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void actualizarInfraccion(@PathVariable Long id, @RequestBody InfraccionRequest infraccionRequest) {
        infraccionService.actualizarInfraccion(id, infraccionRequest);
    }

    @PutMapping("/cambiar-estado/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cambiarEstadoInfraccion(@PathVariable Long id) {
        infraccionService.cambiarEstadoInfraccion(id);
    }

}
