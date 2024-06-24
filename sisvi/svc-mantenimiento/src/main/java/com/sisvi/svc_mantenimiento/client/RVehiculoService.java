package com.sisvi.svc_mantenimiento.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sisvi.svc_mantenimiento.dto.VehiculoDTO;

@FeignClient(name = "svc-vehiculos", url = "localhost:8069/api/vehiculos")
public interface RVehiculoService {
    
    @GetMapping("/placa/{placa}")
    VehiculoDTO obtenerPorPlaca(@PathVariable String placa);
}
