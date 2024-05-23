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
public class MantSalidaDTO {
    private Date fechaSalida;
    private int nivelDanio;
    private int nivelCombustible;
    private int nivelAceite;
    private int kilometrajeSalida;
    private String observaciones;
    private boolean estado;
}
