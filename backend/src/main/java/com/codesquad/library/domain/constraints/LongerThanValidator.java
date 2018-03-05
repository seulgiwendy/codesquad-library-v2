package com.codesquad.library.domain.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LongerThanValidator implements ConstraintValidator<LongerThan, String> {

    @Override
    public void initialize(LongerThan constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.length() > 7;
    }
}
