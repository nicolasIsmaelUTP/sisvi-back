package com.sisvi.svc_viajes.entities;

import java.util.Date;

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
@Table(name = "averias")
@AllArgsConstructor
@NoArgsConstructor
public class Averia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String ubicacion;
    // private Date fechaResolucion;
    // private String resolucion;
    private String observaciones;
    private Date fechaRegistro;
    private Boolean estado;

    @ManyToOne
    private Viaje viaje;
}
