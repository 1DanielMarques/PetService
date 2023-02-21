package br.com.petservice.infra.config;

import br.com.petservice.infra.persistence.repositories.*;
import br.com.petservice.infra.persistence.repositories.inMemory.AddressInMemoryRepository;
import br.com.petservice.infra.persistence.repositories.inMemory.OwnerInMemoryRepository;
import br.com.petservice.infra.persistence.repositories.inMemory.PetInMemoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PersistenceContextConfig {

    private final OwnerInMemoryRepository ownerRepository;

    private final AddressInMemoryRepository addressRepository;
    private final PetInMemoryRepository petRepository;

    @Bean
    public OwnerRepository ownerRepository() {
        return new OwnerRepositoryImpl(ownerRepository);
    }

    @Bean
    public AddressRepository addressRepository() {
        return new AddressRepositoryImpl(addressRepository);
    }

    @Bean
    public PetRepository petRepository() {
        return new PetRepositoryImpl(petRepository);
    }
}
