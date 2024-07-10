package com.sisvi.svc_infracciones.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sisvi.svc_infracciones.entities.Infraccion;

@Repository
public interface InfraccionRepository extends CrudRepository<Infraccion, Long>{
    List<Infraccion> findByChoferId(Long choferId);
    List<Infraccion> findByVehiculoId(Long vehiculoId);
    List<Infraccion> findByEstado(Boolean estado);
}
