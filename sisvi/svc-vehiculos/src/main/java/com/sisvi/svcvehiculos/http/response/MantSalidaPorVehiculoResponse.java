package com.sisvi.svcvehiculos.http.response;

import java.util.List;

import com.sisvi.svcvehiculos.dto.MantSalidaDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MantSalidaPorVehiculoResponse {
    private Long id;
    private String placa;
    private List<MantSalidaDTO> mantenimientosSalida;
}
