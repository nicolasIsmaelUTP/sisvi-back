package com.sisvi.svc_viajes.controller;

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
import com.sisvi.svc_viajes.http.request.ViajeRequest;
import com.sisvi.svc_viajes.service.PViajeService;

@RestController
@RequestMapping("/api/viajes")
public class ViajeController {
    @Autowired
    private PViajeService viajeService;

    @GetMapping("/listar")
    public ResponseEntity<?> listarViajes() {
        return ResponseEntity.ok(viajeService.obtenerViajes());
    }

    @GetMapping("/listar/conductor/{conductorId}")
    public ResponseEntity<?> listarViajesPorConductor(@PathVariable Long conductorId) {
        return ResponseEntity.ok(viajeService.obtenerViajesPorConductor(conductorId));
    }

    @GetMapping("/listar/vehiculo/{vehiculoId}")
    public ResponseEntity<?> listarViajesPorVehiculo(@PathVariable Long vehiculoId) {
        return ResponseEntity.ok(viajeService.obtenerViajesPorVehiculo(vehiculoId));
    }

    @GetMapping("/obtener/estado/{estado}")
    public ResponseEntity<?> listarViajesPorEstado(@PathVariable Boolean estado) {
        return ResponseEntity.ok(viajeService.obtenerViajesPorEstado(estado));
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerViajePorId(@PathVariable Long id) {
        return ResponseEntity.ok(viajeService.obtenerViajePorId(id));
    }

    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.CREATED)
    public void nuevoViaje(@RequestBody ViajeRequest viajeRequest) {
        viajeService.nuevoViaje(viajeRequest);
    }

    @PutMapping("/finalizar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void finalizarViaje(@PathVariable Long id, @RequestBody String ubicacionFin) {
        viajeService.finalizarViaje(id, ubicacionFin);
    }

    @PutMapping("/cambiarEstado/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void cambiarEstadoViaje(@PathVariable Long id) {
        viajeService.cambiarEstadoViaje(id);
    }
}
