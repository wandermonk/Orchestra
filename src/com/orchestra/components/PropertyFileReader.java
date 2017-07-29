package com.orchestra.components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertyFileReader {

	private final Properties props = new Properties();

	private PropertyFileReader() {
		String filePath = new File("").getAbsolutePath();

		FileInputStream file;

		try {
			file = new FileInputStream(filePath + "/config/config.properties");
			props.load(file);
		} catch (IOException e) {
			
		}
	}

	private static class PropHolder {
		private static final PropertyFileReader INSTANCE = new PropertyFileReader();
	}

	public static PropertyFileReader getInstance() {
		return PropHolder.INSTANCE;
	}

	public String getProperty(String key) {
		return props.getProperty(key);
	}

	public Set<String> getAllPropertyNames() {
		return props.stringPropertyNames();
	}

	public boolean containsKey(String key) {
		return props.containsKey(key);
	}
}