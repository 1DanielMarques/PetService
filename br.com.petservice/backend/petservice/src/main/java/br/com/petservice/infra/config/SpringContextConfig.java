package br.com.petservice.infra.config;

import br.com.petservice.infra.persistence.repositories.AddressRepositoryImpl;
import br.com.petservice.infra.persistence.repositories.OwnerRepositoryImpl;
import br.com.petservice.infra.persistence.repositories.PetRepositoryImpl;
import br.com.petservice.infra.persistence.repositories.inMemory.AddressInMemoryRepository;
import br.com.petservice.infra.persistence.repositories.inMemory.OwnerInMemoryRepository;
import br.com.petservice.infra.persistence.repositories.inMemory.PetInMemoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringContextConfig {

    private final OwnerInMemoryRepository ownerRepository;
    private final AddressInMemoryRepository addressRepository;
    private final PetInMemoryRepository petRepository;

    @Bean
    public OwnerRepositoryImpl ownerRepository() {
        return new OwnerRepositoryImpl(ownerRepository);
    }

    @Bean
    public AddressRepositoryImpl addressRepository() {
        return new AddressRepositoryImpl(addressRepository);
    }

    @Bean
    public PetRepositoryImpl petRepository() {
        return new PetRepositoryImpl(petRepository);
    }

}
