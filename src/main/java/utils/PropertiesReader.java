
package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	private static Properties properties;

	private static String configFile = "./src/main/resources/config.properties";

	public static String getProperty(String key) {
		properties = new Properties();
		try (FileInputStream inputStream = new FileInputStream(configFile)) {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

}
