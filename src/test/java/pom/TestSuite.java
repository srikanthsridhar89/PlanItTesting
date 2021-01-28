package pom;

import bean.TestSuiteConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cucumber.listener.Reporter;
import junit.framework.Assert;
import utilities.SelCommands;

public class TestSuite extends SelCommands {

	private static By regressionSuite = By.xpath("//h3[text()='Regression Test Suites']");
	private static By testSuiteCreated = By.xpath("//a[contains(text(),'Automation WFD')]");
	private static By createNewTestSuite = By.xpath("//button[text()='CREATE NEW TEST SUITE']");
	private static By addNewTestSuite = By.xpath(
			"//div[@class='projects-add-new-btn btn-header ta-form']/div/span/button[contains(text(),'ADD NEW TEST SUITE')]");
	private static By homeDropDown = By.xpath("//button[@id='bdd_menu_trigger_button_id']");
	private static By testSuiteSetting = By.xpath("//a[text()='Test Suite Settings']");
	private static By deleteTestSuite = By.xpath("//span[contains(text(),'DELETE TEST SUITE')]");
	private static By inputTitle = By.xpath("//input[@name='PROJECT_TITLE']");
	private static By updateTestSuite = By.xpath("//button[@label='UPDATE TEST SUITE']");
	private static By inputDescription = By.xpath("//textarea[@id='PROJECT_DESCRIPTION']");
	private static By testSuiteVendor = By.xpath("//div[@id='PROJECT_VENDOR']/div");
	private static By selectVendor = By.xpath("//div[contains(text(),'Kronos')]");
	private static By testActionLibrary = By.xpath("//div[@id='PROJECT_SOFTWARE']/div");
	private static By wfcActionLibrary = By.xpath("//div[contains(text(),'Workforce Central')]");
	private static By projectVersion = By.xpath("//div[@id='PROJECT_VERSION']/div");
	private static By testTarget = By.xpath("//div[@id='PROJECT_TEST_TARGET']/div");
	private static By selectWFCTarget = By.xpath("//div[contains(text(),'WFC Dev')]");
	private static By testSuitePurpose = By.xpath("//div[@id='PROJECT_PRUPOSE']/div");
	private static By selectPurpose = By.xpath("//div[contains(text(),'Regression Testing')]");
	private static By roles = By.xpath("//div[@id='PROJECT_ROLES']/div");
	private static By selectRoles = By.xpath("//div[contains(text(),'developer')]");
	private static By wfdActionLibrary = By.xpath("//div[contains(text(),'Workforce Dimensions Timekeeping')]");
	private static By selectWFDTarget = By.xpath("//div[contains(text(),'Test Kronos Tenant w/ Boomi')]");


