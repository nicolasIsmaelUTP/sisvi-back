package com.sisvi.svcrepuestos.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sisvi.svcrepuestos.entities.Repuesto;

@Repository
public interface RepuestoRepository extends CrudRepository<Repuesto, Long>{

} 