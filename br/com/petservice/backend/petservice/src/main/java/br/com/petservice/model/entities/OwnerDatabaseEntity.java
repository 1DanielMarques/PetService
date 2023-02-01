package br.com.petservice.model.entities;

import br.com.petservice.model.annotations.PhoneLength;
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
public class OwnerDatabaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 11)
    @PhoneLength
    private String main_phone;

    @Column(length = 11)
    @PhoneLength
    private String emergency_phone;

}
