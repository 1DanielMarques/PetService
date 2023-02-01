package br.com.petservice.model.annotations;

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

    String message() default "Numero de contato inválido.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
