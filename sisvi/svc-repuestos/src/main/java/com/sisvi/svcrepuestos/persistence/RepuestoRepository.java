package com.sisvi.svcrepuestos.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sisvi.svcrepuestos.entities.Repuesto;

@Repository
public interface RepuestoRepository extends CrudRepository<Repuesto, Long>{
    List<Repuesto> findByEstado(Boolean estado);
    Repuesto findByCodigoInterno(String codigoInterno);
} 