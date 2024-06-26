package com.sisvi.svc_mantenimiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sisvi.svc_mantenimiento.http.request.MantSalidaRequest;
import com.sisvi.svc_mantenimiento.service.PMantSalidaService;

@RestController
@RequestMapping("/api/mantenimiento/salida")
public class MantSalidaController {

    @Autowired
    private PMantSalidaService mantSalidaService;
    
    @GetMapping("/listar")
    public ResponseEntity<?> obtenerTodosMantenimientosSalida() {
        return ResponseEntity.ok(mantSalidaService.obtenerTodosMantenimientosSalida());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> obtenerMantenimientoSalidaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mantSalidaService.obtenerMantenimientoSalidaPorId(id));
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarMantenimientoSalida(@RequestBody MantSalidaRequest request) {
        mantSalidaService.guardarMantenimientoSalida(request);
    }

    @PutMapping("/cambiar-estado/{id}")
    public void cambiarEstadoMantenimientoSalida(@PathVariable Long id) {
        mantSalidaService.cambiarEstadoMantenimientoSalida(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarMantenimientoSalidaPorId(@PathVariable Long id) {
        mantSalidaService.eliminarMantenimientoSalidaPorId(id);
    }

    @GetMapping("/listar/vehiculo/{idVehiculo}")
    public ResponseEntity<?> obtenerMantenimientosSalidaPorVehiculo(@PathVariable Long idVehiculo) {
        return ResponseEntity.ok(mantSalidaService.obtenerMantenimientosSalidaPorVehiculo(idVehiculo));
    }
}
