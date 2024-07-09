package com.sisvi.svc_viajes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    private String observaciones;
    private String ubicacion;
    private String fechaRegistro;
    private Boolean estado;

    @ManyToOne
    private Viaje viaje;
}
