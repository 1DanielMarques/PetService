package br.com.petservice.domain;

import br.com.petservice.domain.model.Owner;

public interface UpdateOwner {

    Owner updateById(Long id, Owner updatedOwner);
}
