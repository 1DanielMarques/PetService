package br.com.petservice.infra.services;

import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.persistence.entities.OwnerEntity;
import br.com.petservice.infra.persistence.repositories.AddressRepositoryImpl;
import br.com.petservice.infra.persistence.repositories.OwnerRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepositoryImpl ownerRepository;
    private final AddressRepositoryImpl addressRepository;

    public Owner insert(Owner owner) {
        owner.setAddress(addressRepository.save(owner.getAddress()));
        return ownerRepository.save(owner);
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
                        entity.getAddress().toAddressFromEntity())).
                collect(Collectors.toList());
    }
}
