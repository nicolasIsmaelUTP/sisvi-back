package com.sisvi.svc_mantenimiento.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "mantenimiento_salida")
@AllArgsConstructor
@NoArgsConstructor
public class MantenimientoSalida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private MantenimientoIngreso mantenimientoIngreso;
    private Date fechaSalida;
    private int nivelDanio;
    private int nivelCombustible;
    private int nivelAceite;
    private int kilometrajeSalida;
    private String observaciones;
    private boolean estado;
}
