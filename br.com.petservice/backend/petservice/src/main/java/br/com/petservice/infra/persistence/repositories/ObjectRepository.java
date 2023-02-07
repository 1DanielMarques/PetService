package br.com.petservice.infra.persistence.repositories;

import java.util.List;

public interface ObjectRepository {

    Object save(Object object);

    List<Object> findAll();

}
