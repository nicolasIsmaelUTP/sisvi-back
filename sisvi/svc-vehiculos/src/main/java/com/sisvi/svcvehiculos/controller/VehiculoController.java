package com.sisvi.svcvehiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.http.ResponseEntity;

import com.sisvi.svcvehiculos.entities.Vehiculo;
import com.sisvi.svcvehiculos.http.request.VehiculoRequest;
import com.sisvi.svcvehiculos.service.PVehiculoService;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private PVehiculoService vehiculoService;

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
        List<Vehiculo> vehiculos = vehiculoService.obtenerTodosVehiculos();
        return ResponseEntity.ok(vehiculos);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> obtenerVehiculoPorId(@PathVariable Long id) {
        Vehiculo vehiculo = vehiculoService.obtenerVehiculoPorId(id);
        return ResponseEntity.ok(vehiculo);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarVehiculoPorId(@PathVariable Long id) {
        vehiculoService.eliminarVehiculoPorId(id);
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
