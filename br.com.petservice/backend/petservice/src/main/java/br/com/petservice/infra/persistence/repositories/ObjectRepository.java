package br.com.petservice.infra.persistence.repositories;

public interface ObjectRepository {

    Object save(Object object);

    void delete(Long id);

    Object update(Object object);


}
