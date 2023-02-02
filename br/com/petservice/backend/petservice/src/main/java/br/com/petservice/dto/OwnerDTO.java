package br.com.petservice.dto;

import br.com.petservice.annotations.PhoneLength;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class OwnerDTO {
    private Long id;
    private String name;

    @PhoneLength
    private String mainPhone;
    @PhoneLength
    private String emergencyPhone;

}
