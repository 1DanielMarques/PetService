package br.com.petservice.infra.resource.controllers;

import br.com.petservice.infra.resource.assembler.OwnerAssembler;
import br.com.petservice.infra.dto.OwnerDTO;
import br.com.petservice.infra.persistence.entities.OwnerEntity;
import br.com.petservice.infra.persistence.repositories.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/owner")
@RequiredArgsConstructor
public class OwnerResource {

    private final OwnerAssembler assembler;
    private final OwnerRepository repository;

    @PostMapping
    ResponseEntity<OwnerDTO> insert(@RequestBody @Validated OwnerDTO ownerDTO) {
        OwnerEntity owner = repository.save(assembler.toOwnerEntity(ownerDTO));
        return ResponseEntity.ok().body(assembler.toOwnerDTO(owner));
    }

}
