package com.hainet.hibernate.validator.sample;

import com.hainet.hibernate.validator.sample.constraints.Password;
import com.hainet.hibernate.validator.sample.constraints.Same;
import lombok.Value;

import javax.validation.constraints.*;

@Same(source = "foo", target = "bar")
@Value
public class ValidatedBean {

    @Min(10)
    private int min;

    @Size(min = 5, max = 10)
    private String name;

    @Password
    private String password;

    private String foo;

    private String bar;

    @NotNull
    private String notNUll;

    @NotEmpty
    private String notEmpty;

    @NotBlank
    private String notBlank;
}
