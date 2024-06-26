package com.sisvi.svc_mantenimiento.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sisvi.svc_mantenimiento.entities.MantenimientoIngreso;

@Repository
public interface MantIngresoRepository extends CrudRepository<MantenimientoIngreso, Long>{
    
}
