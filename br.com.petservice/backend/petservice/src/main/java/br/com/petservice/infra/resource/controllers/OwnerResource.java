package br.com.petservice.infra.resource.controllers;

import br.com.petservice.domain.CreateOwner;
import br.com.petservice.domain.DeleteOwner;
import br.com.petservice.domain.FindOwner;
import br.com.petservice.domain.UpdateOwner;
import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.dto.OwnerDTO;
import br.com.petservice.infra.resource.assembler.OwnerAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/owner")
@RequiredArgsConstructor
public class OwnerResource {
    private final CreateOwner createOwner;
    private final FindOwner findOwner;
    private final DeleteOwner deleteOwner;
    private final UpdateOwner updateOwner;
    private final OwnerAssembler assembler;


    @PostMapping
    ResponseEntity<OwnerDTO> insert(@RequestBody @Validated OwnerDTO requestDTO) {
        Owner owner = createOwner.create(assembler.toOwner(requestDTO));
        return ResponseEntity.ok().body(assembler.toOwnerDTO(owner));
    }

    @GetMapping
    ResponseEntity<List<OwnerDTO>> findAll() {
        return ResponseEntity.ok().body(findOwner.findAll().stream().map(owner -> assembler.toOwnerDTO(owner)).collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OwnerDTO> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(assembler.toOwnerDTO(findOwner.findById(id)));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id) {
        deleteOwner.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<OwnerDTO> updateById(@PathVariable(value = "id") Long id, @RequestBody @Validated OwnerDTO requestDTO) {
        return ResponseEntity.ok().body(assembler.toOwnerDTO(updateOwner.updateById(id, assembler.toOwner(requestDTO))));
    }


}
