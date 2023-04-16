package com.dcs.brgy.util;

public abstract class StringHelper {
	public boolean isNotEmptyOrNull(String string) {
		 return !(string == null || string.isEmpty() || string.trim().isEmpty());
	 }
}
