package br.com.petservice.infra.services;

import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.dto.OwnerDTO;
import br.com.petservice.infra.persistence.entities.OwnerEntity;
import br.com.petservice.infra.persistence.repositories.AddressRepositoryImpl;
import br.com.petservice.infra.persistence.repositories.OwnerRepositoryImpl;
import br.com.petservice.infra.persistence.repositories.PetRepositoryImpl;
import br.com.petservice.infra.resource.assembler.OwnerAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepositoryImpl ownerRepository;
    private final AddressRepositoryImpl addressRepository;
    private final PetRepositoryImpl petRepository;
    private final OwnerAssembler assembler;

    public OwnerDTO insert(OwnerDTO ownerDTO) {
        Owner owner = assembler.toOwner(ownerDTO);
        owner.setAddress(addressRepository.save(owner.getAddress()));
        owner.setPet(petRepository.save(owner.getPet()));
        ownerRepository.save(owner);
        return assembler.toOwnerDTO(owner);
    }

    public List<OwnerDTO> findAll() {
        List<OwnerDTO> ownerDTOList = getAllOwners().stream()
                .map(owner -> new OwnerDTO(owner.getId(),
                        owner.getName(),
                        owner.getMainPhone(),
                        owner.getEmergencyPhone(),
                        owner.getAddress().getStreet(),
                        owner.getAddress().getDistrict(),
                        owner.getAddress().getHouseNumber(),
                        owner.getPet().getName(),
                        owner.getPet().getBreed(),
                        owner.getPet().getDailyTimesToEat(),
                        owner.getPet().getTimeToEat().stream().map(time -> time.toString()).collect(Collectors.toList()),
                        owner.getPet().getObservation())).collect(Collectors.toList());
        return ownerDTOList;
    }

    public OwnerDTO findById(Long id) {
        return assembler.toOwnerDTO(ownerRepository.findById(id));
    }


    private List<Owner> getAllOwners() {
        return ownerRepository.findAll()
                .stream()
                .map(object -> OwnerEntity.class.cast(object))
                .map(entity -> entity.toOwnerFromEntity()).
                collect(Collectors.toList());
    }


    public void deleteById(Long id){

    }
}
