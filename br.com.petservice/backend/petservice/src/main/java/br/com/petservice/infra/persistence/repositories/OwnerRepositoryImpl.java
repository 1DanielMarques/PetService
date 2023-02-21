package br.com.petservice.infra.persistence.repositories;

import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.persistence.entities.OwnerEntity;
import br.com.petservice.infra.persistence.repositories.inMemory.OwnerInMemoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class OwnerRepositoryImpl implements OwnerRepository {

    private final OwnerInMemoryRepository repository;

    @Override
    public Owner save(Owner owner) {
        return repository.save(OwnerEntity.createFromOwner((Owner) owner)).toOwnerFromOwner((Owner) owner);
    }


    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Owner> findAll() {
        return  repository.findAll().stream().map(OwnerEntity::toOwnerFromEntity).collect(Collectors.toList());
    }

    @Override
    public Owner findById(Long id) {
        return repository.findById(id).get().toOwnerFromEntity();
    }


}
