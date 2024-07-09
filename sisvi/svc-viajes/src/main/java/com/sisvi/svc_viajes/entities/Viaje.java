package com.sisvi.svc_viajes.entities;

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
@Table(name = "viajes")
@AllArgsConstructor
@NoArgsConstructor
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaHoraInicio;
    private Date fechaHoraFin;
    private String ubicacionInicio;
    private String ubicacionFin;
    private Long conductorId;
    private Long vehiculoId;
    private Boolean estado;
}
