package pom;

import bean.TestSuiteConfig;
import com.aventstack.extentreports.model.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cucumber.listener.Reporter;
import junit.framework.Assert;
import utilities.SelCommands;

public class TestSuite extends SelCommands {

	public TestSuite(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void userClicksOnRegressionTestSuite() {
		WebDriverWait wait = new WebDriverWait(driver, 240);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Regression Test Suites']")));
		By Regression_Suite = By.xpath("//h3[text()='Regression Test Suites']");
		driver.findElement(Regression_Suite).click();
		Reporter.addStepLog("User Clicked on Regression Test Suite");
	}

	
	public static void userSelectDesiredTestSuiteCreated() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 240);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Automation WFD')]")));
		By TestSuiteCreated = By.xpath("//a[contains(text(),'Automation WFD')]");
		driver.findElement(TestSuiteCreated).click();

	}

	public static void userClickNewTestSuite() throws InterruptedException {
		Thread.sleep(4000);
		By CreateNewTestSuite = By.xpath("//button[text()='CREATE NEW TEST SUITE']");
		javascript_click(CreateNewTestSuite, "Create New Test Suite");

	}

	public static void userRedirectsToUpdateTestSuitePage() {

		String title = getElementString(By.xpath("//div[text()='Update Test Suite']"));

		Assert.assertEquals("Update Test Suite", title);
		Reporter.addStepLog("User Redirects to UpdateTestSuite Successful");

	}

	public static void userRedirectsToCreateTestSuite() {

		String btn = getElementString(By.xpath("//div[text()='Create Test Suite']"));
		Assert.assertEquals("Create Test Suite", btn);
		Reporter.addStepLog("User Redirects to Create TestSuite Page Successful");

	}

	public static void userClicksOnAddNewTestSuite() throws InterruptedException {
		Thread.sleep(4000);
		By AddNewTestSuite = By.xpath(
				"//div[@class='projects-add-new-btn btn-header ta-form']/div/span/button[contains(text(),'ADD NEW TEST SUITE')]");
		click(AddNewTestSuite, "Add TestSuite button");

	}

	public static void userClicksOnTestSuiteSettings() throws InterruptedException {
		Thread.sleep(5000);
		By HomeDropDown = By.xpath("//button[@id='bdd_menu_trigger_button_id']");
		By TestSuiteSetting = By.xpath("//a[text()='Test Suite Settings']");
		click(HomeDropDown, "Home Drop Down");
		click(TestSuiteSetting, "TestSuiteSetting");
	}

	public static void userClicksOnDeleteTestSuite() {

		By DeleteTestSuite = By.xpath("//span[contains(text(),'DELETE TEST SUITE')]");
		click(DeleteTestSuite, "Delete Test Suite");


	}

	public static void userUpdatesTestSuiteDetails(String title) {
		By InputTitle = By.xpath("//input[@name='PROJECT_TITLE']");
		type(InputTitle, title, "Title Field");

	}

	public static void userClicksOnUpdateTestSuite() {

		By UpdateTestSuite = By.xpath("//button[@label='UPDATE TEST SUITE']");
		click(UpdateTestSuite, "UpdateTestSuite");
	}

	public static void userClicksOnCancel() {

		By Cancel = By.xpath("//span[text()='CANCEL']");
		click(Cancel, "Cancel button");
	}

	public static void enterAddTestSuiteDetailsWithWFCVersion(TestSuiteConfig testSuiteConfig,
															  String WorkforceCentralVersion) throws InterruptedException {

		Thread.sleep(4000);
		By InputTitle = By.xpath("//input[@name='PROJECT_TITLE']");
		By InputDescription = By.xpath("//textarea[@id='PROJECT_DESCRIPTION']");
		By TestSuiteVendor = By.xpath("//div[@id='PROJECT_VENDOR']/div");
		By SelectVendor = By.xpath("//div[contains(text(),'Kronos')]");

		By TestActionLibrary = By.xpath("//div[@id='PROJECT_SOFTWARE']/div");
		By SelectActionLibrary = By.xpath("//div[contains(text(),'Workforce Central')]");

		By ProjectVersion = By.xpath("//div[@id='PROJECT_VERSION']/div");
		By SelectProjectVersion = By.xpath("//div[contains(text(),'" + WorkforceCentralVersion + "')]");

		By TestTarget = By.xpath("//div[@id='PROJECT_TEST_TARGET']/div");
		By SelectTarget = By.xpath("//div[contains(text(),'WFC Dev')]");

		By TestSuitePurpose = By.xpath("//div[@id='PROJECT_PRUPOSE']/div");
		By SelectPurpose = By.xpath("//div[contains(text(),'Regression Testing')]");

		By Roles = By.xpath("//div[@id='PROJECT_ROLES']/div");
		By SelectRoles = By.xpath("//div[contains(text(),'developer')]");

		type(InputTitle, testSuiteConfig.getTestSuiteWFCTitle(), "Title Field");
		type(InputDescription, testSuiteConfig.getTestWFCDescription(), "Description Field");

		click(TestSuiteVendor, " Vendor DropDown");
		click(SelectVendor, "Desired Vendor as Kronos");
		click(TestActionLibrary, "TestActionLibrary DropDown");
		click(SelectActionLibrary, "Desired Action library as Workforce Central");

		click(ProjectVersion, "Project Version Dropdown");

		click(SelectProjectVersion, "Desired Project Version : '" + WorkforceCentralVersion + "'");

		click(TestTarget, "TestTarget Dropdown");
		click(SelectTarget, "Desired TestTarget ");
		click(TestSuitePurpose, "TestSuitePurpose Dropdown");
		click(SelectPurpose, "Desired Purpose As Functional Testing");
		click(Roles, "Roles Dropdown");
		click(SelectRoles, "Desired Roles as Developer");

	}

	public static void enterAddTestSuiteDetailsWithWFDVersion(TestSuiteConfig testSuiteConfig,
															  String WorkforceDimensionsversion) throws InterruptedException {

		Thread.sleep(4000);
		By InputTitle = By.xpath("//input[@name='PROJECT_TITLE']");
		By InputDescription = By.xpath("//textarea[@id='PROJECT_DESCRIPTION']");
		By TestSuiteVendor = By.xpath("//div[@id='PROJECT_VENDOR']/div");
		By SelectVendor = By.xpath("//div[contains(text(),'Kronos')]");

		By TestActionLibrary = By.xpath("//div[@id='PROJECT_SOFTWARE']/div");
		By SelectActionLibrary = By.xpath("//div[contains(text(),'Workforce Dimensions Timekeeping')]");

		By ProjectVersion = By.xpath("//div[@id='PROJECT_VERSION']/div");
		By SelectProjectVersion = By.xpath("//div[contains(text(),'" + WorkforceDimensionsversion + "')]");

		By TestTarget = By.xpath("//div[@id='PROJECT_TEST_TARGET']/div");
		By SelectTarget = By.xpath("//div[contains(text(),'Test Kronos Tenant w/ Boomi')]");

		By TestSuitePurpose = By.xpath("//div[@id='PROJECT_PRUPOSE']/div");
		By SelectPurpose = By.xpath("//div[contains(text(),'Regression Testing')]");

		By Roles = By.xpath("//div[@id='PROJECT_ROLES']/div");
		By SelectRoles = By.xpath("//div[contains(text(),'developer')]");

		type(InputTitle, testSuiteConfig.getTestSuiteWFDTitle(), "Title Field");
		type(InputDescription, testSuiteConfig.getTestWFDDescription(), "Description Field");

		click(TestSuiteVendor, " Vendor DropDown");
		click(SelectVendor, "Desired Vendor as Kronos");
		click(TestActionLibrary, "TestActionLibrary DropDown");
		click(SelectActionLibrary, "Desired Action library As Workforce Dimensions Timekeeping");

		click(ProjectVersion, "Project Version Dropdown");

		click(SelectProjectVersion, "Desired Project Version : '" + WorkforceDimensionsversion + "'");

		click(TestTarget, "TestTarget Dropdown");
		click(SelectTarget, "Desired TestTarget as Test Kronos Tenant w/ Boomi ");

		click(TestSuitePurpose, "TestSuitePurpose Dropdown");
		click(SelectPurpose, "Desired Purpose As Functional Testing");

		click(Roles, "Roles Dropdown");
		click(SelectRoles, "Desired Roles as Developer");

	}

	public static void enterAddTestSuiteDetails(TestSuiteConfig testSuiteConfig, String typetesting)
			throws InterruptedException {

		Thread.sleep(4000);
		By InputTitle = By.xpath("//input[@name='PROJECT_TITLE']");
		By InputDescription = By.xpath("//textarea[@id='PROJECT_DESCRIPTION']");
		By TestSuiteVendor = By.xpath("//div[@id='PROJECT_VENDOR']/div");
		By SelectVendor = By.xpath("//div[contains(text(),'Kronos')]");

		By TestActionLibrary = By.xpath("//div[@id='PROJECT_SOFTWARE']/div");
		By SelectActionLibrary = By.xpath("//div[contains(text(),'Workforce Dimensions Timekeeping')]");

		By ProjectVersion = By.xpath("//div[@id='PROJECT_VERSION']/div");
		By SelectProjectVersion = By.xpath("//div[contains(text(),'R1')]");


		By TestTarget = By.xpath("//div[@id='PROJECT_TEST_TARGET']/div");
		By SelectTarget = By.xpath("//div[contains(text(),'Test Kronos Tenant w/ Boomi')]");

		By TestSuitePurpose = By.xpath("//div[@id='PROJECT_PRUPOSE']/div");
		By SelectPurpose = By.xpath("//div[contains(text(),'" + typetesting + "')]");

		By Roles = By.xpath("//div[@id='PROJECT_ROLES']/div");
		By SelectRoles = By.xpath("//div[contains(text(),'developer')]");

		type(InputTitle, testSuiteConfig.getTestSuiteWFDTitle(), "Title Field");
		type(InputDescription, testSuiteConfig.getTestWFDDescription(), "Description Field");

		click(TestSuiteVendor, " Vendor DropDown");
		click(SelectVendor, "Desired Vendor as Kronos");
		click(TestActionLibrary, "TestActionLibrary DropDown");
		click(SelectActionLibrary, "Desired Action library As Workforce Central");

		click(ProjectVersion, "Project Version Dropdown");

		click(SelectProjectVersion, "Desired Project Version as R1");

		click(TestTarget, "TestTarget Dropdown");
		click(SelectTarget, "Desired TestTarget as WFC Dev ");

		click(TestSuitePurpose, "TestSuitePurpose Dropdown");
		click(SelectPurpose, "Desired Purpose As " + typetesting);

		click(Roles, "Roles Dropdown");
		click(SelectRoles, "Desired Roles as Developer");

	}

}
