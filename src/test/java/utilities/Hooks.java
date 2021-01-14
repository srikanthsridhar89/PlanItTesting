	package utilities;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import pom.LoginPage;


    public class Hooks  {
	
	


	static WebDriver driver;
	static SelCommands sel = new SelCommands(driver);


	@Before
	public void createfun() throws InterruptedException, FileNotFoundException {
	//	Scenario.usercreatesscenariowithsimplestring();
		SelCommands.openbrowser(JsonReader.readJson("env", "url"));
		LoginPage.loginDetails(JsonReader.readJson("env", "Username"), JsonReader.readJson("env", "Password"));
		LoginPage.clickSignin();
	}
	
	

}
