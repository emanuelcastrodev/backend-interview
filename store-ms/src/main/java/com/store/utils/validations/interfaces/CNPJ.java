package com.store.utils.validations.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.store.utils.validations.CNPJValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CNPJValidator.class)
public @interface CNPJ {
	String message() default "Invalid CNPJ field.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
