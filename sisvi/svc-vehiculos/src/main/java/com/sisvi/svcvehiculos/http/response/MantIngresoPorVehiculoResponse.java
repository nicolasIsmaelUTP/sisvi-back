package com.sisvi.svcvehiculos.http.response;

import java.util.List;

import com.sisvi.svcvehiculos.dto.MantIngresoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MantIngresoPorVehiculoResponse {
    private Long id;
    private String placa;
    private List<MantIngresoDTO> mantenimientosIngreso;
}
