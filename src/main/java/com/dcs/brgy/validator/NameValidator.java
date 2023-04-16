package com.dcs.brgy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.dcs.brgy.util.RegexHelper;
import com.dcs.brgy.validator.annotation.NameConstraint;

public class NameValidator extends BRGYValidator implements ConstraintValidator<NameConstraint, String>{

	@SuppressWarnings("null")
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();
		// TODO Auto-generated method stub
		if ((value.length() < 0) || (value.length() > 50)) {
			context.buildConstraintViolationWithTemplate("Length must be greater than 0 and less than 50").addConstraintViolation();
			return false;
		}
		if(isNotEmptyOrNull(value) && !value.matches(RegexHelper.REGEX_NAME)) {
			context.buildConstraintViolationWithTemplate("{invalid.char}").addConstraintViolation();
			return false;
		}
		return true;
	}

}
