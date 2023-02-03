package br.com.petservice.infra.persistence.repositories;

import br.com.petservice.infra.persistence.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressInMemoryRepository extends JpaRepository<AddressEntity, Long> {
}
