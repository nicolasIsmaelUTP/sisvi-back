package com.sisvi.svc_parametros.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sisvi.svc_parametros.entities.Parametros;

@Repository
public interface ParametrosRepository extends CrudRepository<Parametros, Long>{
    
}