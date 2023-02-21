package br.com.petservice.domain.usecase;

import br.com.petservice.domain.CreateOwner;
import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.persistence.repositories.AddressRepository;
import br.com.petservice.infra.persistence.repositories.OwnerRepository;
import br.com.petservice.infra.persistence.repositories.PetRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateOwnerUseCase implements CreateOwner {
    private final OwnerRepository ownerRepository;
    private final AddressRepository addressRepository;
    private final PetRepository petRepository;


    @Override
    public Owner create(Owner owner) {
        owner.setAddress(addressRepository.save(owner.getAddress()));
        owner.setPet(petRepository.save(owner.getPet()));
        ownerRepository.save(owner);
        return owner;
    }
}
