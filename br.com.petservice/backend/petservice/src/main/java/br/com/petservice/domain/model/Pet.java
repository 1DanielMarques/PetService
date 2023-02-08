package br.com.petservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@AllArgsConstructor
@Data
public class Pet {

    private Long id;
    private String name;
    private String breed;
    private int dailyTimesToEat;
    private LocalTime timeToEat;
    private String observation;

}
