package com.hainet.hibernate.validator.sample.constraints;

import com.hainet.hibernate.validator.sample.internal.SameConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {SameConstraintValidator.class})
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Same {

    String message() default "{com.hainet.hibernate.validator.sample.constraints.Same.message}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String source();
    String target();
}
