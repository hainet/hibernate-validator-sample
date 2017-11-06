package com.hainet.hibernate.validator.sample.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
@Size(min = 8, max = 20)
@Pattern(regexp = "[0-9a-z]*")
public @interface Password {

    String message() default "{com.hainet.hibernate.validator.sample.constraints.Password.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
