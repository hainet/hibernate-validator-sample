package com.hainet.hibernate.validator.sample;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ValidatedBean bean = new ValidatedBean(
                1,
                "12345678901",
                "foo",
                "bar");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ValidatedBean>> constraintViolations = validator.validate(bean);

        Iterator<ConstraintViolation<ValidatedBean>> iterator = constraintViolations.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getMessage());
        }
    }
}
