package me.zhao.validation.validator;

import me.zhao.validation.constraints.StartWith;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithValidator implements ConstraintValidator<StartWith, String> {

    private StartWith startWith;

    @Override
    public void initialize(StartWith constraintAnnotation) {
        startWith = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.startsWith(startWith.value());
    }
}