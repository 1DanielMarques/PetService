package br.com.petservice.domain.model.usecase;

import br.com.petservice.domain.model.DeleteOwner;
import br.com.petservice.infra.persistence.repositories.AddressRepository;
import br.com.petservice.infra.persistence.repositories.OwnerRepository;
import br.com.petservice.infra.persistence.repositories.PetRepository;
import br.com.petservice.infra.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class DeleteOwnerUseCase implements DeleteOwner {

    private final OwnerRepository ownerRepository;
    private final AddressRepository addressRepository;
    private final PetRepository petRepository;

    @Override
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
