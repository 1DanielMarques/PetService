package br.com.petservice.infra.persistence.repositories;

import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.persistence.entities.OwnerEntity;
import br.com.petservice.infra.persistence.repositories.inMemory.OwnerInMemoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class OwnerRepositoryImpl implements ObjectRepository {

    private final OwnerInMemoryRepository repository;

    @Override
    public Owner save(Object owner) {
        return repository.save(OwnerEntity.createFromOwner((Owner) owner)).toOwnerFromOwner((Owner) owner);
    }

    public List<Object> findAll() {
        return (List)repository.findAll();
    }

}
