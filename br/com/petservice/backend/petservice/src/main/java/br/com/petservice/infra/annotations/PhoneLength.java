package br.com.petservice.infra.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneLengthValidator.class)
public @interface PhoneLength {

    String message() default "Phone number must have 11 digits.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
