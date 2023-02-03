package br.com.petservice.infra.persistence.repositories;

import br.com.petservice.domain.model.Address;
import br.com.petservice.infra.persistence.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository {

    Address save(Address address);

}
