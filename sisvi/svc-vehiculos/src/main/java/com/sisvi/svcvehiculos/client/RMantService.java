package com.sisvi.svcvehiculos.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sisvi.svcvehiculos.dto.MantIngresoDTO;


@FeignClient(name = "svc-mantenimiento", url = "localhost:8069/api/mantenimiento")
public interface RMantService {
    
    @GetMapping("/salida/listar/vehiculo/{idVehiculo}")
    ResponseEntity<?> obtenerMantenimientosSalidaPorVehiculo(@PathVariable Long idVehiculo);

    @GetMapping("/ingreso/listar/vehiculo/{idVehiculo}")
    List<MantIngresoDTO> obtenerMantenimientosIngresoPorVehiculo(@PathVariable Long idVehiculo);
}
