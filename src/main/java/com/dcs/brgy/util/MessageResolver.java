package com.dcs.brgy.util;

import java.text.MessageFormat;

public class MessageResolver {
	
	public static String resolve(String code, Object... args) {
		String mess = PropertyHelper.value(code);
		return MessageFormat.format(mess, args);
	}
}
