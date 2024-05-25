package com.sisvi.svc_parametros.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "parametros")
@AllArgsConstructor
@NoArgsConstructor
public class Parametros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private Long idVehiculo;
    private Integer tempMotorC;
    private Integer presAdmisionKpa;
    private Integer rpmMotor;
    private Integer velocidadKmh;
    private Integer tempAireAdmC;
    private Double flujoAireGps;
    private Double posicionAcelerador;
    private Integer tempAmbienteC;
    private Double posicionPedalD;
    private Double posicionPedalE;
}
