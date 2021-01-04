package pom;


import bean.TestTargetConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	//	By TestTarget_Tab=By.xpath("//a[text()='Test Targets']");
		By TestTarget_Tab=By.xpath("//a[@id='TestTargets']");
		
		
		try {
			click(HomeDropDown, " Home Drop Down");
			click(Setting, " Setting");
			click(TestTarget_Tab, " TestTarget Tab");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.quit();
		}

		
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
	
	

	
	public static void userfillswfdtesttargetdetails(TestTargetConfig testTargetConfig, String software) throws InterruptedException {
		
		Thread.sleep(4000);
		By Name=By.xpath("//input[@name='name']");
		type(Name, testTargetConfig.getTestTargetWFDName(), "Name Field");
		By softwaredropdown=By.xpath("//i[@class='dropdown icon']");
		By DesiredSoftware=By.xpath("//div[contains(text(),'" + software + "')]");
		click(softwaredropdown, "Software Drop Down");
		javascript_click(DesiredSoftware, "Desired Software");
		By DesiredAppKey=By.id("appKey");
		type(DesiredAppKey, testTargetConfig.getTestTargetAppkey(), "AppKey Field");
		By DesiredHost=By.id("host");
		type(DesiredHost, testTargetConfig.getTestTargetWFDHost(), "Host Field");
		By DesiredUsername=By.id("username");
		type(DesiredUsername, testTargetConfig.getTestTargetUserName(), "Username Field");
		By DesiredPassword=By.id("password");
		type(DesiredPassword, testTargetConfig.getTestTargetPassword(), "Password Field");
		By DesiredClientID=By.id("clientId");
		type(DesiredClientID, testTargetConfig.getTestTargetClientId(), "Client ID Field");
		By DesiredClientSecret=By.id("clientSecret");
		type(DesiredClientSecret, testTargetConfig.getTestTargetClientSecret(), "client Secret Field");
		By DesiredSftpHost=By.id("sftpHost");
		type(DesiredSftpHost, testTargetConfig.getTestTargetSFTPHost(), "SFTP Host Field");
		By DesiredSftpUserName=By.id("sftpUsername");
		type(DesiredSftpUserName, testTargetConfig.getTestTargetSFTPUserName(), "SFTP UserName Field");
		By DesiredSftpPassword=By.id("sftpPassword");
		type(DesiredSftpPassword, testTargetConfig.getTestTargetSFTPPassword(), "SFTP Password Field");
		By DesiredSftpPort=By.id("sftpPort");
		type(DesiredSftpPort, testTargetConfig.getTestTargetSFTPPort(), "SFTP Port Field");
		By DesiredPGPublicKey=By.id("pgpPublicKey");
		type(DesiredPGPublicKey, testTargetConfig.getTestTargetPGPublicKey(), "SFTP Port Field");
	}

	public static void userfillswfctesttargetdetails(TestTargetConfig testTargetConfig, String software) throws InterruptedException {

		Thread.sleep(4000);
		By Name=By.xpath("//input[@name='name']");
		type(Name, testTargetConfig.getTestTargetWFCName(), "Name Field");
		By softwaredropdown=By.xpath("//i[@class='dropdown icon']");
		By DesiredSoftware=By.xpath("//div[contains(text(),'" + software + "')]");
		click(softwaredropdown, "Software Drop Down");
		javascript_click(DesiredSoftware, "Desired Software");
		By DesiredHost=By.id("host");
		type(DesiredHost, testTargetConfig.getTestTargetWFCHost(), "Host Field");
		By DesiredUsername=By.id("username");
		type(DesiredUsername, testTargetConfig.getTestTargetWFCUserName(), "Username Field");
		By DesiredPassword=By.id("password");
		type(DesiredPassword, testTargetConfig.getTestTargetWFCPassword(), "Password Field");
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