package br.com.petservice.infra.services;

import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.persistence.entities.OwnerEntity;
import br.com.petservice.infra.persistence.repositories.AddressRepositoryImpl;
import br.com.petservice.infra.persistence.repositories.OwnerRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        List<OwnerEntity> ownerEntityList = new ArrayList<>();
        for (Object object : ownerRepository.findAll()) {
            OwnerEntity ownerEntity = OwnerEntity.class.cast(object);
            ownerEntityList.add(ownerEntity);
        }
        List<Owner> ownerList = new ArrayList<>();
        for (OwnerEntity ownerEntity : ownerEntityList) {
            ownerList.add(new Owner(ownerEntity.getId(), ownerEntity.getName(), ownerEntity.getMainPhone(), ownerEntity.getEmergencyPhone(), ownerEntity.getAddress().toAddressFromEntity()));
        }
        return ownerList;
    }
}
