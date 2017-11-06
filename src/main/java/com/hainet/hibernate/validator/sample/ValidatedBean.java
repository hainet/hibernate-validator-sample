package com.hainet.hibernate.validator.sample;

import com.hainet.hibernate.validator.sample.constraints.Same;
import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Value
@Same(source = "foo", target = "bar")
public class ValidatedBean {

    @Min(10)
    private int min;

    @Size(min = 5, max = 10)
    private String name;

    private String foo;

    private String bar;
}
