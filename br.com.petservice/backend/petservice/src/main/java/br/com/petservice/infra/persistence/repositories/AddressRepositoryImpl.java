package br.com.petservice.infra.persistence.repositories;

import br.com.petservice.domain.model.Address;
import br.com.petservice.infra.persistence.entities.AddressEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddressRepositoryImpl implements AddressRepository {

    private final InMemoryRepository<AddressEntity> repository;

    @Override
    public Address save(Address address) {
        return repository.save(AddressEntity.crateFromAddress(address)).toAddressFromAddress(address);
    }
}
