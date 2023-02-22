package br.com.petservice.domain.usecase;

import br.com.petservice.domain.FindOwner;
import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.persistence.repositories.OwnerRepository;
import br.com.petservice.infra.resource.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class FindOwnerUseCase implements FindOwner {

    private final OwnerRepository ownerRepository;

    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner findById(Long id) {
        try {
            return ownerRepository.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
