package com.sisvi.svcvehiculos.entities;

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
@Table(name = "vehiculos")
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String numMotor;
    private String numSerie;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private String color;
    private Integer kilometraje;
    private String tipoCombustible;
    private String transmision;
    private String img;
    private Boolean estado;
    private Date fechaRegistro;
    private Date fechaModificacion;
}
