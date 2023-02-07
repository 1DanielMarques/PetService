package br.com.petservice.infra.resource.controllers;

import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.dto.OwnerDTO;
import br.com.petservice.infra.resource.assembler.OwnerAssembler;
import br.com.petservice.infra.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/owner")
@RequiredArgsConstructor
public class OwnerResource {

    private final OwnerAssembler assembler;
    private final OwnerService service;

    @GetMapping
    ResponseEntity<List<OwnerDTO>> findAll() {
        List<OwnerDTO> ownerDTOList = new ArrayList<>();
        for (Owner owner : service.findAll()) {
            OwnerDTO ownerDTO = new OwnerDTO(owner.getId(), owner.getName(), owner.getMainPhone(), owner.getEmergencyPhone(), owner.getAddress().getStreet(), owner.getAddress().getDistrict(), owner.getAddress().getHouseNumber());
            ownerDTOList.add(ownerDTO);
        }
        return ResponseEntity.ok().body(ownerDTOList);
    }

    @PostMapping
    ResponseEntity<OwnerDTO> insert(@RequestBody @Validated OwnerDTO ownerDTO) {
        Owner owner = service.insert(assembler.toOwner(ownerDTO));
        return ResponseEntity.ok().body(assembler.toOwnerDTO(owner));
    }

}
