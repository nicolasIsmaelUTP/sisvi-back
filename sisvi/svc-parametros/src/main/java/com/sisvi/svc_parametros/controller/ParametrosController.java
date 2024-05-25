package com.sisvi.svc_parametros.controller;

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

import com.sisvi.svc_parametros.entities.Parametros;
import com.sisvi.svc_parametros.service.PParametrosService;

@RestController
@RequestMapping("/api/parametros")
public class ParametrosController {
    
    @Autowired
    private PParametrosService parametrosService;

    @GetMapping("/listar")
    public ResponseEntity<?> obtenerTodosParametros() {
        return ResponseEntity.ok(parametrosService.obtenerTodosParametros());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> obtenerParametrosPorId(@PathVariable Long id) {
        return ResponseEntity.ok(parametrosService.obtenerParametrosPorId(id));
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public void guardarParametros(@RequestBody Parametros parametros) {
        parametrosService.guardarParametros(parametros);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarParametrosPorId(@PathVariable Long id) {
        parametrosService.eliminarParametrosPorId(id);
    }
    
}
