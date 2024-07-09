package com.sisvi.svc_viajes.http.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViajeRequest {
    private String ubicacionInicio;
    private Long conductorId;
    private Long vehiculoId;
}
