package com.sisvi.svc_viajes.http.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AveriaRequest {
    private Long vehiculoId;
    private String tipo;
    private String descripcion;
    private String ubicacion;
}
