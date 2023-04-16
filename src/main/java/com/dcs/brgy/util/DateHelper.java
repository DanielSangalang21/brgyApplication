package com.dcs.brgy.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

	//YYYY-MM-DD hh:mm:ss sql server and Java.util.Date compliant format
	public String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat ("YYYY-MM-DD hh:mm:ss");
		return sdf.format(date);
	}
}
