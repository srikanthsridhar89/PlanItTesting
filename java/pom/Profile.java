package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import junit.framework.Assert;
import utilities.Selcommands;

public class Profile extends Selcommands{
	public Profile(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	} 
	
	public static void usernavigatesprofile() {

		By Setting=By.xpath("//button[@id='bdd_menu_trigger_button_id']");
		By Profile=By.xpath("//a[text()='Profile']");
		click(Setting, "Setting");
		click(Profile, "Profile");
		
	}
	
	
	public static void userclicksonsubmit() {
		
		By Submit=By.xpath("//button[text()='Submit'] ");
		click(Submit, "Submit");
	}
	
	public static void userinputs_emailrecovery(String Emailaddress) {
		
		By EmailField=By.xpath("//input[@name='email']");
		
		type(EmailField, Emailaddress, "Email Address Recovery");
	}
	
	
	
	
public static void verifyforgotpasswordpage() throws InterruptedException {
		
		Thread.sleep(6000);
		String btn = getElementString(By.xpath("//*[text()='Forgot password']"));
		Assert.assertEquals("Forgot password", btn);
		Reporter.addStepLog("Forgot Password verification is successful");
		
	}
	
	public static void userclicksonforgotpassword() {
		
		By PasswordLink=By.xpath("//a[text()='Forgot password?']");
		click(PasswordLink, "PasswordLink");
	}
	
	public static void userverifyprofilepage() throws InterruptedException {
		
		Thread.sleep(6000);
		String button = getElementString(By.xpath("//h3[text()='Profile']"));
		
		Assert.assertEquals("Profile", button);
		Reporter.addStepLog("Profile verification is successful");
	}
	public static void userfillspassworddetailfields(String newpassword,String Confirmpassword,String currentpassword) {
		

		By CurrentPwd=By.xpath("//input[@id='pwd-existing']");
		By NewPwd=By.xpath("//input[@id='pwd-new']");
		By ConfirmPwd=By.xpath("//input[@id='pwd-confirmation']");
		
		
		type(CurrentPwd, currentpassword, "username");
		type(NewPwd, newpassword, "NewPasword");
		type(ConfirmPwd, Confirmpassword, "Confirm Password");
		
		
	}
	

}
