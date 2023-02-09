package br.com.petservice.infra.dto;

import br.com.petservice.infra.annotations.PhoneLength;

import java.util.List;


public record OwnerDTO(Long id,
                       String ownerName,
                       @PhoneLength String mainPhone,
                       @PhoneLength String emergencyPhone,
                       String street, String district,
                       int houseNumber,
                       String petName,
                       String breed,
                       int dailyTimesToEat,
                       List<String> timeToEat,
                       String observation) {
}

