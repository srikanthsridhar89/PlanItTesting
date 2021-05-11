	package utilities;

import java.io.FileNotFoundException;

import bean.EnvironmentConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;



    public class Hooks  {
	static WebDriver driver;
	static SelCommands sel = new SelCommands(driver);
	private EnvironmentConfig environmentConfig = new EnvironmentConfig();

	public Hooks() {
		ObjectMapper obj = new ObjectMapper();
		try {
			environmentConfig = obj.readValue(JsonReader.getFile("EnvironmentConfig"), EnvironmentConfig.class);
		}catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	

}
