	package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import junit.framework.Assert;
import utilities.SelCommands;

public class LoginPage extends SelCommands {
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public static void loginDetails(String username, String pwd) {
		By UserName=By.xpath("//input[@id='email']");
		By Password=By.id("password");
		
		
		
		type(UserName, username, "User Name Field");
		
		type(Password, pwd, "Password Field");
		
		//captureScreenshot("loginpage");
		
		
	}
	
	public static void clickSignin() {
		
		By SignIn=By.id("signIn");
		click(SignIn, "Sign In");

	}
	
	
	public static void clickLogout() {
		
		By HomeDropDown=By.xpath("//button[@id='bdd_menu_trigger_button_id']");
		By Logout=By.xpath("//a[text()='Log Out']");
		click(HomeDropDown, "User Clicked on Home Dropw Down");
		click(Logout, "User Clicked on Logout");
	}
	
	public static void verifyLogin() throws InterruptedException {
		
		driver.navigate().refresh();
		String btn = getElementString(By.cssSelector(".projects-add-new-btn.btn-header button"));
		Assert.assertEquals("ADD NEW TEST SUITE", btn);
		Reporter.addStepLog("login verification is successful");
		
	}

}

