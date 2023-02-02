package br.com.petservice.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneLengthValidator implements ConstraintValidator<PhoneLength, String> {

    private final int phoneLength = 11;

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        return phoneNumber.length() == phoneLength;
    }
}
