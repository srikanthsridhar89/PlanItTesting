package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesReader
{

	static String filePath = new String("testconfig.properties");
	public static String propertiesWriter(String filePath, String num) throws IOException{
		Properties properties = new Properties();
		InputStream input = new FileInputStream(filePath); 
		OutputStream os = new FileOutputStream(filePath);
		properties.load(input);
		input.close();
		properties.setProperty("sequence", "");
		properties.store(os, null);
		os.close();	

	return "";
	}

	public static String propertiesReader(String propertyKey) throws FileNotFoundException
	{
		Properties properties = new Properties();
		InputStream input = new FileInputStream(filePath);
		String propertyValue = new String();
		try
		{
			properties.load(input);
			propertyValue = properties.getProperty(propertyKey);

		} catch (Exception e) {

		}

		return propertyValue;
	}



	public static String getURL() throws FileNotFoundException {
		return new String(propertiesReader("testEnvironmentPath"));
	}




}