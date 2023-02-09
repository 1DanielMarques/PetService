package br.com.petservice.infra.persistence.entities;

import br.com.petservice.domain.model.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_address")
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(length = 100)
    @Getter
    @Setter
    private String street;

    @Column(length = 50)
    @Getter
    @Setter
    private String district;

    @Column(length = 5)
    @Getter
    @Setter
    private int houseNumber;

    public Address toAddressFromAddress(Address address) {
        updateAddressData(address);
        return address;
    }

    public Address toAddressFromEntity() {
        return new Address(this.getId(), this.getStreet(), this.getDistrict(), this.getHouseNumber());
    }

    private void updateAddressData(Address address) {
        address.setId(this.getId());
        address.setStreet(this.getStreet());
        address.setDistrict(this.getDistrict());
        address.setHouseNumber(this.getHouseNumber());
    }


    public static AddressEntity crateFromAddress(Address address) {
        return new AddressEntity(address.getId(), address.getStreet(), address.getDistrict(), address.getHouseNumber());
    }

}
