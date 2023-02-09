package br.com.petservice.infra.persistence.repositories.inMemory;

import br.com.petservice.infra.persistence.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetInMemoryRepository extends JpaRepository<PetEntity, Long> {
}