	public TestSuite(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void userClicksOnRegressionTestSuite() {
		WebDriverWait wait = new WebDriverWait(driver, 240);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Regression Test Suites']")));
		driver.findElement(regressionSuite).click();
		Reporter.addStepLog("User Clicked on Regression Test Suite");
	}


	public static void userSelectDesiredTestSuiteCreated() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 240);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Automation WFD')]")));
		driver.findElement(testSuiteCreated).click();
	}

	public static void userClickNewTestSuite() throws InterruptedException {
		Thread.sleep(4000);
		javascript_click(createNewTestSuite, "Create New Test Suite");
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
		click(addNewTestSuite, "Add TestSuite button");
	}

	public static void userClicksOnTestSuiteSettings() throws InterruptedException {
		Thread.sleep(5000);
		click(homeDropDown, "Home Drop Down");
		click(testSuiteSetting, "TestSuiteSetting");
	}

	public static void userClicksOnDeleteTestSuite() {
		click(deleteTestSuite, "Delete Test Suite");
	}

	public static void userUpdatesTestSuiteDetails(String title) {
		type(inputTitle, title, "Title Field");
	}

	public static void userClicksOnUpdateTestSuite() {
		click(updateTestSuite, "UpdateTestSuite");
	}

	public static void userClicksOnCancel() {

		By Cancel = By.xpath("//span[text()='CANCEL']");
		click(Cancel, "Cancel button");
	}

	public static void enterAddTestSuiteDetailsWithWFCVersion(TestSuiteConfig testSuiteConfig,
															  String WorkforceCentralVersion) throws InterruptedException {

		Thread.sleep(4000);
		type(inputTitle, testSuiteConfig.getTestSuiteWFCTitle(), "Title Field");
		type(inputDescription, testSuiteConfig.getTestWFCDescription(), "Description Field");
		click(testSuiteVendor, " Vendor DropDown");
		click(selectVendor, "Desired Vendor as Kronos");
		click(testActionLibrary, "TestActionLibrary DropDown");
		click(wfcActionLibrary, "Desired Action library as Workforce Central");
		click(projectVersion, "Project Version Dropdown");
		By SelectProjectVersion = By.xpath("//div[contains(text(),'" +WorkforceCentralVersion+ "')]");
		click(SelectProjectVersion, "Desired Project Version : '" + WorkforceCentralVersion + "'");
		click(testTarget, "TestTarget Dropdown");
		click(selectWFCTarget, "Desired TestTarget ");
		click(testSuitePurpose, "TestSuitePurpose Dropdown");
		click(selectPurpose, "Desired Purpose As Functional Testing");
		click(roles, "Roles Dropdown");
		click(selectRoles, "Desired Roles as Developer");

	}

	public static void enterAddTestSuiteDetailsWithWFDVersion(TestSuiteConfig testSuiteConfig,
															  String WorkforceDimensionsversion) throws InterruptedException {

		Thread.sleep(4000);
		type(inputTitle, testSuiteConfig.getTestSuiteWFDTitle(), "Title Field");
		type(inputDescription, testSuiteConfig.getTestWFDDescription(), "Description Field");
		click(testSuiteVendor, " Vendor DropDown");
		click(selectVendor, "Desired Vendor as Kronos");
		click(testActionLibrary, "TestActionLibrary DropDown");
		click(wfdActionLibrary, "Desired Action library As Workforce Dimensions Timekeeping");
		click(projectVersion, "Project Version Dropdown");
		By SelectProjectVersion = By.xpath("//div[contains(text(),'" +WorkforceDimensionsversion+"')]");
		click(SelectProjectVersion, "Desired Project Version : '" + WorkforceDimensionsversion + "'");
		click(testTarget, "TestTarget Dropdown");
		click(selectWFDTarget, "Desired TestTarget as Test Kronos Tenant w/ Boomi ");
		click(testSuitePurpose, "TestSuitePurpose Dropdown");
		click(selectPurpose, "Desired Purpose As Functional Testing");
		click(roles, "Roles Dropdown");
		click(selectRoles, "Desired Roles as Developer");

	}

	public static void enterAddTestSuiteDetails(TestSuiteConfig testSuiteConfig, String typetesting)
			throws InterruptedException {

		Thread.sleep(4000);
		By selectPurpose = By.xpath("//div[contains(text(),'" + typetesting + "')]");
		type(inputTitle, testSuiteConfig.getTestSuiteWFDTitle(), "Title Field");
		type(inputDescription, testSuiteConfig.getTestWFDDescription(), "Description Field");
		click(testSuiteVendor, " Vendor DropDown");
		click(selectVendor, "Desired Vendor as Kronos");
		click(testActionLibrary, "TestActionLibrary DropDown");
		click(wfcActionLibrary, "Desired Action library As Workforce Central");
		click(projectVersion, "Project Version Dropdown");
		By SelectProjectVersion = By.xpath("//div[contains(text(),'Workforce Central - R1')]");
		click(SelectProjectVersion, "Desired Project Version as R1");
		click(testTarget, "TestTarget Dropdown");
		click(selectWFCTarget, "Desired TestTarget as WFC Dev ");
		click(testSuitePurpose, "TestSuitePurpose Dropdown");
		click(selectPurpose, "Desired Purpose As " + typetesting);
		click(roles, "Roles Dropdown");
		click(selectRoles, "Desired Roles as Developer");
	}

}
