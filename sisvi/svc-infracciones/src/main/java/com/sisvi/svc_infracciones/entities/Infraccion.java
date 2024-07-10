package com.sisvi.svc_infracciones.entities;

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

@Entity
@Data
@Builder
@Table(name = "infracciones")
@AllArgsConstructor
@NoArgsConstructor
public class Infraccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long choferId;
    private Long vehiculoId;
    private String observaciones;
    private String ubicacion;
    private Date fechaRegistro;
    private Date fechaModificacion;
    private Boolean estado;
}
