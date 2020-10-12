package utils.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataBaseProperties {
	public static final String RESOURCE_URL = "C:\\Users\\Dzungg\\workspace\\finaltest\\src\\main\\java\\resources\\ConfigDataBase.properties";
	private Properties pr;
	
	public DataBaseProperties() throws FileNotFoundException, IOException {
		pr = new Properties();
		pr.load(new FileInputStream(RESOURCE_URL));
	}
	
	public String getProperty(String key) {
		return pr.getProperty(key);
	}
	
}