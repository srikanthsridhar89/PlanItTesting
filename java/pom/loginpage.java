	package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.cucumber.listener.Reporter;

import junit.framework.Assert;
import utilities.Selcommands;

public class loginpage extends Selcommands{
	public loginpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public static void logindetails(String username, String pwd) {
		//enterText(By.xpath("//input[@id='email']"), username);
		//enterText(By.id("password"), pwd);
		
		By UserName=By.xpath("//input[@id='email']");
		By Password=By.id("password");
		
		
		
		type(UserName, username, "User Name Field");
		
		type(Password, pwd, "Password Field");
		
		//captureScreenshot("loginpage");
		
		
	}
	
	public static void click_Signin() {
		
		By SignIn=By.id("signIn");
		click(SignIn, "Sign In");

	}
	
	
	public static void click_logout() {
		
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



/*
 * driver.findElement(")).sendKeys(Username); test.log(Status.INFO,
 * "Entered Username as "+Username);
 * 
 * driver.findElement(By.id("password")).sendKeys(Password);
 * test.log(Status.INFO, "User Entered Password as" +Password);
 * driver.findElement(By.id("signIn")).click(); test.log(Status.INFO,
 * "User Clicked on SignIn");
 */
