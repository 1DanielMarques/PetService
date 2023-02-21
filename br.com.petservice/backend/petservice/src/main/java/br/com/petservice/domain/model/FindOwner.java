package br.com.petservice.domain.model;

import java.util.List;

public interface FindOwner {

    List<Owner> findAll();

    Owner findById(Long id);
}
