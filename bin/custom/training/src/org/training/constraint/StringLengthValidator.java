package org.training.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringLengthValidator implements ConstraintValidator<StringLength, String> {
    private int min;
    private int max;

    @Override
    public void initialize(final StringLength constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
        validateParameters();
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext
            constraintValidatorContext) {
        if (value == null) // According to the JSR 303 null values are valid
        {
            return true;
        }
        final int length = value.length();
        return length >= min && length <= max;
    }

    private void validateParameters() {
        if (min < 0) {
            throw new IllegalArgumentException("The min parameter cannot be negative.");
        }
        if (max < 0) {
            throw new IllegalArgumentException("The max parameter cannot be negative.");
        }
        if (max < min) {
            throw new IllegalArgumentException("The length cannot be negative.");
        }
    }
}