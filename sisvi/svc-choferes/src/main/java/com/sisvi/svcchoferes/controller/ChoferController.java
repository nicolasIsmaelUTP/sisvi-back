package com.sisvi.svcchoferes.controller;

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

import com.sisvi.svcchoferes.entities.Chofer;
import com.sisvi.svcchoferes.service.PChoferService;

@RestController
@RequestMapping("/api/choferes")
public class ChoferController {
    
    @Autowired
    private PChoferService choferService;

    @GetMapping("/listar")
    public ResponseEntity<?> obtenerTodosChoferes() {
        return ResponseEntity.ok(choferService.obtenerTodosChoferes());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> obtenerChoferPorId(@PathVariable Long id) {
        return ResponseEntity.ok(choferService.obtenerChoferPorId(id));
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarChofer(@RequestBody Chofer chofer) {
        choferService.guardarChofer(chofer);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarChoferPorId(@PathVariable Long id) {
        choferService.eliminarChoferPorId(id);
    }

    // Obtener por DNI
    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> obtenerPorDni(@PathVariable String dni) {
        return ResponseEntity.ok(choferService.obtenerPorDni(dni));
    }

    // Obtener por licencia de conducir
    @GetMapping("/licencia/{licenciaConducir}")
    public ResponseEntity<?> obtenerPorLicenciaConducir(@PathVariable String licenciaConducir) {
        return ResponseEntity.ok(choferService.obtenerPorLicenciaConducir(licenciaConducir));
    }

}
