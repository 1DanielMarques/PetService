package br.com.petservice.infra.config;

import br.com.petservice.infra.persistence.entities.AddressEntity;
import br.com.petservice.infra.persistence.entities.OwnerEntity;
import br.com.petservice.infra.persistence.repositories.AddressRepositoryImpl;
import br.com.petservice.infra.persistence.repositories.InMemoryRepository;
import br.com.petservice.infra.persistence.repositories.OwnerRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringContextConfig {

    private final InMemoryRepository<OwnerEntity> ownerRepository;

    private final InMemoryRepository<AddressEntity> addressRepository;

    @Bean
    public OwnerRepositoryImpl ownerRepository() {
        return new OwnerRepositoryImpl(ownerRepository);
    }

    @Bean
    public AddressRepositoryImpl addressRepository() {
        return new AddressRepositoryImpl(addressRepository);
    }

}
