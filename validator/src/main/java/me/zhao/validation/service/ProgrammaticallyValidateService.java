package me.zhao.validation.service;

import me.zhao.validation.param.Input;
import org.hibernate.validator.HibernateValidator;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.*;
import java.util.Set;

@Service
public class ProgrammaticallyValidateService {

    private final Validator validator;

    public ProgrammaticallyValidateService(Validator validator) {
        this.validator = validator;
    }

    public String validateNoSpring(Input input) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Input>> constraintViolations = validator.validate(input);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
        return input.toString();
    }

    public String validateWithSpringValidator(Input input) {
        Set<ConstraintViolation<Input>> constraintViolations = validator.validate(input);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
        return input.toString();
    }

    public String validateFailFast(Input input) {

        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Input>> constraintViolations = validator.validate(input);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
        return input.toString();
    }
}