package br.com.petservice.domain.usecase;

import br.com.petservice.domain.UpdateOwner;
import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.persistence.repositories.AddressRepository;
import br.com.petservice.infra.persistence.repositories.OwnerRepository;
import br.com.petservice.infra.persistence.repositories.PetRepository;
import br.com.petservice.infra.resource.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class UpdateOwnerUseCase implements UpdateOwner {
    private final OwnerRepository ownerRepository;
    private final AddressRepository addressRepository;
    private final PetRepository petRepository;

    @Override
    public Owner updateById(Long id, Owner updatedOwner) {
        try {
            Owner ownerToUpdate = ownerRepository.findById(id);
            updateOwnerData(ownerToUpdate, updatedOwner);
            addressRepository.save(ownerToUpdate.getAddress());
            petRepository.save(ownerToUpdate.getPet());
            ownerRepository.save(ownerToUpdate);
            return ownerToUpdate;
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateOwnerData(Owner ownerToUpdate, Owner updatedOwner) {
        ownerToUpdate.setName(updatedOwner.getName());
        ownerToUpdate.setMainPhone(updatedOwner.getMainPhone());
        ownerToUpdate.setEmergencyPhone(updatedOwner.getEmergencyPhone());

        ownerToUpdate.getAddress().setStreet(updatedOwner.getAddress().getStreet());
        ownerToUpdate.getAddress().setDistrict(updatedOwner.getAddress().getDistrict());
        ownerToUpdate.getAddress().setHouseNumber(updatedOwner.getAddress().getHouseNumber());

        ownerToUpdate.getPet().setName(updatedOwner.getPet().getName());
        ownerToUpdate.getPet().setBreed(updatedOwner.getPet().getBreed());
        ownerToUpdate.getPet().setDailyTimesToEat(updatedOwner.getPet().getDailyTimesToEat());
        ownerToUpdate.getPet().setTimeToEat(updatedOwner.getPet().getTimeToEat());
        ownerToUpdate.getPet().setObservation(updatedOwner.getPet().getObservation());
    }

}
