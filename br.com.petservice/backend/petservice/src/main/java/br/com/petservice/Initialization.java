package br.com.petservice;


import br.com.petservice.infra.persistence.entities.AddressEntity;
import br.com.petservice.infra.persistence.entities.OwnerEntity;
import br.com.petservice.infra.persistence.repositories.inMemory.AddressInMemoryRepository;
import br.com.petservice.infra.persistence.repositories.inMemory.OwnerInMemoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class Initialization implements CommandLineRunner {

    private final AddressInMemoryRepository addressRepository;
    private final OwnerInMemoryRepository ownerRepository;

    @Override
    public void run(String... args) throws Exception {
        AddressEntity address1 = new AddressEntity(null, "Test 1", "Test 1", 1);
        AddressEntity address2 = new AddressEntity(null, "Test 2", "Test 2", 2);
        addressRepository.saveAll(Arrays.asList(address1, address2));

        OwnerEntity owner1 = new OwnerEntity(null, "Daniel", "123", "456", address1);
        OwnerEntity owner2 = new OwnerEntity(null, "Marcos", "321", "654", address2);
        ownerRepository.saveAll(Arrays.asList(owner1, owner2));
    }
}
