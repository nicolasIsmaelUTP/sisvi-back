package com.sisvi.svcvehiculos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "svc-mantenimiento", url = "localhost:8069/api/mantenimiento/salida")
public interface RMantSalidaService {
    
    @GetMapping("/listar/vehiculo/{idVehiculo}")
    ResponseEntity<?> obtenerMantenimientosSalidaPorVehiculo(@PathVariable Long idVehiculo);
}
