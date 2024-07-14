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

import com.sisvi.svc_viajes.http.request.AveriaRequest;
import com.sisvi.svc_viajes.service.PAveriaService;

@RestController
@RequestMapping("/api/averias")
public class AveriaController {
    @Autowired
    private PAveriaService averiaService;

    @GetMapping("/listar")
    public ResponseEntity<?> listarAverias() {
        return ResponseEntity.ok(averiaService.obtenerAverias());
    }

    @GetMapping("/listarPorVehiculo/{vehiculoId}")
    public ResponseEntity<?> listarAveriasPorVehiculo(@PathVariable Long vehiculoId) {
        return ResponseEntity.ok(averiaService.obtenerAveriasPorVehiculo(vehiculoId));
    }

    @GetMapping("/listarPorEstado/{estado}")
    public ResponseEntity<?> listarAveriasPorEstado(@PathVariable Boolean estado) {
        return ResponseEntity.ok(averiaService.obtenerAveriasPorEstado(estado));
    }

    @GetMapping("/obtenerPorId/{id}")
    public ResponseEntity<?> obtenerAveriaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(averiaService.obtenerAveriaPorId(id));
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarAveria(@RequestBody AveriaRequest averiaRequest) {
        averiaService.guardarAveria(averiaRequest);
    }
    
    @PutMapping("/cambiarEstado/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void cambiarEstadoAveria(@PathVariable Long id) {
        averiaService.cambiarEstadoAveria(id);
    }
}
