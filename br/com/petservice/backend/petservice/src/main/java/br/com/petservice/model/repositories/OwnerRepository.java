package br.com.petservice.model.repositories;

import br.com.petservice.model.entities.OwnerDatabaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OwnerRepository extends JpaRepository<OwnerDatabaseEntity,Long> {
}
