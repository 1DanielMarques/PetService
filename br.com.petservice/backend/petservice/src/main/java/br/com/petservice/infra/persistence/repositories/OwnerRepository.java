package br.com.petservice.infra.persistence.repositories;

import br.com.petservice.domain.model.Owner;

import java.util.List;

public interface OwnerRepository {

    Owner save(Owner owner);
    void delete(Long id);
    List<Owner> findAll();
    Owner findById(Long id);

}
