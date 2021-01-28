package pom;


import bean.TestTargetConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import junit.framework.Assert;
import utilities.SelCommands;

public class TestTarget  extends SelCommands {

	private static By homeDropDown =By.xpath("//button[@id='bdd_menu_trigger_button_id']");
	private static By settings =By.xpath("//a[contains(text(),'Settings')]");
	private static By testTargetTab =By.xpath("//a[@id='TestTargets']");
	private static By updateTestTarget =By.xpath("//button[text()='Update Test Target']");
	private static By nameField =By.xpath("//input[@id='name']");
	private static By addNewTestTarget =By.xpath("//a[contains(@href,'create')]/button[contains(text(),'Target')]");
	private static By name =By.xpath("//input[@name='name']");
	private static By softwareDropdown =By.xpath("//i[@class='dropdown icon']");
	private static By desiredAppKey =By.id("appKey");
	private static By desiredHost =By.id("host");
	private static By desiredUsername =By.id("username");
	private static By desiredPassword =By.id("password");
	private static By desiredClientID =By.id("clientId");
	private static By desiredClientSecret =By.id("clientSecret");
	private static By desiredSftpHost =By.id("sftpHost");
	private static By desiredSftpUserName =By.id("sftpUsername");
	private static By desiredSftpPassword =By.id("sftpPassword");
	private static By desiredSftpPort =By.id("sftpPort");
	private static By desiredPGPublicKey =By.id("pgpPublicKey");
	private static By createTestTarget =By.xpath("//button[contains(text(),'Create Test Target')]");
	private static By cancel =By.xpath("//button[contains(text(),'Cancel')]");

	public TestTarget(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void userNavigatesToTestTargetTab() throws InterruptedException {
		Thread.sleep(4000);
		try {
			click(homeDropDown, " Home Drop Down");
			click(settings, " Setting");
			click(testTargetTab, " TestTarget Tab");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.quit();
		}
	}

	public static void userClicksOnUpdateTestTarget() {
		click(updateTestTarget, "Update TestTarget");
	}

	public static void userUpdatedTestTargetDetails(String name) {
		type(nameField, name, "Name Field");
		click(nameField, "Namefield");
		click(desiredHost, "Hostname");
	}


	public static void userRedirectsToEditTestTargetPage() {
		String btn = getElementString(By.xpath("//*[text()='Edit Test Target']"));
		Assert.assertEquals("Edit Test Target", btn);
		Reporter.addStepLog("User Redirects to Edit Test Target Page Successful");
	}

	public static void userRedirectsToCreateTestTarget() {
		String btn = getElementString(By.xpath("//h2[text()='Create Test Target']"));
		Assert.assertEquals("Create Test Target", btn);
		Reporter.addStepLog("User Redirects to Create Test Target Page Successful");
	}

	public static void userClicksOnAddNewTestTarget() throws InterruptedException {
		Thread.sleep(5000);
		click(addNewTestTarget, " Add New Test Target");
	}

	public static void userFillsWFDTestTargetDetails(TestTargetConfig testTargetConfig, String software) throws InterruptedException {

		Thread.sleep(4000);
		type(name, testTargetConfig.getTestTargetWFDName(), "Name Field");
		By DesiredSoftware=By.xpath("//div[contains(text(),'" + software + "')]");
		click(softwareDropdown, "Software Drop Down");
		javascript_click(DesiredSoftware, "Desired Software");
		type(desiredAppKey, testTargetConfig.getTestTargetAppkey(), "AppKey Field");
		type(desiredHost, testTargetConfig.getTestTargetWFDHost(), "Host Field");
		type(desiredUsername, testTargetConfig.getTestTargetUserName(), "Username Field");
		type(desiredPassword, testTargetConfig.getTestTargetPassword(), "Password Field");
		type(desiredClientID, testTargetConfig.getTestTargetClientId(), "Client ID Field");
		type(desiredClientSecret, testTargetConfig.getTestTargetClientSecret(), "client Secret Field");
		type(desiredSftpHost, testTargetConfig.getTestTargetSFTPHost(), "SFTP Host Field");
		type(desiredSftpUserName, testTargetConfig.getTestTargetSFTPUserName(), "SFTP UserName Field");
		type(desiredSftpPassword, testTargetConfig.getTestTargetSFTPPassword(), "SFTP Password Field");
		type(desiredSftpPort, testTargetConfig.getTestTargetSFTPPort(), "SFTP Port Field");
		type(desiredPGPublicKey, testTargetConfig.getTestTargetPGPublicKey(), "SFTP Port Field");
	}

	public static void userFillsWFCTestTargetDetails(TestTargetConfig testTargetConfig, String software) throws InterruptedException {

		Thread.sleep(4000);
		type(name, testTargetConfig.getTestTargetWFCName(), "Name Field");
		By DesiredSoftware=By.xpath("//div[contains(text(),'" + software + "')]");
		click(softwareDropdown, "Software Drop Down");
		javascript_click(DesiredSoftware, "Desired Software");
		type(desiredHost, testTargetConfig.getTestTargetWFCHost(), "Host Field");
		type(desiredUsername, testTargetConfig.getTestTargetWFCUserName(), "Username Field");
		type(desiredPassword, testTargetConfig.getTestTargetWFCPassword(), "Password Field");
	}

	public static void userClicksOnCreateTestTarget() {
		click(createTestTarget, "CreateTestTarget");

	}

	public static void userClicksOnCancel() {
		click(cancel, " Cancel");
	}
}