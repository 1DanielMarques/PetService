package br.com.petservice.infra.services;

import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.persistence.repositories.AddressRepositoryImpl;
import br.com.petservice.infra.persistence.repositories.OwnerRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepositoryImpl ownerRepository;
    private final AddressRepositoryImpl addressRepository;

    public Owner insert(Owner owner) {
        owner.setAddress(addressRepository.save(owner.getAddress()));
        return ownerRepository.save(owner);
    }
}
