package com.sisvi.svcchoferes.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sisvi.svcchoferes.entities.Chofer;
import java.util.List;


@Repository
public interface ChoferRepository extends CrudRepository<Chofer, Long>{
    List<Chofer> findByEstado(Boolean estado);
    Chofer findByDni(String dni);
    Chofer findByLicenciaConducir(String licenciaConducir);
}
