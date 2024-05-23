package com.sisvi.svcvehiculos.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sisvi.svcvehiculos.dto.MantSalidaDTO;

@FeignClient(name = "svc-mantenimiento", url = "localhost:8069/api/mantenimiento/salida")
public interface RMantSalidaService {
    
    @GetMapping("/listar/vehiculo/{idVehiculo}")
    List<MantSalidaDTO> obtenerMantenimientosSalidaPorVehiculo(@PathVariable Long idVehiculo);
}
