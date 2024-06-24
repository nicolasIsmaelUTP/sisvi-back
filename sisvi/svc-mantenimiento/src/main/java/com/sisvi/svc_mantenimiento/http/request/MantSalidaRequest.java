package com.sisvi.svc_mantenimiento.http.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MantSalidaRequest {
    private Long mantIngresoId;
    private int nivelDanio;
    private int nivelCombustible;
    private int nivelAceite;
    private int kilometrajeSalida;
    private String observaciones;
}
