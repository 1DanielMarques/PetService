package br.com.petservice.infra.config;

import br.com.petservice.infra.persistence.repositories.*;
import br.com.petservice.infra.persistence.repositories.inMemory.AddressInMemoryRepository;
import br.com.petservice.infra.persistence.repositories.inMemory.OwnerInMemoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringContextConfig {

    private final OwnerInMemoryRepository ownerRepository;

    private final AddressInMemoryRepository addressRepository;

    @Bean
    public OwnerRepositoryImpl ownerRepository() {
        return new OwnerRepositoryImpl(ownerRepository);
    }

    @Bean
    public AddressRepositoryImpl addressRepository() {
        return new AddressRepositoryImpl(addressRepository);
    }

}
