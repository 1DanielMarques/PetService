package br.com.petservice.domain.usecase;

import br.com.petservice.domain.DeleteOwner;
import br.com.petservice.infra.persistence.repositories.OwnerRepository;
import br.com.petservice.infra.resource.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class DeleteOwnerUseCase implements DeleteOwner {

    private final OwnerRepository ownerRepository;

    @Override
    public void deleteById(Long id) {
        try {
            ownerRepository.delete(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
