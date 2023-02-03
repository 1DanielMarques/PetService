package br.com.petservice.infra.dto;

import br.com.petservice.infra.annotations.PhoneLength;



public record OwnerDTO(Long id, String name, @PhoneLength String mainPhone, @PhoneLength String emergencyPhone, String street, String district, int houseNumber) {
}

