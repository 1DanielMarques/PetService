package br.com.petservice.domain;

import br.com.petservice.domain.model.Owner;

import java.util.List;

public interface FindOwner {

    List<Owner> findAll();

    Owner findById(Long id);
}
