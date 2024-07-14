package com.sisvi.svc_viajes.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sisvi.svc_viajes.entities.Averia;

@Repository
public interface AveriaRepository extends CrudRepository<Averia, Long> {
    List<Averia> findByVehiculoId(Long vehiculoId);
    List<Averia> findByEstado(Boolean estado);
}
