package br.com.petservice.model.repositories;

import br.com.petservice.model.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OwnerRepository extends JpaRepository<Owner,Long> {
}
