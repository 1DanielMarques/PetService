package br.com.petservice.infra.resource.assembler;

import br.com.petservice.infra.dto.OwnerDTO;
import br.com.petservice.infra.persistence.entities.AddressEntity;
import br.com.petservice.infra.persistence.entities.OwnerEntity;
import br.com.petservice.infra.persistence.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OwnerAssembler {

    private final AddressRepository addressRepository;

    public OwnerEntity toOwnerEntity(OwnerDTO ownerDTO) {
        AddressEntity address = new AddressEntity(null, ownerDTO.street(), ownerDTO.district(), ownerDTO.houseNumber());
        addressRepository.save(address);
        return new OwnerEntity(null, ownerDTO.name(), ownerDTO.mainPhone(), ownerDTO.emergencyPhone(), address);
    }

    public OwnerDTO toOwnerDTO(OwnerEntity ownerEntity) {
        return new OwnerDTO(ownerEntity.getId(),
                ownerEntity.getName(),
                ownerEntity.getMainPhone(),
                ownerEntity.getEmergencyPhone(),
                ownerEntity.getAddress().getStreet(),
                ownerEntity.getAddress().getDistrict(),
                ownerEntity.getAddress().getHouseNumber());
    }
}
