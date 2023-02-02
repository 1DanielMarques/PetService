package br.com.petservice.repositories;

import br.com.petservice.entities.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<OwnerEntity,Long> {


}
