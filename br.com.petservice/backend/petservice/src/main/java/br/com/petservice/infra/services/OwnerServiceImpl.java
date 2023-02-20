package br.com.petservice.infra.services;

import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.dto.OwnerDTO;
import br.com.petservice.infra.persistence.entities.OwnerEntity;
import br.com.petservice.infra.persistence.repositories.AddressRepositoryImpl;
import br.com.petservice.infra.persistence.repositories.OwnerRepositoryImpl;
import br.com.petservice.infra.persistence.repositories.PetRepositoryImpl;
import br.com.petservice.infra.resource.assembler.OwnerAssembler;
import br.com.petservice.infra.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService{

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
                        owner.getPet().getTimeToEat().stream().map(LocalTime::toString).collect(Collectors.toList()),
                        owner.getPet().getObservation())).collect(Collectors.toList());
        return ownerDTOList;
    }

    public OwnerDTO findById(Long id) {
        try {
            return assembler.toOwnerDTO(ownerRepository.findById(id));
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(id);
        }
    }


    private List<Owner> getAllOwners() {
        return ownerRepository.findAll()
                .stream()
                .map(object -> OwnerEntity.class.cast(object))
                .map(OwnerEntity::toOwnerFromEntity).
                collect(Collectors.toList());
    }

    public OwnerDTO updateById(Long id, OwnerDTO ownerDTO) {
        try {
            Owner updatedOwner = ownerRepository.findById(id);
            updateOwnerData(updatedOwner, ownerDTO);
            addressRepository.save(updatedOwner.getAddress());
            petRepository.save(updatedOwner.getPet());
            ownerRepository.save(updatedOwner);
            return assembler.toOwnerDTO(updatedOwner);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateOwnerData(Owner updatedOwner, OwnerDTO ownerDTO) {
        updatedOwner.setName(ownerDTO.ownerName());
        updatedOwner.setMainPhone(ownerDTO.mainPhone());
        updatedOwner.setEmergencyPhone(ownerDTO.emergencyPhone());

        updatedOwner.getAddress().setStreet(ownerDTO.street());
        updatedOwner.getAddress().setDistrict(ownerDTO.district());
        updatedOwner.getAddress().setHouseNumber(ownerDTO.houseNumber());

        updatedOwner.getPet().setName(ownerDTO.petName());
        updatedOwner.getPet().setBreed(ownerDTO.breed());
        updatedOwner.getPet().setDailyTimesToEat(ownerDTO.dailyTimesToEat());
        updatedOwner.getPet().setTimeToEat(ownerDTO.timeToEat()
                .stream()
                .map(LocalTime::parse)
                .collect(Collectors.toList()));
        updatedOwner.getPet().setObservation(ownerDTO.observation());
    }


    public void deleteById(Long id) {
        try {
            Long petId = ownerRepository.findById(id).getPet().getId();
            Long addressId = ownerRepository.findById(id).getAddress().getId();
            ownerRepository.delete(id);
            petRepository.delete(petId);
            addressRepository.delete(addressId);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(id);
        }

    }
}
