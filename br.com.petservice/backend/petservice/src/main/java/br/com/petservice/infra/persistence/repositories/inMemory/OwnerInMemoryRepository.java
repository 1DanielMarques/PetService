package br.com.petservice.infra.persistence.repositories.inMemory;

import br.com.petservice.infra.persistence.entities.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerInMemoryRepository extends JpaRepository<OwnerEntity,Long> {
}
