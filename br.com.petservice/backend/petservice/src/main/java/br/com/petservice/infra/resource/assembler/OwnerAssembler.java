package br.com.petservice.infra.resource.assembler;

import br.com.petservice.domain.model.Address;
import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.dto.OwnerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OwnerAssembler {


    public Owner toOwner(OwnerDTO ownerDTO) {
        Address address = new Address(null, ownerDTO.street(), ownerDTO.district(), ownerDTO.houseNumber());
        return new Owner(null, ownerDTO.name(), ownerDTO.mainPhone(), ownerDTO.emergencyPhone(), address);
    }

    public OwnerDTO toOwnerDTO(Owner owner) {
        return new OwnerDTO(owner.getId(),
                owner.getName(),
                owner.getMainPhone(),
                owner.getEmergencyPhone(),
                owner.getAddress().street(),
                owner.getAddress().district(),
                owner.getAddress().houseNumber());
    }
}
