package br.com.petservice.infra.persistence.entities;

import br.com.petservice.domain.model.Pet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "tb_pet")
@AllArgsConstructor
@NoArgsConstructor
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
    private List<LocalTime> timeToEat;

    @Getter
    @Setter
    private String observation;


    public static PetEntity createFromPet(Pet pet) {
        return new PetEntity(pet.getId(), pet.getName(), pet.getBreed(), pet.getDailyTimesToEat(), pet.getTimeToEat(), pet.getObservation());
    }

    public Pet toPetFromEntity() {
        return new Pet(this.getId(), this.getName(), this.getBreed(), this.getDailyTimesToEat(), this.getTimeToEat(), this.getObservation());
    }

    public Pet toPetFromPet(Pet pet) {
        updatePetData(pet);
        return pet;
    }

    private void updatePetData(Pet pet) {
        pet.setId(this.getId());
        pet.setName(this.getName());
        pet.setBreed(this.getBreed());
        pet.setDailyTimesToEat(this.getDailyTimesToEat());
        pet.setTimeToEat(this.getTimeToEat());
        pet.setObservation(this.getObservation());

    }

}
