package br.com.petservice.infra.resource.controllers;

import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.dto.OwnerDTO;
import br.com.petservice.infra.resource.assembler.OwnerAssembler;
import br.com.petservice.infra.services.OwnerService;
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
    private final OwnerService service;

    @PostMapping
    ResponseEntity<OwnerDTO> insert(@RequestBody @Validated OwnerDTO ownerDTO) {
        Owner owner = service.insert(assembler.toOwner(ownerDTO));
        return ResponseEntity.ok().body(assembler.toOwnerDTO(owner));
    }

}
