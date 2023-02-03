package br.com.petservice.infra.config;

import br.com.petservice.infra.persistence.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringContextConfig {

    private final OwnerInMemoryRepository ownerRepository;

    @Bean
    public OwnerRepositoryImpl ownerRepository() {
        return new OwnerRepositoryImpl(ownerRepository);
    }



}
