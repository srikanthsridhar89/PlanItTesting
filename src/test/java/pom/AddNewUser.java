package pom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import junit.framework.Assert;
import utilities.SelCommands;

public class AddNewUser extends SelCommands {

	public AddNewUser(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public static void userNavigatesToUserTab() {
		
		By HomeDropDown=By.xpath("//button[@id='bdd_menu_trigger_button_id']");
		By Setting=By.xpath("//a[contains(text(),'Settings')]");
		By User_Tab=By.xpath("//a[contains(text(),'Users')]");
		
		click(HomeDropDown, "Home Drop Down");
		click(Setting, "Setting");
		click(User_Tab, "User Tab");

		
	}
	
	
	
	public static void userRedirectsToCreateUser() {
		
		String btn = getElementString(By.xpath("//h2[text()='Create User']"));
		Assert.assertEquals("Create User", btn);
		Reporter.addStepLog("User Redirects to Create User Page Successfully");
		
		
		
	}
	
	
	public static void editUserDetails() throws IOException {
		By Role_DropDown=By.xpath("//div[contains(@class,'roles_drop_down')]");
		By DesiredRole=By.xpath("//div[contains(text(),'admin')]");
		By Label_Role=By.xpath("//label[text()='Roles']");
		
		
		click(Role_DropDown, "Role Drop Down");
		click(DesiredRole, "Desired Roles Which is Admin");
		click(Label_Role, "Desired Label");
		SelCommands.captureScreenshot();
		
	}
	
	
	public static void clickUpdateUser() {
		By Update_User=By.xpath("//button[@type='submit']");
		click(Update_User, "Updated User");

		
		
	}
	
	
	
	
		
	
	public static void userclicksonaddnewuser() throws InterruptedException {
	Thread.sleep(5000);
		By AddNewUser=By.xpath("//button[text()='Add New User']");
		
		click(AddNewUser, "Add New User");
		
		}
	
	
	
	
	public static void userenterdetails(String name, String email) {
		
		
		
		By txtfieldName=By.xpath("//input[@placeholder='Name']");
		By txtfieldEmail=By.xpath("//input[@name='email']");
		By SelectRoles=By.xpath("//div[@class='form-group select-form-group']/label/following::div[1]");
		By Role=By.xpath("//div[contains(text(),'developer')]");
		By LabelRole=By.xpath("//label[text()='Roles']");
		
		
		
		type(txtfieldName, name, "Name Field");
		
		type(txtfieldEmail, email, "Email Field");
		click(SelectRoles, "Desired Role DropDown");
		
		click(Role, "Desired Role");
		
		click(LabelRole, " Label Role");
		
		
		
	
	}
	
	
	public static void userclicksoncreatenewuser() {
		By CreateNewUser=By.xpath("//button[@type='submit']");
		
			
		click(CreateNewUser, "CreateNewUser");

	}


	public static void userclicksondeleteuser() {
		// TODO Auto-generated method stub
		By DeleteUser=By.xpath("//td[contains(text(),'TestAuto@test.com')]/following::*[@id='deleteUserById'][1]");
		click(DeleteUser, "User Deleted the  Record");
	}
		
	}
	
	

