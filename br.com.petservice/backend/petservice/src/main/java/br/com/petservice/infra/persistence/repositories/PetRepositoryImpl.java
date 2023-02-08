package br.com.petservice.infra.persistence.repositories;

import br.com.petservice.domain.model.Pet;
import br.com.petservice.infra.persistence.repositories.inMemory.PetInMemoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PetRepositoryImpl implements ObjectRepository {

    private final PetInMemoryRepository repository;

    @Override
    public Pet save(Object pet) {
        return null;
    }

}
