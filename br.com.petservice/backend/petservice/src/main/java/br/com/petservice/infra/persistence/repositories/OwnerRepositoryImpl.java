package br.com.petservice.infra.persistence.repositories;

import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.persistence.entities.OwnerEntity;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class OwnerRepositoryImpl implements OwnerRepository {

    private final OwnerInMemoryRepository repository;

    @Override
    public Owner save(Owner owner) {
        return repository.save(OwnerEntity.createFromOwner(owner)).toOwner();
    }

}
