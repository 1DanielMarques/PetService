package br.com.petservice.infra.services;

import br.com.petservice.infra.dto.OwnerDTO;

import java.util.List;

public interface OwnerService {

    OwnerDTO insert(OwnerDTO ownerDTO);

    List<OwnerDTO> findAll();

    OwnerDTO findById(Long id);

    OwnerDTO updateById(Long id, OwnerDTO ownerDTO);

    void deleteById(Long id);

}
