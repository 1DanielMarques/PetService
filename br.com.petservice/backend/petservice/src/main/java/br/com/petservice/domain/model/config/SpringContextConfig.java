package br.com.petservice.domain.model.config;

import br.com.petservice.domain.model.CreateOwner;
import br.com.petservice.domain.model.DeleteOwner;
import br.com.petservice.domain.model.FindOwner;
import br.com.petservice.domain.model.usecase.CreateOwnerUseCase;
import br.com.petservice.domain.model.usecase.DeleteOwnerUseCase;
import br.com.petservice.domain.model.usecase.FindOwnerUseCase;
import br.com.petservice.infra.persistence.repositories.AddressRepository;
import br.com.petservice.infra.persistence.repositories.OwnerRepository;
import br.com.petservice.infra.persistence.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Import(PersistenceContextConfig.class)
@RequiredArgsConstructor
public class SpringContextConfig {

    private final OwnerRepository ownerRepository;
    private final AddressRepository addressRepository;
    private final PetRepository petRepository;

    @Bean
    public CreateOwner createOwner() {
        return new CreateOwnerUseCase(ownerRepository, addressRepository, petRepository);
    }

    @Bean
    public FindOwner findOwner() {
        return new FindOwnerUseCase(ownerRepository);
    }

    @Bean
    public DeleteOwner deleteOwner() {
        return new DeleteOwnerUseCase(ownerRepository, addressRepository, petRepository);
    }


}
