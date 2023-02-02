package br.com.petservice.assembler;

import br.com.petservice.dto.OwnerDTO;
import br.com.petservice.entities.OwnerEntity;
import org.springframework.stereotype.Component;

@Component
public class OwnerAssembler {

    public OwnerEntity toOwnerEntity(OwnerDTO ownerDTO) {
        return new OwnerEntity(null, ownerDTO.name(), ownerDTO.mainPhone(), ownerDTO.emergencyPhone());
    }

    public OwnerDTO toOwnerDTO(OwnerEntity ownerEntity) {
        return new OwnerDTO(ownerEntity.getId(), ownerEntity.getName(), ownerEntity.getMainPhone(), ownerEntity.getEmergencyPhone());
    }
}
