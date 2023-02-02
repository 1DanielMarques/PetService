package br.com.petservice.dto;

import br.com.petservice.annotations.PhoneLength;



public record OwnerDTO(Long id, String name, @PhoneLength String mainPhone, @PhoneLength String emergencyPhone, String street, String district, int houseNumber) {
}

