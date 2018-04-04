package com.codesquad.library.domain.constraints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ReviewScoreValidator implements ConstraintValidator<ReviewScore, Float> {

    @Override
    public void initialize(ReviewScore constraintAnnotation) {

    }

    @Override
    public boolean isValid(Float value, ConstraintValidatorContext constraintValidatorContext) {
        return value % 0.5F == 0;
    }
}
