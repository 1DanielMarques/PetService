package br.com.petservice.domain.config;

import br.com.petservice.domain.CreateOwner;
import br.com.petservice.domain.DeleteOwner;
import br.com.petservice.domain.FindOwner;
import br.com.petservice.domain.UpdateOwner;
import br.com.petservice.domain.usecase.CreateOwnerUseCase;
import br.com.petservice.domain.usecase.DeleteOwnerUseCase;
import br.com.petservice.domain.usecase.FindOwnerUseCase;
import br.com.petservice.domain.usecase.UpdateOwnerUseCase;
import br.com.petservice.infra.persistence.repositories.AddressRepository;
import br.com.petservice.infra.persistence.repositories.OwnerRepository;
import br.com.petservice.infra.persistence.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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

    @Bean
    public UpdateOwner updateOwner() {
        return new UpdateOwnerUseCase(ownerRepository, addressRepository, petRepository);
    }


}
