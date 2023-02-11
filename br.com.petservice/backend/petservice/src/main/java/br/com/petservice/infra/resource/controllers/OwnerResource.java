package br.com.petservice.infra.resource.controllers;

import br.com.petservice.infra.dto.OwnerDTO;
import br.com.petservice.infra.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/owner")
@RequiredArgsConstructor
public class OwnerResource {

    private final OwnerService service;

    @PostMapping
    ResponseEntity<OwnerDTO> insert(@RequestBody @Validated OwnerDTO requestDTO) {
        OwnerDTO ownerDTO = service.insert(requestDTO);
        return ResponseEntity.ok().body(ownerDTO);
    }

    @GetMapping
    ResponseEntity<List<OwnerDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OwnerDTO> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<OwnerDTO> updateById(@PathVariable(value = "id") Long id){

        return null;
    }


}
