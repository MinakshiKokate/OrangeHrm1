package Com.OrangeHrm.Utile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;

public class PropertiesUtile {

	public static String getProperty(String filepath, String key) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);

	}

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\lannistaer\\eclipse-workspace\\ minakshi\\Framework\\src\\test\\resources\\Proprties\\Locators.Properties");
		Properties prop = new Properties();
		prop.load(fis);

		String value = prop.getProperty("sumbit");
		System.out.println(value);
	}

}
