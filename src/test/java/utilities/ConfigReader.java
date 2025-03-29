package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	static Properties prop;

	public static void ReadDataFromConfig() throws IOException {

		prop = new Properties();
		FileInputStream fis;
		fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//resources//config.properties");
		prop.load(fis);

	}

	public static String getUrl(String key) {
		String url = prop.getProperty(key);
		System.out.println("url" + url);
		return url;

	}

}
