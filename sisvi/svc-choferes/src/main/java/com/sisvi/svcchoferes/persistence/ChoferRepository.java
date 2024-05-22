package com.sisvi.svcchoferes.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sisvi.svcchoferes.entities.Chofer;

@Repository
public interface ChoferRepository extends CrudRepository<Chofer, Long>{
    
}
