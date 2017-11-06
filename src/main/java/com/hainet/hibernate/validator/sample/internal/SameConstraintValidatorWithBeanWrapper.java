package com.hainet.hibernate.validator.sample.internal;

import com.hainet.hibernate.validator.sample.constraints.Same;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SameConstraintValidatorWithBeanWrapper implements ConstraintValidator<Same, Object> {

    private String sourceFieldName;
    private String targetFieldName;

    @Override
    public void initialize(Same constraintAnnotation) {
        sourceFieldName = constraintAnnotation.source();
        targetFieldName = constraintAnnotation.target();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        BeanWrapper beanWrapper = new BeanWrapperImpl(value);
        String sourceField = (String) beanWrapper.getPropertyValue(sourceFieldName);
        String targetField = (String) beanWrapper.getPropertyValue(targetFieldName);

        return sourceField.equals(targetField);
    }
}
