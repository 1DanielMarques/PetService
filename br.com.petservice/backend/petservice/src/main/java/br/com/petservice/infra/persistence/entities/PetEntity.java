package br.com.petservice.infra.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "tb_pet")
@AllArgsConstructor
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String breed;

    @Getter
    @Setter
    private int dailyTimesToEat;

    @Getter
    @Setter
    private LocalTime timeToEat;

    @Getter
    @Setter
    private String observation;
}
