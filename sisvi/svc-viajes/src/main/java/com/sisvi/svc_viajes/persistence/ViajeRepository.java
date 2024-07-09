package com.sisvi.svc_viajes.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sisvi.svc_viajes.entities.Viaje;

@Repository
public interface ViajeRepository extends CrudRepository<Viaje, Long>{
    List<Viaje> findByConductorId(Long conductorId);
    List<Viaje> findByVehiculoId(Long vehiculoId);
    List<Viaje> findByEstado(Boolean estado);
}
