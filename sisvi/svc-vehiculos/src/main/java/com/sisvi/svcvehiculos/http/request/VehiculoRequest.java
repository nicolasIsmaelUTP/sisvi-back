package com.sisvi.svcvehiculos.http.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoRequest {
    private String placa;
    private String numMotor;
    private String numSerie;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private String color;
    private Integer kilometraje;
    private String tipoCombustible;
    private String transmision;
    private String img;
}
