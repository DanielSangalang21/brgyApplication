package com.dcs.brgy.util;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:messages.properties")
public class PropertyHelper implements EnvironmentAware{
	
	private static Environment env;
	
	/**
	 * get properties from file via filename
	 * @param propName = name of the property in properties file
	 */
	public static String value(String propName) {
		return env.getProperty(propName);
	}
	
	@Override
	public void setEnvironment(Environment environment) {
		env = environment;
	}
}
