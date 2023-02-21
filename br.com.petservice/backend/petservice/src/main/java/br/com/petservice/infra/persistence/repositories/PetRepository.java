package br.com.petservice.infra.persistence.repositories;

import br.com.petservice.domain.model.Pet;

public interface PetRepository {

    Pet save(Pet pet);
    void delete(Long id);
}
