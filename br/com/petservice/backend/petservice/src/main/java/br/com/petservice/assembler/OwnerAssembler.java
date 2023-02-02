package br.com.petservice.assembler;

import br.com.petservice.dto.OwnerDTO;
import br.com.petservice.entities.Address;
import br.com.petservice.entities.OwnerEntity;
import br.com.petservice.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OwnerAssembler {

    private final AddressRepository addressRepository;

    public OwnerEntity toOwnerEntity(OwnerDTO ownerDTO) {
        Address address = new Address(null, ownerDTO.street(), ownerDTO.district(), ownerDTO.houseNumber());
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
