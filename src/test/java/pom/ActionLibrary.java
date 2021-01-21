package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import bean.ActionLibraryConfig;
import com.cucumber.listener.Reporter;
import utilities.SelCommands;

public class ActionLibrary extends SelCommands {

	public ActionLibrary(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void cancelAction() {
		By Cancel = By.xpath("//button[@label='Cancel']");
		click(Cancel, "Cancel");
	}

	public static void userSeeActionMessage() {
		By MessageCreated = By.xpath("//div[contains(text(),'Created')]");
		WebElement ele = driver.findElement(MessageCreated);
		if (ele.getText().contains("Created")) {
			Reporter.addStepLog("Action Library Created Successfully");
		} else {
			Reporter.addStepLog("Action Library is not Created Successfully");
		}
	}

	public static void userDeletesAction() {
		By ActionLibraryDelete = By.xpath("//*[@id='ACTION_TRASH_ICON']");
		By ActionLibraryDeleteConfirmation = By.xpath("//button[text()='Confirm']");
		click(ActionLibraryDelete, "ActionLibraryDelete");
		click(ActionLibraryDeleteConfirmation, "ActionLibraryDeleteConfirmation");
	}

	public static void userUpdatesAction(ActionLibraryConfig actionLibraryConfig) {
		WebDriverWait wait = new WebDriverWait(driver, 240);
		By ActionLibraryEdit = By.xpath("//*[@id='ACTION_EDIT_ICON']");
		wait.until(ExpectedConditions.presenceOfElementLocated(ActionLibraryEdit));
		By Descriptionfield = By.xpath("//textarea[@name='ACTION_DESCRIPTION']");
		By Labelfield = By.xpath("//input[@name='ACTION_CUSTOM_LABEL']");
		click(ActionLibraryEdit, "ActionLibraryEdit");
		type(Descriptionfield, actionLibraryConfig.getAcDescription(), "Descriptionfield");
		type(Labelfield, actionLibraryConfig.getAcLabel(), "Labelfield");
		userClicksOnSubmit();
	}

	public static void userNavigatesToActionLibrary(String typetesting) {
		By ActionLibrary = By.xpath("//a[text()='Action Library']");
		click(ActionLibrary, "Action Library");
	}

	public static void userNavigatesToActionLibrary_RegressionTesting() throws InterruptedException {
		Thread.sleep(4000);
		TestSuite.userClicksOnRegressionTestSuite();
		TestSuite.userSelectDesiredTestSuiteCreated();
		Thread.sleep(2000);
		By ActionLibrary = By.xpath("//a[text()='Action Library']");
		click(ActionLibrary, "Action Library");
	}

	public static void userClicksOnAddAction() throws InterruptedException {
		By AddAction = By.xpath("//*[@id='createActionIconId']");
		WebDriverWait wait = new WebDriverWait(driver, 240);
		wait.until(ExpectedConditions.presenceOfElementLocated(AddAction));
		click(AddAction, "Add Action");
	}


	public static void userFillsActionWithTableData_String(ActionLibraryConfig actionLibraryConfig) throws InterruptedException {

		Thread.sleep(4000);
		By Labelfield = By.xpath("//input[@id='ACTION_CUSTOM_LABEL']");
		By DescriptionField = By.xpath("//textarea[@id='ACTION_DESCRIPTION']");
		By Checkbox = By.xpath("//input[@type='checkbox']");
		By ActionTablelumnDisplayKey = By.xpath("(//INPUT[@id='ACTION_TABLE_COLUMNS_DISPLAY_KEY'])[1]");
		By ActionTableColumnType = By.cssSelector("#ACTION_TABLE_COLUMNS_TYPE input");
		By ActionTablePrefix = By.xpath("(//input[@placeholder='Prefix'])[1]");
		By ActionTableSuffix = By.xpath("(//input[@placeholder='Suffix'])[1]");
		type(Labelfield, actionLibraryConfig.getAcLabel(), "Labelfield");
		click(Checkbox, "Checkbox");
		type(DescriptionField, actionLibraryConfig.getAcDescription(), "Title Field");
		type(ActionTablelumnDisplayKey, actionLibraryConfig.getAcDisplayKey(), "ActionTablelumnDisplayKey Field");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(ActionTableColumnType));
		WebElement ActionTableColumType = driver.findElement(ActionTableColumnType);
		driver.findElement(ActionTableColumnType).sendKeys("String");
		action.sendKeys(Keys.ENTER).build().perform();
		// click(DesiredType, "DesiredType");
		type(ActionTableColumnType, actionLibraryConfig.getAcColumnType(), "Column Type");
		type(ActionTablePrefix, actionLibraryConfig.getAcPrefix(), "prefix Field");
		type(ActionTableSuffix, actionLibraryConfig.getAcSuffix(), "suffix Field");

	}


	public static void userFillsActionWithTableData_Integer(ActionLibraryConfig actionLibraryConfig,String type) throws InterruptedException {
		Thread.sleep(4000);
		By labelField = By.xpath("//input[@id='ACTION_CUSTOM_LABEL']");
		By DescriptionField = By.xpath("//textarea[@id='ACTION_DESCRIPTION']");
		By Checkbox = By.xpath("//input[@type='checkbox']");
		By ActionTableColumnDisplayKey = By.xpath("(//INPUT[@id='ACTION_TABLE_COLUMNS_DISPLAY_KEY'])[1]");
		By ActionTableColumnType = By.cssSelector("#ACTION_TABLE_COLUMNS_TYPE input");
		By ActionTablePrefix = By.xpath("(//input[@placeholder='Prefix'])[1]");
		By ActionTableSuffix = By.xpath("(//input[@placeholder='Suffix'])[1]");
		By Folder=By.xpath("//div[@id='ACTION_FOLDERS']");
		By DesiredFolder=By.xpath("//div[text()='toDelete']");
		type(labelField, actionLibraryConfig.getAcLabel(), "Labelfield");
		click(Checkbox, "Checkbox");
		type(DescriptionField, actionLibraryConfig.getAcDescription(), "Title Field");
		click(Folder, "Checkbox");
		click(DesiredFolder, "DesiredFolder as UAT");
		type(ActionTableColumnDisplayKey, actionLibraryConfig.getAcDisplayKey(), "ActionTableColumnDisplayKey Field");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(ActionTableColumnType));
		WebElement actionTableColumnType = driver.findElement(ActionTableColumnType);
		driver.findElement(ActionTableColumnType).sendKeys(type);
		action.sendKeys(Keys.ENTER).build().perform();
		type(ActionTableColumnType, type, "Column Type");
		type(ActionTablePrefix, actionLibraryConfig.getAcPrefix(), "prefix Field");
		type(ActionTableSuffix, actionLibraryConfig.getAcSuffix(), "suffix Field");

	}

	public static void userFillsAction(ActionLibraryConfig actionLibraryConfig) throws InterruptedException {
		Thread.sleep(2000);
		By labelField = By.xpath("//input[@id='ACTION_CUSTOM_LABEL']");
		By descriptionField = By.xpath("//textarea[@id='ACTION_DESCRIPTION']");
		type(labelField, actionLibraryConfig.getAcLabel(), "label Field");
		type(descriptionField, actionLibraryConfig.getAcDescription(), "Title Field");
	}

	public static void userClicksOnSubmit() {
		By Submit = By.xpath("//button[@label='Submit']");
		javascript_click(Submit, "Submit");
	}
}
