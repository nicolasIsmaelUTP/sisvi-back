package com.sisvi.svc_viajes.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sisvi.svc_viajes.entities.Averia;

public interface AveriaRepository extends CrudRepository<Averia, Long> {
    List<Averia> findByVehiculoId(Long vehiculoId);
    List<Averia> findByEstado(Boolean estado);
}
