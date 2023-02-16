package br.com.petservice.infra.resource.assembler;

import br.com.petservice.domain.model.Address;
import br.com.petservice.domain.model.Owner;
import br.com.petservice.domain.model.Pet;
import br.com.petservice.infra.dto.OwnerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OwnerAssembler {


    public Owner toOwner(OwnerDTO ownerDTO) {
        Address address = new Address(null, ownerDTO.street(), ownerDTO.district(), ownerDTO.houseNumber());
        Pet pet = new Pet(null, ownerDTO.petName(),
                ownerDTO.breed(),
                ownerDTO.dailyTimesToEat(),
                ownerDTO.timeToEat()
                        .stream()
                        .map(LocalTime::parse).collect(Collectors.toList()),
                ownerDTO.observation());
        return new Owner(null, ownerDTO.ownerName(), ownerDTO.mainPhone(), ownerDTO.emergencyPhone(), address, pet);
    }

    public OwnerDTO toOwnerDTO(Owner owner) {
        return new OwnerDTO(owner.getId(),
                owner.getName(),
                owner.getMainPhone(),
                owner.getEmergencyPhone(),
                owner.getAddress().getStreet(),
                owner.getAddress().getDistrict(),
                owner.getAddress().getHouseNumber(),
                owner.getPet().getName(),
                owner.getPet().getBreed(),
                owner.getPet().getDailyTimesToEat(),
                owner.getPet().getTimeToEat().stream().map(LocalTime::toString).collect(Collectors.toList()),
                owner.getPet().getObservation()
        );
    }
}
