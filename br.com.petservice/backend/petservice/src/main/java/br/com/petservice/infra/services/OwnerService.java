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

    public List<Owner> findAll() {
        List<Owner> ownerList = getAllOwners();
        return ownerList;
    }


    private List<Owner> getAllOwners() {
        return ownerRepository.findAll()
                .stream()
                .map(object -> OwnerEntity.class.cast(object))
                .map(entity -> new Owner(entity.getId(),
                        entity.getName(),
                        entity.getMainPhone(),
                        entity.getEmergencyPhone(),
                        entity.getAddress().toAddressFromEntity(), entity.getPet().toPetFromEntity())).
                collect(Collectors.toList());
    }
}
