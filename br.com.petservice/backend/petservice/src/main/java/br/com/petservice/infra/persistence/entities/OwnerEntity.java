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
@NoArgsConstructor
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
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.updateData(owner);
        return ownerEntity;
    }

    public Owner toOwner() {
        return new Owner(null, this.getName(), this.getMainPhone(), this.getEmergencyPhone(), this.getAddress().toAddress());
    }

    private void updateData(Owner owner) {
        this.setName(owner.getName());
        this.setMainPhone(owner.getMainPhone());
        this.setEmergencyPhone(owner.getEmergencyPhone());
        this.setAddress(owner.getAddress().toAddressEntity());
    }


}
