package com.dcs.brgy.validator.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.dcs.brgy.validator.FileValidator2;
import com.dcs.brgy.validator.NameValidator;

@Documented
@Constraint(validatedBy = FileValidator2.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface FileConstraint {
	String message() default "Invalid File";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
