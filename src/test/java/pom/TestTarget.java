package pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.listener.Reporter;

import junit.framework.Assert;
import utilities.Selcommands;

public class TestTarget  extends Selcommands {

	public TestTarget(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	 
	
public static void usernavigatestotesttargettab() throws InterruptedException {
		Thread.sleep(4000);
		By HomeDropDown=By.xpath("//button[@id='bdd_menu_trigger_button_id']");
		By Setting=By.xpath("//a[contains(text(),'Settings')]");
		By TestTarget_Tab=By.xpath("//a[text()='Test Targets']");
		
		click(HomeDropDown, " Home Drop Down");
		click(Setting, " Setting");
		click(TestTarget_Tab, " TestTarget Tab");

		
	}





public static void userclicksonupdatetesttarget() {
	
	By UpdateTestTarget=By.xpath("//button[text()='Update Test Target']");
	click(UpdateTestTarget, "Update TestTarget");
}




public static void userupdatedtesttargetdetails(String name) {
	
	By Namefield=By.xpath("//input[@id='name']");
	
	
	   type(Namefield, name, "Name Field");
	   
	   click(Namefield, "Namefield");
	   
	   By Hostname=By.xpath("//input[@id='host']");
	   
		
	   click(Hostname, "Hostname");
}
	

public static void userredirectstoedittesttargetpage() {
	
	String btn = getElementString(By.xpath("//*[text()='Edit Test Target']"));
	Assert.assertEquals("Edit Test Target", btn);
	Reporter.addStepLog("User Redirects to Edit Test Target Page Successful");
}

public static void userredirectstocreatetesttarget() {
	
	String btn = getElementString(By.xpath("//h2[text()='Create Test Target']"));
	Assert.assertEquals("Create Test Target", btn);
	Reporter.addStepLog("User Redirects to Create Test Target Page Successful");
}
	
	public static void userclicksonaddnewtesttarget() throws InterruptedException {
		Thread.sleep(5000);
		By AddNewTestTarget=By.xpath("//a[contains(@href,'create')]/button[contains(text(),'Target')]");
		click(AddNewTestTarget, " Add New Test Target");
		
	}
	
	

	
	public static void userfillstesttargetdetails(String name,String host,String username,String pwd,String Software) throws InterruptedException {
		
		
		Thread.sleep(4000);
		By Name=By.xpath("//input[@name='name']");
	    type(Name, name, "Name Field");
		
	    
	    By softwaredropdown=By.xpath("//i[@class='dropdown icon']");
	    By DesiredSoftware=By.xpath("//div[contains(text(),'" + Software + "')]");
	    
	    click(softwaredropdown, "Software Drop Down");
	    javascript_click(DesiredSoftware, "Desired Software");
		
		By DesiredHost=By.id("host");
		
		  type(DesiredHost, host, "Host Field");
		  
		  By DesiredUsername=By.id("username");
		  type(DesiredUsername, username, "Username Field");
		  
		  By DesiredPassword=By.id("password");
		  type(DesiredPassword, pwd, "Password Field");
		  
	}
	

	public static void userclicksoncreatetesttarget() {
		
		By CreateTestTarget=By.xpath("//button[contains(text(),'Create Test Target')]");
		  click(CreateTestTarget, "CreateTestTarget");
		
	}
	
	
	public static void userclicksoncancel() {
		By Cancel=By.xpath("//button[contains(text(),'Cancel')]");
		
		  click(Cancel, " Cancel");
		
	}
}