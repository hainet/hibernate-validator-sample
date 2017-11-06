package com.hainet.hibernate.validator.sample.internal;

import com.hainet.hibernate.validator.sample.ValidatedBean;
import com.hainet.hibernate.validator.sample.constraints.Same;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class SameConstraintValidator implements ConstraintValidator<Same, Object> {

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

        try {
            Class<ValidatedBean> validatedBeanClass = ValidatedBean.class;
            Field sourceField = validatedBeanClass.getDeclaredField(sourceFieldName);
            Field targetField = validatedBeanClass.getDeclaredField(targetFieldName);

            sourceField.setAccessible(true);
            targetField.setAccessible(true);

            ValidatedBean bean = (ValidatedBean) value;
            return sourceField.get(bean).equals(targetField.get(bean));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
