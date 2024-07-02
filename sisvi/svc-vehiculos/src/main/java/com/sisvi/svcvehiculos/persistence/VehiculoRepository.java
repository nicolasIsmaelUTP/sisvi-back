package com.sisvi.svcvehiculos.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sisvi.svcvehiculos.entities.Vehiculo;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, Long>{
    List<Vehiculo> findByEstado(Boolean estado);
    Vehiculo findByPlaca(String placa);
}
