package com.dcs.brgy.util;

public class HTMLEntityConverter
{
	public static String decode(String str)
	{
		return str
				.replaceAll("&#96;", "`")
				.replaceAll("&#61;", "=")
				.replaceAll("&#37;", "%")
				.replaceAll("&amp;", "&")
				.replaceAll("&#35;", "#")
				.replaceAll("&quot;", "\"")
				.replaceAll("&#39;", "'")
				.replaceAll("&gt;", ">")
				.replaceAll("&lt;", "<");
	}
}