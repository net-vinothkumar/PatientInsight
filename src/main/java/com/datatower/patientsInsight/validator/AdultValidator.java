package com.datatower.patientsInsight.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AdultValidator implements ConstraintValidator<Adult, LocalDate> {
    private static final int ADULT_AGE = 18;

    @Override
    public void initialize(Adult adult){
    }

    @Override
    public boolean isValid(LocalDate birthDate, ConstraintValidatorContext constraintValidatorContext) {
        return birthDate != null && LocalDate.now().minusYears(ADULT_AGE).isAfter(birthDate);
    }
}
