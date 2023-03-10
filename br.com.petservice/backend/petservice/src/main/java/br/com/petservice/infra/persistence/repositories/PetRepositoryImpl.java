package br.com.petservice.infra.persistence.repositories;

import br.com.petservice.domain.model.Pet;
import br.com.petservice.infra.persistence.entities.PetEntity;
import br.com.petservice.infra.persistence.repositories.inMemory.PetInMemoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PetRepositoryImpl implements PetRepository {

    private final PetInMemoryRepository repository;

    @Override
    public Pet save(Pet pet) {
        return repository.save(PetEntity.createFromPet(pet)).toPetFromPet(pet);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


}
