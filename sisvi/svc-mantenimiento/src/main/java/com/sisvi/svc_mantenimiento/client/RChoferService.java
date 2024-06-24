package com.sisvi.svc_mantenimiento.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sisvi.svc_mantenimiento.dto.ChoferDTO;

@FeignClient(name = "svc-choferes", url = "localhost:8069/api/choferes")
public interface RChoferService {

    @GetMapping("/dni/{dni}")
    ChoferDTO obtenerPorDni(@PathVariable String dni);
}
