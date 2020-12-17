	package utilities;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import pom.loginpage;
import com.cucumber.listener.Reporter;


public class Hooks  {
	
	


	static WebDriver driver;
	static Selcommands sel = new Selcommands(driver);


	@Before
	public void createfun() throws InterruptedException, FileNotFoundException {
	//	Scenario.usercreatesscenariowithsimplestring();
		Selcommands.openbrowser(JsonReader.readJson("env", "url"));
		loginpage.logindetails(JsonReader.readJson("env", "Username"), JsonReader.readJson("env", "Password"));
		loginpage.click_Signin();
	}
	
	

}
