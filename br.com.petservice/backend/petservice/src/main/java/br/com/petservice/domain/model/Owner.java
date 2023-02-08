package br.com.petservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Owner {

    private Long id;
    private String name;
    private String mainPhone;
    private String emergencyPhone;
    private Address address;
}
