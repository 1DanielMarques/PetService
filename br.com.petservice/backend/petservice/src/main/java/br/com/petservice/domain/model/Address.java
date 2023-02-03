package br.com.petservice.domain.model;

import br.com.petservice.infra.persistence.entities.AddressEntity;

public record Address(Long id, String street, String district, int houseNumber) {


    public AddressEntity toAddressEntity() {
        return new AddressEntity(this.id, this.street, this.district, this.houseNumber);
    }

}
