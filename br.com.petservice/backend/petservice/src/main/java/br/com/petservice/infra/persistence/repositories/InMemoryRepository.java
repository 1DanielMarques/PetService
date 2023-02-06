package br.com.petservice.infra.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InMemoryRepository<T> extends JpaRepository<T,Long> {
}
