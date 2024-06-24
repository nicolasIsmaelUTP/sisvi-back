package com.sisvi.svc_mantenimiento.http.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MantIngresoRequest {
    private String placaVehiculo;
    private String dniChofer;
    private Integer kilometrajeIngresado;
    private String observaciones;
}
