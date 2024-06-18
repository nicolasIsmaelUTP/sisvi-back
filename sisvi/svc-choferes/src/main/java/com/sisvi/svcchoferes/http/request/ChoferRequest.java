package com.sisvi.svcchoferes.http.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChoferRequest {
    private String dni;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String licenciaConducir;
    private String categoriaLicencia;
    private Date fechaVencimientoLicencia;
}
