package com.sisvi.svcrepuestos.http.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepuestoRequest {
    private String codigoInterno;
    private String descripcion;
    private String fabricante;
    private Date fechaFabricacion;
    private int cantidadStock;
}
