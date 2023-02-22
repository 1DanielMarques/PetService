package br.com.petservice.infra.persistence.repositories;

import br.com.petservice.domain.model.Address;

public interface AddressRepository {

    Address save(Address address);

    void delete(Long id);

}
