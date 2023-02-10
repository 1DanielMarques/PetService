package br.com.petservice.infra.resource.controllers;

import br.com.petservice.domain.model.Owner;
import br.com.petservice.infra.dto.OwnerDTO;
import br.com.petservice.infra.resource.assembler.OwnerAssembler;
import br.com.petservice.infra.services.OwnerService;
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

    private final OwnerService service;

    @PostMapping
    ResponseEntity<OwnerDTO> insert(@RequestBody @Validated OwnerDTO requestDTO) {
        OwnerDTO ownerDTO = service.insert(requestDTO);
        return ResponseEntity.ok().body(ownerDTO);
    }

    @GetMapping
    ResponseEntity<List<OwnerDTO>> findAll() {
        List<OwnerDTO> ownerDTOList = service.findAll()
                .stream()
                .map(owner -> new OwnerDTO(owner.getId(),
                        owner.getName(),
                        owner.getMainPhone(),
                        owner.getEmergencyPhone(),
                        owner.getAddress().getStreet(),
                        owner.getAddress().getDistrict(),
                        owner.getAddress().getHouseNumber(),
                        owner.getPet().getName(),
                        owner.getPet().getBreed(),
                        owner.getPet().getDailyTimesToEat(),
                        owner.getPet().getTimeToEat().stream().map(time -> time.toString()).collect(Collectors.toList()),
                        owner.getPet().getObservation())).collect(Collectors.toList());
        return ResponseEntity.ok().body(ownerDTOList);
    }

}
