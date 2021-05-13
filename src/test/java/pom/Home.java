package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import utilities.SelCommands;

public class Home extends SelCommands {
	
	


	private static By homePageTitle = By.xpath("//title[text()='Jupiter Toys']");
	

	
	public Home(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
 
	
	
	public static void verify_login() {

		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(homePageTitle));
			String homePageTitleText = driver.getTitle();

			if (homePageTitleText.equals("Jupiter Toys")) {
				Reporter.addStepLog("User is in home page after successfully logged in");
			} else {
				Reporter.addStepLog("User is not in home page after successfully logged in");

			}
			captureScreenshot("Login Verification");

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
