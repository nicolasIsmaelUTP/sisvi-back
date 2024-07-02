package com.sisvi.svcvehiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sisvi.svcvehiculos.entities.Vehiculo;
import com.sisvi.svcvehiculos.http.request.VehiculoRequest;
import com.sisvi.svcvehiculos.service.PVehiculoService;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private PVehiculoService vehiculoService;

    @GetMapping("/existe-placa/{placa}")
    public ResponseEntity<?> existeVehiculoPorPlaca(@PathVariable String placa) {
        return ResponseEntity.ok(vehiculoService.existeVehiculoPorPlaca(placa));
    }

    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void registrarVehiculo(@RequestBody VehiculoRequest vehiculoRequest) {
        vehiculoService.registrarVehiculo(vehiculoRequest);
    }

    @PutMapping("/actualizar/{id}")
    public void actualizarVehiculo(@PathVariable Long id, @RequestBody VehiculoRequest vehiculoRequest) {
        vehiculoService.actualizarVehiculo(id, vehiculoRequest);
    }

    @PutMapping("/cambiar-estado/{id}")
    public void cambiarEstadoVehiculo(@PathVariable Long id) {
        vehiculoService.cambiarEstadoVehiculo(id);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> obtenerTodosVehiculos() {
        return ResponseEntity.ok(vehiculoService.obtenerTodosVehiculos());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> obtenerVehiculoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculoService.obtenerVehiculoPorId(id));
    }

    @GetMapping("/listar-activos")
    public ResponseEntity<?> obtenerVehiculosActivos() {
        return ResponseEntity.ok(vehiculoService.obtenerVehiculosActivos());
    }

    @GetMapping("/listar-inactivos")
    public ResponseEntity<?> obtenerVehiculosInactivos() {
        return ResponseEntity.ok(vehiculoService.obtenerVehiculosInactivos());
    }

    // Obtener vehiculo por placa
    @GetMapping("/placa/{placa}")
    public ResponseEntity<?> obtenerPorPlaca(@PathVariable String placa) {
        Vehiculo vehiculo = vehiculoService.obtenerPorPlaca(placa);
        return ResponseEntity.ok(vehiculo);
    }

    // Obtener mantenimientos de salida por vehiculo
    @GetMapping("/mantenimientos-salida/{idVehiculo}")
    public ResponseEntity<?> obtenerMantenimientosSalidaPorVehiculo(@PathVariable Long idVehiculo) {
        return ResponseEntity.ok(vehiculoService.obtenerMantenimientosSalidaPorVehiculo(idVehiculo));
    }

    // Obtener mantenimientos de ingreso por vehiculo
    @GetMapping("/mantenimientos-ingreso/{idVehiculo}")
    public ResponseEntity<?> obtenerMantenimientosIngresoPorVehiculo(@PathVariable Long idVehiculo) {
        return ResponseEntity.ok(vehiculoService.obtenerMantenimientosIngresoPorVehiculo(idVehiculo));
    }

}
