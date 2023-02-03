package br.com.petservice.infra.persistence.repositories;

import br.com.petservice.domain.model.Address;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddressRepositoryImpl implements AddressRepository {

    private final AddressInMemoryRepository repository;

    @Override
    public Address save(Address address) {
        return repository.save(address.toAddressEntity()).toAddress();
    }
}
