package com.sisvi.svcvehiculos.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MantIngresoDTO {
    private Long idVehiculo;
    private Long idChofer;
    private Date fechaIngreso;
    private int kilometrajeIngresado;
    private String observaciones;
    private boolean estado;
}
