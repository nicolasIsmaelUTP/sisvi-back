package com.sisvi.svc_infracciones.http.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfraccionRequest {
    private Long choferId;
    private Long vehiculoId;
    private String observaciones;
    private String ubicacion;
}
