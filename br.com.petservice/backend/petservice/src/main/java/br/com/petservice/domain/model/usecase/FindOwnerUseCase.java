package br.com.petservice.domain.model.usecase;

import br.com.petservice.domain.model.FindOwner;
import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.persistence.repositories.OwnerRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindOwnerUseCase implements FindOwner {

    private final OwnerRepository ownerRepository;
    @Override
    public List<Owner> findAll() {
    return ownerRepository.findAll();
    }
}
