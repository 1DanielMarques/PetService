package br.com.petservice.domain.usecase;

import br.com.petservice.domain.CreateOwner;
import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.persistence.repositories.OwnerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateOwnerUseCase implements CreateOwner {
    private final OwnerRepository ownerRepository;

    @Override
    public Owner create(Owner owner) {
        ownerRepository.save(owner);
        return owner;
    }
}
