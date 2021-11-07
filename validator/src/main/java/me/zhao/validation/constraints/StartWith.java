package me.zhao.validation.constraints;

import me.zhao.validation.validator.StartWithValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = StartWithValidator.class)
public @interface StartWith {

    String value();

    String message() default "{me.zhao.validator.constraints.StartWith.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}