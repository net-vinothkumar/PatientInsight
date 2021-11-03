package com.datatower.patientsInsight.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = {AdultValidator.class})
@Documented
public @interface Adult {
    String message() default "Patient should be older than 18 years.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
