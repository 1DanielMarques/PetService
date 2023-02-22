package br.com.petservice;


import br.com.petservice.infra.persistence.entities.AddressEntity;
import br.com.petservice.infra.persistence.entities.OwnerEntity;
import br.com.petservice.infra.persistence.entities.PetEntity;
import br.com.petservice.infra.persistence.repositories.inMemory.AddressInMemoryRepository;
import br.com.petservice.infra.persistence.repositories.inMemory.OwnerInMemoryRepository;
import br.com.petservice.infra.persistence.repositories.inMemory.PetInMemoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class Initialization implements CommandLineRunner {

    private final AddressInMemoryRepository addressRepository;
    private final OwnerInMemoryRepository ownerRepository;
    private final PetInMemoryRepository petRepository;

    @Override
    public void run(String... args) throws Exception {
        AddressEntity address1 = new AddressEntity(null, "Test 1", "Test 1", 1);
        AddressEntity address2 = new AddressEntity(null, "Test 2", "Test 2", 2);

        PetEntity pet1 = new PetEntity(null, "Pet 1", "Raca 1", 4, Arrays.asList(LocalTime.now()), "Nothing 1");
        PetEntity pet2 = new PetEntity(null, "Pet 2", "Raca 2", 5, Arrays.asList(LocalTime.now()), "Nothing 2");

        OwnerEntity owner1 = new OwnerEntity(null, "Daniel", "123", "456", address1, pet1);
        OwnerEntity owner2 = new OwnerEntity(null, "Marcos", "321", "654", address2, pet2);
        ownerRepository.saveAll(Arrays.asList(owner1, owner2));


    }
}
