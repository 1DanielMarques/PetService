package br.com.petservice.infra.persistence.repositories;

import br.com.petservice.infra.persistence.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity,Long> {
}
