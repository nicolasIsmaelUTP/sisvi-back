package com.sisvi.svc_mantenimiento.entities;

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
@Table(name = "mantenimiento_ingreso")
@AllArgsConstructor
@NoArgsConstructor
public class MantenimientoIngreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idVehiculo;
    private Long idChofer;
    private Date fechaIngreso;
    private int kilometrajeIngresado;
    private String observaciones;
    private boolean estado;
}
