package br.com.petservice.infra.persistence.repositories;

import br.com.petservice.domain.model.Address;
import br.com.petservice.infra.persistence.entities.AddressEntity;
import br.com.petservice.infra.persistence.repositories.inMemory.AddressInMemoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddressRepositoryImpl implements ObjectRepository {

    private final AddressInMemoryRepository repository;

    @Override
    public Address save(Object address) {
        return repository.save(AddressEntity.crateFromAddress((Address) address)).toAddressFromAddress((Address) address);
    }


}
