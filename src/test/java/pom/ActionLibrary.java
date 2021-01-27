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

	private static By actionLibrary = By.xpath("//a[text()='Action Library']");
	private static By addAction = By.xpath("//*[@id='createActionIconId']");
	private static By descriptionField = By.xpath("//textarea[@name='ACTION_DESCRIPTION']");
	private static By cancel = By.xpath("//button[@label='Cancel']");
	private static By messageCreated = By.xpath("//div[contains(text(),'Created')]");
	private static By actionDelete = By.xpath("//*[@id='ACTION_TRASH_ICON']");
	private static By actionDeleteConfirmation = By.xpath("//button[text()='Confirm']");
	private static By actionEdit = By.xpath("//*[@id='ACTION_EDIT_ICON']");
	private static By labelField = By.xpath("//input[@name='ACTION_CUSTOM_LABEL']");
	private static By checkBox = By.xpath("//input[@type='checkbox']");
	private static By actionTableColumnDisplayKey = By.xpath("(//INPUT[@id='ACTION_TABLE_COLUMNS_DISPLAY_KEY'])[1]");
	private static By actionTableColumnType = By.cssSelector("#ACTION_TABLE_COLUMNS_TYPE input");
	private static By actionTablePrefix = By.xpath("(//input[@placeholder='Prefix'])[1]");
	private static By actionTableSuffix = By.xpath("(//input[@placeholder='Suffix'])[1]");
	private static By folder =By.xpath("//div[@id='ACTION_FOLDERS']");
	private static By desiredFolder =By.xpath("//div[text()='toDelete']");
	private static By submit = By.xpath("//button[@label='Submit']");

	public ActionLibrary(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void cancelAction() {

		click(cancel, "Cancel");
	}

	public static void userSeeActionMessage() {
		WebElement ele = driver.findElement(messageCreated);
		if (ele.getText().contains("Created")) {
			Reporter.addStepLog("Action Library Created Successfully");
		} else {
			Reporter.addStepLog("Action Library is not Created Successfully");
		}
	}

	public static void userDeletesAction() throws InterruptedException {
		Thread.sleep(4000);
		click(actionDelete, "ActionLibraryDelete");
		click(actionDeleteConfirmation, "ActionLibraryDeleteConfirmation");
	}

	public static void userUpdatesAction(ActionLibraryConfig actionLibraryConfig) {
		WebDriverWait wait = new WebDriverWait(driver, 240);
		wait.until(ExpectedConditions.presenceOfElementLocated(actionEdit));
		click(actionEdit, "ActionLibraryEdit");
		type(descriptionField, actionLibraryConfig.getAcDescription()+" is updated", "Description field");
		type(labelField, actionLibraryConfig.getAcLabel()+" is updated", "Label field");
		userClicksOnSubmit();
	}

	public static void userNavigatesToActionLibrary(String typetesting) {
		click(actionLibrary, "Action Library");
	}

	public static void userNavigatesToActionLibrary_RegressionTesting() throws InterruptedException {
		Thread.sleep(4000);
		TestSuite.userClicksOnRegressionTestSuite();
		TestSuite.userSelectDesiredTestSuiteCreated();
		Thread.sleep(2000);
		click(actionLibrary, "Action Library");
	}

	public static void userClicksOnAddAction() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 240);
		wait.until(ExpectedConditions.presenceOfElementLocated(addAction));
		click(addAction, "Add Action");
	}


	public static void userFillsActionWithTableData(ActionLibraryConfig actionLibraryConfig, String type) throws InterruptedException {
		Thread.sleep(4000);
		type(labelField, actionLibraryConfig.getAcLabel(), "Label field");
		click(checkBox, "Checkbox");
		type(descriptionField, actionLibraryConfig.getAcDescription(), "Title Field");
		click(folder, "Checkbox");
		click(desiredFolder, "selecting folder as toDelete");
		type(actionTableColumnDisplayKey, actionLibraryConfig.getAcDisplayKey(), "ActionTableColumnDisplayKey Field");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(actionTableColumnType));
		//	WebElement ActionTableColumnTypeE = driver.findElement(actionTableColumnType);
		driver.findElement(actionTableColumnType).sendKeys(type);
		action.sendKeys(Keys.ENTER).build().perform();
		type(actionTableColumnType, type, "Column Type");
		type(actionTablePrefix, actionLibraryConfig.getAcPrefix(), "prefix Field");
		type(actionTableSuffix, actionLibraryConfig.getAcSuffix(), "suffix Field");

	}

	public static void userFillsAction(ActionLibraryConfig actionLibraryConfig) throws InterruptedException {
		Thread.sleep(2000);
		type(labelField, actionLibraryConfig.getAcLabel(), "label Field");
		type(descriptionField, actionLibraryConfig.getAcDescription(), "Title Field");
	}

	public static void userClicksOnSubmit() {
		javascript_click(submit, "Submit");
	}
}
