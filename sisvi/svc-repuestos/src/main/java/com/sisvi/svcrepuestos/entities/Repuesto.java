package com.sisvi.svcrepuestos.entities;

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
@Table(name = "repuestos")
@AllArgsConstructor
@NoArgsConstructor
public class Repuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoInterno;
    private String descripcion;
    private String fabricante;
    private Date fechaFabricacion;
    private Integer cantidadStock;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private Boolean estado;
}
