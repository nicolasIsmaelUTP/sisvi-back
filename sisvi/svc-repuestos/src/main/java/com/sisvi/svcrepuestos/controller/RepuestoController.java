package com.sisvi.svcrepuestos.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.http.HttpStatus;
import com.sisvi.svcrepuestos.http.request.RepuestoRequest;
import com.sisvi.svcrepuestos.service.PRepuestoService;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestoController {

    @Autowired
    private PRepuestoService repuestoService;
    
    @GetMapping("/listar")
    public ResponseEntity<?> obtenerTodosRepuestos() {
        return ResponseEntity.ok(repuestoService.obtenerTodosRepuestos());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> obtenerRepuestoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(repuestoService.obtenerRepuestoPorId(id));
    }

    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void registrarRepuesto(@RequestBody RepuestoRequest repuestoRequest) {
        repuestoService.crearRepuesto(repuestoRequest);
    }

    @PutMapping("/actualizar/{id}")
    public void actualizarRepuesto(@PathVariable Long id, @RequestBody RepuestoRequest repuestoRequest) {
        repuestoService.actualizarRepuesto(id, repuestoRequest);
    }

    @PutMapping("/cambiarEstado/{id}")
    public void cambiarEstadoRepuesto(@PathVariable Long id) {
        repuestoService.cambiarEstadoRepuesto(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarRepuestoPorId(@PathVariable Long id) {
        repuestoService.eliminarRepuestoPorId(id);
    }
}
