package com.sisvi.svc_mantenimiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sisvi.svc_mantenimiento.entities.MantenimientoIngreso;
import com.sisvi.svc_mantenimiento.service.PMantIngresoService;

@RestController
@RequestMapping("/api/mantenimiento/ingreso")
public class MantIngresoController {
    
    @Autowired
    private PMantIngresoService mantIngresoService;

    @GetMapping("/listar")
    public ResponseEntity<?> obtenerTodosMantenimientosIngreso() {
        return ResponseEntity.ok(mantIngresoService.obtenerTodosMantenimientosIngreso());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> obtenerMantenimientoIngresoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mantIngresoService.obtenerMantenimientoIngresoPorId(id));
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarMantenimientoIngreso(@RequestBody MantenimientoIngreso mantIngreso) {
        mantIngresoService.guardarMantenimientoIngreso(mantIngreso);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminarMantenimientoIngresoPorId(@PathVariable Long id) {
        mantIngresoService.eliminarMantenimientoIngresoPorId(id);
    }

    @GetMapping("/listar/vehiculo/{idVehiculo}")
    public ResponseEntity<?> obtenerMantenimientosIngresoPorVehiculo(@PathVariable Long idVehiculo) {
        return ResponseEntity.ok(mantIngresoService.obtenerMantenimientosIngresoPorVehiculo(idVehiculo));
    }
    
}
