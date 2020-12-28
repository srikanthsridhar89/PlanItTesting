package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import utilities.Selcommands;

public class ActionLibrary extends Selcommands {

	public ActionLibrary(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void cancelactionlibrary() {

		By Cancel = By.xpath("//button[@label='Cancel']");
		click(Cancel, "Cancel");
	}

	public static void userseeactionlibrarymessage() {

		By MessageCreated = By.xpath("//div[contains(text(),'Created')]");
		WebElement ele = driver.findElement(MessageCreated);

		if (ele.getText().contains("Created")) {
			Reporter.addStepLog("Action Library Created Successfully");

		} else {
			Reporter.addStepLog("Action Library is not Created Successfully");

		}

	}

	public static void userdeletesactionlibrary() {

		By ActionLibraryDelete = By.xpath("//*[@id='ACTION_TRASH_ICON']");
		By ActionLibraryDeleteConfirmation = By.xpath("//button[text()='Confirm']");
		click(ActionLibraryDelete, "ActionLibraryDelete");

		click(ActionLibraryDeleteConfirmation, "ActionLibraryDeleteConfirmation");
	}

	public static void userupdatesactionlibrary(String desc, String label) {
		WebDriverWait wait = new WebDriverWait(driver, 240);
	
		By ActionLibraryEdit = By.xpath("//*[@id='ACTION_EDIT_ICON']");
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(ActionLibraryEdit));

		By Descriptionfield = By.xpath("//textarea[@name='ACTION_DESCRIPTION']");
		By Labelfield = By.xpath("//input[@name='ACTION_CUSTOM_LABEL']");

		click(ActionLibraryEdit, "ActionLibraryEdit");
		type(Descriptionfield, desc, "Descriptionfield");

		type(Labelfield, label, "Labelfield");
		userclicksonsubmit();
	}

	public static void usernavigatestoactionlibrary(String typetesting) {

		By ActionLibrary = By.xpath("//a[text()='Action Library']");
		click(ActionLibrary, "Action Library");

	}

	public static void usernavigatestoactionlibrary_regressiontesting() throws InterruptedException {
Thread.sleep(4000);

TestSuite.userclicksonregressiontestsuite();
TestSuite.userselectdesiredtestsuitecreated();
		By ActionLibrary = By.xpath("//a[text()='Action Library']");
		click(ActionLibrary, "Action Library");

	}

	

	public static void userclicksonaddaction() throws InterruptedException {
		By AddAction = By.xpath("//*[@id='createActionIconId']");

		WebDriverWait wait = new WebDriverWait(driver, 240);
		wait.until(ExpectedConditions.presenceOfElementLocated(AddAction));
		
		click(AddAction, "Add Action");
	}
	
	
	public static void userfillsactionlibrarywithtabledata_String(String label, String Description, String prefix,
			String suffix, String DisplayKey, String columntype) throws InterruptedException {

		Thread.sleep(4000);
		By Labelfield = By.xpath("//input[@id='ACTION_CUSTOM_LABEL']");
		By DescriptionField = By.xpath("//textarea[@id='ACTION_DESCRIPTION']");

		By Checkbox = By.xpath("//input[@type='checkbox']");
		By ActionTablelumnDisplayKey = By.xpath("(//INPUT[@id='ACTION_TABLE_COLUMNS_DISPLAY_KEY'])[1]");
		By ActionTableColumnType = By.cssSelector("#ACTION_TABLE_COLUMNS_TYPE input");
		By ActionTablePrefix = By.xpath("(//input[@placeholder='Prefix'])[1]");
		By ActionTableSuffix = By.xpath("(//input[@placeholder='Suffix'])[1]");

		type(Labelfield, label, "Labelfield");
		click(Checkbox, "Checkbox");

		type(DescriptionField, Description, "Title Field");

		type(ActionTablelumnDisplayKey, DisplayKey, "ActionTablelumnDisplayKey Field");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(ActionTableColumnType));
		WebElement ActionTableColumType = driver.findElement(ActionTableColumnType);
		// ActionTableColumType.click();
		// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
		// ActionTableColumType);
		driver.findElement(ActionTableColumnType).sendKeys("String");
		action.sendKeys(Keys.ENTER).build().perform();
		// click(DesiredType, "DesiredType");
		type(ActionTableColumnType, columntype, "Column Type");
		type(ActionTablePrefix, prefix, "prefix Field");

		type(ActionTableSuffix, suffix, "suffix Field");

	}


	public static void userfillsactionlibrarywithtabledata_Integer(String label, String Description, String prefix,
			String suffix, String DisplayKey, String type) throws InterruptedException {

		Thread.sleep(4000);
		By Labelfield = By.xpath("//input[@id='ACTION_CUSTOM_LABEL']");
		By DescriptionField = By.xpath("//textarea[@id='ACTION_DESCRIPTION']");

		By Checkbox = By.xpath("//input[@type='checkbox']");
		By ActionTablelumnDisplayKey = By.xpath("(//INPUT[@id='ACTION_TABLE_COLUMNS_DISPLAY_KEY'])[1]");
		By ActionTableColumnType = By.cssSelector("#ACTION_TABLE_COLUMNS_TYPE input");
		
		By ActionTablePrefix = By.xpath("(//input[@placeholder='Prefix'])[1]");
		By ActionTableSuffix = By.xpath("(//input[@placeholder='Suffix'])[1]");
By Folder=By.xpath("//div[@id='ACTION_FOLDERS']");
By DesiredFolder=By.xpath("//div[text()='UAT']");



		type(Labelfield, label, "Labelfield");
		click(Checkbox, "Checkbox");

		type(DescriptionField, Description, "Title Field");
		
		click(Folder, "Checkbox");
		click(DesiredFolder, "DesiredFolder as UAT");

		type(ActionTablelumnDisplayKey, DisplayKey, "ActionTablelumnDisplayKey Field");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(ActionTableColumnType));
		WebElement ActionTableColumType = driver.findElement(ActionTableColumnType);
		// ActionTableColumType.click();
		// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
		// ActionTableColumType);
		driver.findElement(ActionTableColumnType).sendKeys(type);
		action.sendKeys(Keys.ENTER).build().perform();
		// click(DesiredType, "DesiredType");
		type(ActionTableColumnType, type, "Column Type");
		type(ActionTablePrefix, prefix, "prefix Field");

		type(ActionTableSuffix, suffix, "suffix Field");

	}

	public static void userfillsactionlibrary(String label, String Description) throws InterruptedException {
		Thread.sleep(4000);
		By Labelfield = By.xpath("//input[@id='ACTION_CUSTOM_LABEL']");
		By DescriptionField = By.xpath("//textarea[@id='ACTION_DESCRIPTION']");
		/*
		 * By FolderDropdown=By.xpath("//div[contains(@class,'indicator')]"); By
		 * DesiredFolder=By.xpath("//div[contains(text(),'" + typetesting + "')]");
		 */

		type(Labelfield, label, "Labelfield");

		type(DescriptionField, Description, "Title Field");

	}

	public static void userclicksonsubmit() {

		By Submit = By.xpath("//button[@label='Submit']");
		javascript_click(Submit, "Submit");

	}
}
