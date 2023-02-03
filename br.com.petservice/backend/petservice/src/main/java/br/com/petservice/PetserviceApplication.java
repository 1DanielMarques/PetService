package br.com.petservice;

import br.com.petservice.infra.persistence.repositories.OwnerRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PetserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetserviceApplication.class, args);
	}

}
