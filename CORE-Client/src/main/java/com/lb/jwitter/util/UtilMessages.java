package com.lb.jwitter.util;

import java.util.Properties;

public class UtilMessages {

	public static Properties properties;
		
	// Cheating spring to set a static property.
	public static Properties setInstance(Properties propertiesArgs) {
		properties = propertiesArgs;
		return properties;
	}

	public static String getMsg(String key) {
		return properties.getProperty(key);
	}
}
