package br.com.petservice.infra.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "tb_owner")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OwnerEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 11)
    private String mainPhone;

    @Column(length = 11)
    private String emergencyPhone;

    @OneToOne
    private AddressEntity address;


}
