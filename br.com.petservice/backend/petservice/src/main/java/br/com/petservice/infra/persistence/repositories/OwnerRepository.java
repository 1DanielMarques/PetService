package br.com.petservice.infra.persistence.repositories;

import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.persistence.entities.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OwnerRepository {

     Owner save(Owner owner);

}
