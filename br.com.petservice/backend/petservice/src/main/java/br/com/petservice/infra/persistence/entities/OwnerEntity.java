package br.com.petservice.infra.persistence.entities;

import br.com.petservice.domain.model.Owner;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "tb_owner")
@AllArgsConstructor
public class OwnerEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(length = 50)
    @Getter
    @Setter
    private String name;

    @Column(length = 11)
    @Getter
    @Setter
    private String mainPhone;

    @Column(length = 11)
    @Getter
    @Setter
    private String emergencyPhone;

    @OneToOne
    @Getter
    @Setter
    private AddressEntity address;

    public static OwnerEntity createFromOwner(Owner owner) {
        return new OwnerEntity(null, owner.getName(), owner.getMainPhone(), owner.getEmergencyPhone(), AddressEntity.crateFromAddress(owner.getAddress()));
    }

    public Owner toOwnerFromOwner(Owner owner) {
        updateOwnerData(owner);
        return owner;
    }

    private void updateOwnerData(Owner owner) {
        owner.setId(this.getId());
        owner.setName(this.getName());
        owner.setMainPhone(this.getMainPhone());
        owner.setEmergencyPhone(this.getEmergencyPhone());
        owner.setAddress(this.getAddress().toAddressFromEntity());
    }

}
