package com.dcs.brgy.validator;

public abstract class BRGYValidator {
 public boolean isNotEmptyOrNull(String string) {
	 return !(string == null || string.isEmpty() || string.trim().isEmpty());
 }
}
