package com.dcs.brgy.util;


public class RegexHelper {
	public final static String REGEX_NAME = "^[A-Za-z- ]+$";
	public final static String REGEX_ACCOUNT = "^[\\d-]+$";
	public final static String REGEX_ADDRESS = "^[A-Za-z0-9 -]+$";
	public final static String REGEX_NUMONLY ="^[0-9]+$";
	public final static String REGEX_ALPHAONLY ="^[A-Za-z]+$";
	public final static String REGEX_GENDER = "F|M";
	public final static String REGEX_MONTHLY_GROSS = "[1-5]";
	public final static String REGEX_MONEY = "^\\d{0,9}(\\.\\d{1,2})?$";
	public final static String REGEX_ALPHANUM = "^[A-Za-z0-9]+$";
	public final static String REGEX_DATE = "^(1[0-2]|0[1-9])\\/(3[01]|[12][0-9]|0[1-9])\\/[0-9]{4}$";
	public final static String REGEX_EMAIL = "^[_A-Za-z0-9\\-]+(\\.[_A-Za-z0-9\\-]+)*@[A-Za-z0-9\\-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public final static String REGEX_IDNO = "^[A-Za-z0-9 -]+$";
}
