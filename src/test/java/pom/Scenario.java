package pom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import net.bytebuddy.utility.RandomString;
import utilities.SelCommands;

public class Scenario extends SelCommands {

	public static String sFolderName = "TestFolder" + new RandomString(4).nextString();
	public static String sParentFolderName="ParentFolder"+ new RandomString(4).nextString();
	public static String sTestScenario = "TestScenario" + new RandomString(4).nextString();
	public static String sSubFoldername1 = "SubFolder1" + new RandomString(4).nextString();
	public static String sSubFoldername2 = "SubFolder2" + new RandomString(4).nextString();
	public static String sWhenTableData = "I approve my timecard for <Symbolic Period>";
	public static String sThenTableData = "My Pay Code amounts breakdown for day <Day> in the current pay period is";
	public static String sPayCode = "25";
	public static String sAmount = "4500";
	public static String swages = "60";
	public static String sUpdateWhenData = "My overtime for today is approved";
	public static String sUpdateThenData = "My shift does not have an exception flag";
	private static By RequirementNotesfield;
	public static String url="";

	public Scenario(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void duplicateScenario() {

		By DuplicateScenario = By.xpath("//span[@data-tip='Duplicate Scenario']");
		By Submitbutton = By.xpath("//button[text()='Submit']");

		WebDriverWait wait = new WebDriverWait(driver, 240);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Create New Folder']")));
		driver.findElement(By.xpath("//input[@placeholder='Create New Folder']")).sendKeys(sFolderName);
		Actions action = new Actions(driver);

		action.sendKeys(Keys.ENTER).perform();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='" + sFolderName + "']")));
		driver.findElement(By.xpath("//label[text()='" + sFolderName + "']")).click();
		Reporter.addStepLog("User Creates Folder as" + sFolderName);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#create-scenario-onEnterPress")));
		driver.findElement(By.cssSelector("#create-scenario-onEnterPress")).sendKeys(sTestScenario);
		action.sendKeys(Keys.ENTER).perform();

		Reporter.addStepLog("User Creates TestScenario :" + sTestScenario);

		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class='scenario-header-icons']/span[@data-tip='Edit Scenario']")));

		driver.findElement(By.xpath("//div[@class='scenario-header-icons']/span[@data-tip='Edit Scenario']")).click();

		driver.findElement(DuplicateScenario).click();
		driver.findElement(Submitbutton).click();
	}

	public static void userCreatesTemplate() {

		By CreateTemplateIcon = By.xpath("//span[@data-tip='Create Template']");
		By CreateTemplateConfirmation = By.xpath("//button[@id='createTemplate']");

		WebDriverWait wait = new WebDriverWait(driver, 240);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Create New Folder']")));
		driver.findElement(By.xpath("//input[@placeholder='Create New Folder']")).sendKeys(sFolderName);
		Actions action = new Actions(driver);

		action.sendKeys(Keys.ENTER).perform();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='" + sFolderName + "']")));
		driver.findElement(By.xpath("//label[text()='" + sFolderName + "']")).click();
		Reporter.addStepLog("User Creates Folder as" + sFolderName);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#create-scenario-onEnterPress")));
		driver.findElement(By.cssSelector("#create-scenario-onEnterPress")).sendKeys(sTestScenario);
		action.sendKeys(Keys.ENTER).perform();

		Reporter.addStepLog("User Creates TestScenario :" + sTestScenario);

		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class='scenario-header-icons']/span[@data-tip='Edit Scenario']")));

		driver.findElement(By.xpath("//div[@class='scenario-header-icons']/span[@data-tip='Edit Scenario']")).click();

		driver.findElement(CreateTemplateIcon).click();
		driver.findElement(CreateTemplateConfirmation).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#react-select-2-input")));
		action.click(driver.findElement(By.cssSelector("#react-select-2-input"))).perform();
		driver.findElement(By.cssSelector("#react-select-2-input")).sendKeys("Exempt");

		driver.findElement(By.cssSelector("#react-select-2-input")).sendKeys(Keys.ENTER);

		Reporter.addStepLog("User Selects Given Scenario Statement");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#react-select-3-input")));
		action.click(driver.findElement(By.cssSelector("#react-select-3-input"))).perform();
		driver.findElement(By.cssSelector("#react-select-3-input")).sendKeys(sWhenTableData);

		driver.findElement(By.cssSelector("#react-select-3-input")).sendKeys(Keys.ENTER);
		Reporter.addStepLog("User Selects When  Scenario Statement");

		driver.findElement(By.xpath("//span[text()='When']/following::input[@class='editable-input-text']"))
				.sendKeys("50");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#react-select-4-input")));
		action.click(driver.findElement(By.cssSelector("#react-select-4-input"))).perform();
		driver.findElement(By.cssSelector("#react-select-4-input")).sendKeys(sThenTableData);

		driver.findElement(By.cssSelector("#react-select-4-input")).sendKeys(Keys.ENTER);

		Reporter.addStepLog("User Selects Then Scenario Statement ");

		driver.findElement(By.xpath("//span[text()='Then']/following::input[@class='editable-input-text']"))
				.sendKeys("60");

	}

	public static void userSharesScenarioLink() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 240);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Create New Folder']")));
		driver.findElement(By.xpath("//input[@placeholder='Create New Folder']")).sendKeys(sFolderName);
		Actions action = new Actions(driver);

		action.sendKeys(Keys.ENTER).perform();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='" + sFolderName + "']")));
		driver.findElement(By.xpath("//label[text()='" + sFolderName + "']")).click();
		Reporter.addStepLog("User Creates Folder as" + sFolderName);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#create-scenario-onEnterPress")));
		driver.findElement(By.cssSelector("#create-scenario-onEnterPress")).sendKeys(sTestScenario);
		action.sendKeys(Keys.ENTER).perform();
		Reporter.addStepLog("User Creates TestScenario :" + sTestScenario);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class='scenario-header-icons']/span[@data-tip='Edit Scenario']")));

		driver.findElement(By.xpath("//div[@class='scenario-header-icons']/span[@data-tip='Edit Scenario']")).click();


		Thread.sleep(4000);
		By ShareIcon = By.xpath("//button[@class='share-icon']");
		click(ShareIcon, "ShareIcon");
		url=driver.findElement(ShareIcon).getAttribute("data-clipboard-text");

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(url);



		//By txt_LinkCopied = By.xpath("//*[text()='Link copied to clipboard']");
		//String btn = getElementString(txt_LinkCopied);
		//Assert.assertEquals("Link copied to clipboard", btn);


		Reporter.addStepLog("User Sees LinkCopied Text Correctly");
	}



	public static  void userSeeSharedScenario() throws IOException {

		if(!url.isEmpty()) {
			Reporter.addStepLog("User see Shared Scenario Correctly :"+url);
		}
		else {

			Reporter.addStepLog("User does not  see Shared Scenario Correctly");
		}
		SelCommands.captureScreenshot();
	}
	public static void userCreatesRequirementNotes(String Requirementnotes) {

		By Save = By.xpath("//button[text()='Save']");
		By RequirementNotefield = By.xpath("//*[@placeholder='Enter requirements or notes for this folder']");
		By RequirementNoteToggle = By.xpath("//span[contains(text(),'Requirements ')]/preceding-sibling::span");

		WebDriverWait wait = new WebDriverWait(driver, 240);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Create New Folder']")));
		driver.findElement(By.xpath("//input[@placeholder='Create New Folder']")).sendKeys(sFolderName);
		Actions action = new Actions(driver);

		action.sendKeys(Keys.ENTER).perform();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='" + sFolderName + "']")));
		driver.findElement(By.xpath("//label[text()='" + sFolderName + "']")).click();
		Reporter.addStepLog("User Creates Folder as" + sFolderName);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#create-scenario-onEnterPress")));
		driver.findElement(By.cssSelector("#create-scenario-onEnterPress")).sendKeys(sTestScenario);
		action.sendKeys(Keys.ENTER).perform();

		Reporter.addStepLog("User Creates TestScenario :" + sTestScenario);

		wait.until(ExpectedConditions.presenceOfElementLocated(RequirementNoteToggle));
		click(RequirementNoteToggle, "Requirement Toggle");
		type(RequirementNotefield, Requirementnotes, "RequirementNotefield  Field");
		driver.findElement(RequirementNotefield).sendKeys(Keys.ENTER);
		click(Save, "Save button");
	}

	public static void userseesparentfolder() throws InterruptedException {

		Thread.sleep(5000);

		WebElement Foldername = driver.findElement(By.xpath("//label[text()='" + sFolderName + "']"));

		if (Foldername.getText().equals(sFolderName)) {
			Reporter.addStepLog("User sees ParentFolder After Deletion : " + sFolderName);
		} else {
			Reporter.addStepLog("User does not see Folder After Deletion");

		}

	}

	public static void usersearchesscenario() throws InterruptedException {

		By ScenarioSearch = By.xpath("//div[@class='form-group search-form-input']/input");

		WebElement ele = driver.findElement(ScenarioSearch);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);

		driver.findElement(ScenarioSearch).sendKeys(sTestScenario);
		driver.findElement(ScenarioSearch).sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		WebElement Foldername = driver.findElement(By.xpath("//label[text()='" + sFolderName + "']"));

		if (Foldername.getText().equals(sFolderName)) {
			Reporter.addStepLog("User sees Folder Created After Search : " + sFolderName);
		} else {
			Reporter.addStepLog("User does not see Folder Created After Search");

		}
	}

	public static void userwillnotseefolderdeleted() {
		if (!sFolderName.isEmpty()) {

			Reporter.addScenarioLog("User Does not see Folder Deleted ");
		} else {

			Reporter.addScenarioLog("User Sees Folder Deleted ");
		}
	}

	public static void userwillseeParentfolderdeleted() throws InterruptedException {
		Thread.sleep(5000);
		if (sFolderName.isEmpty()) {

			Reporter.addScenarioLog("User See Parent Folder Deleted");
		} else {

			Reporter.addScenarioLog("User Does not Sees Parent Folder Deleted ");
		}
	}

	public static void usercreateschildfolder() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 180);
		driver.findElement(By.xpath("//input[@id='new-scenario-folder']")).sendKeys(Keys.ENTER);
		Actions action = new Actions(driver);

		WebElement ele = driver.findElement(By.xpath("//label[text()='" + sFolderName + "']"));
		ele.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Create New Folder']")));

		WebElement NewFolder = driver.findElement(By.xpath("//input[@placeholder='Create New Folder']"));
		action.moveToElement(NewFolder).build().perform();
		driver.findElement(By.xpath("//input[@placeholder='Create New Folder']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Create New Folder']")).sendKeys(sSubFoldername1);

		action.sendKeys(Keys.ENTER).perform();

		Reporter.addStepLog("User Creates Sub Folder as" + sSubFoldername1);

	}

	public static void userseefoldercreated() throws InterruptedException {
		Thread.sleep(4000);
		WebElement ele = driver.findElement(By.xpath("//label[text()='" + sFolderName + "']"));
		if (ele.isDisplayed()) {
			Reporter.addStepLog("User sees Folder Created Successfully");
		} else {

			Reporter.addStepLog("User does not sees Folder Created Successfully");
		}
	}

	public static void userupdatescenariowithsimplestring() {
		WebDriverWait wait = new WebDriverWait(driver, 180);
		Actions action = new Actions(driver);

		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class='scenario-header-icons']/span[@data-tip='Edit Scenario']")));

		driver.findElement(By.xpath("//div[@class='scenario-header-icons']/span[@data-tip='Edit Scenario']")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#react-select-6-input")));
		action.click(driver.findElement(By.cssSelector("#react-select-6-input"))).perform();
		driver.findElement(By.cssSelector("#react-select-6-input")).sendKeys(sUpdateWhenData);

		driver.findElement(By.cssSelector("#react-select-6-input")).sendKeys(Keys.ENTER);
		Reporter.addStepLog("User Updates  When  Scenario Statement with  :" + sUpdateWhenData);

		// driver.findElement(By.xpath("//span[text()='When']/following::input[@class='editable-input-text']"))
		// .sendKeys("50");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#react-select-7-input")));
		action.click(driver.findElement(By.cssSelector("#react-select-7-input"))).perform();
		driver.findElement(By.cssSelector("#react-select-7-input")).sendKeys(sUpdateThenData);

		driver.findElement(By.cssSelector("#react-select-7-input")).sendKeys(Keys.ENTER);

		Reporter.addStepLog("User Updates  Then Scenario Statement with  :" + sUpdateThenData);

	}

	public static void usercreatesscenariowithtabledata() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 240);
		driver.findElement(By.xpath("//input[@placeholder='Create New Folder']")).sendKeys(sFolderName);
		Actions action = new Actions(driver);

		action.sendKeys(Keys.ENTER).perform();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='" + sFolderName + "']")));
		driver.findElement(By.xpath("//label[text()='" + sFolderName + "']")).click();
		Reporter.addStepLog("User Creates Folder as" + sFolderName);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#create-scenario-onEnterPress")));
		driver.findElement(By.cssSelector("#create-scenario-onEnterPress")).sendKeys(sTestScenario);
		action.sendKeys(Keys.ENTER).perform();

		Reporter.addStepLog("User Creates TestScenario :" + sTestScenario);

		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class='scenario-header-icons']/span[@data-tip='Edit Scenario']")));

		driver.findElement(By.xpath("//div[@class='scenario-header-icons']/span[@data-tip='Edit Scenario']")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#react-select-2-input")));
		action.click(driver.findElement(By.cssSelector("#react-select-2-input"))).perform();
		driver.findElement(By.cssSelector("#react-select-2-input")).sendKeys("Exempt");

		driver.findElement(By.cssSelector("#react-select-2-input")).sendKeys(Keys.ENTER);

		Reporter.addStepLog("User Selects Given Scenario Statement");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#react-select-3-input")));
		action.click(driver.findElement(By.cssSelector("#react-select-3-input"))).perform();
		driver.findElement(By.cssSelector("#react-select-3-input")).sendKeys(sWhenTableData);

		driver.findElement(By.cssSelector("#react-select-3-input")).sendKeys(Keys.ENTER);
		Reporter.addStepLog("User Selects When  Scenario Statement");

		driver.findElement(By.xpath("//span[text()='When']/following::input[@class='editable-input-text']"))
				.sendKeys("50");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#react-select-4-input")));
		action.click(driver.findElement(By.cssSelector("#react-select-4-input"))).perform();
		driver.findElement(By.cssSelector("#react-select-4-input")).sendKeys(sThenTableData);

		driver.findElement(By.cssSelector("#react-select-4-input")).sendKeys(Keys.ENTER);

		Reporter.addStepLog("User Selects Then Scenario Statement ");

		driver.findElement(By.xpath("//span[text()='Then']/following::input[@class='editable-input-text']"))
				.sendKeys("60");

	}

	public static void usercreatesscenario_multiplecondition() throws InterruptedException, IOException {

		By AddPersonaModifier = By.xpath("(//div[@class='add-step-zero-state'])[1]//span");
		By AddEmployeeAction = By.xpath("(//div[@class='add-step-zero-state']//span)[2]");
		By AddValidationAction = By.xpath("(//div[@class='add-step-zero-state']//span)[3]");
		By Save = By.xpath("//button[@type='submit']");
		WebDriverWait wait = new WebDriverWait(driver, 240);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Create New Folder']")));
		driver.findElement(By.xpath("//input[@placeholder='Create New Folder']")).sendKeys(sFolderName);
		Actions action = new Actions(driver);

		action.sendKeys(Keys.ENTER).perform();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='" + sFolderName + "']")));
		driver.findElement(By.xpath("//label[text()='" + sFolderName + "']")).click();
		Reporter.addStepLog("User Creates Folder as" + sFolderName);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#create-scenario-onEnterPress")));
		driver.findElement(By.cssSelector("#create-scenario-onEnterPress")).sendKeys(sTestScenario);
		action.sendKeys(Keys.ENTER).perform();

		Reporter.addStepLog("User Creates TestScenario :" + sTestScenario);

		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class='scenario-header-icons']/span[@data-tip='Edit Scenario']")));

		driver.findElement(By.xpath("//div[@class='scenario-header-icons']/span[@data-tip='Edit Scenario']")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#react-select-2-input")));
		action.click(driver.findElement(By.cssSelector("#react-select-2-input"))).perform();
		driver.findElement(By.cssSelector("#react-select-2-input")).sendKeys("Exempt");

		driver.findElement(By.cssSelector("#react-select-2-input")).sendKeys(Keys.ENTER);

		Reporter.addStepLog("User Selects Given Scenario Statement");

		click(AddPersonaModifier, "AddPersonaModifier");
		By GivenAnd = By.xpath("(//div[text()='Select an action...'])[1]");

		wait.until(ExpectedConditions.presenceOfElementLocated(GivenAnd));
		action.click(driver.findElement(GivenAnd)).perform();
		action.sendKeys("I have a co-worker");
		action.sendKeys(Keys.ENTER);
		Reporter.addStepLog("User Selects Given with And  Statement");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#react-select-3-input")));
		action.click(driver.findElement(By.cssSelector("#react-select-3-input"))).perform();
		driver.findElement(By.cssSelector("#react-select-3-input")).sendKeys("No action is taken");

		driver.findElement(By.cssSelector("#react-select-3-input")).sendKeys(Keys.ENTER);

		Reporter.addStepLog("User Selects When  Scenario Statement");

		SelCommands.javascript_click(AddEmployeeAction, "AddEmployeeAction");

		By WhenAnd = By.xpath("//div[text()='Select an action...']");
		wait.until(ExpectedConditions.presenceOfElementLocated(WhenAnd));
		action.click(driver.findElement(WhenAnd)).perform();
		action.sendKeys("My person import is triggered and completed");
		action.sendKeys(Keys.ENTER);

		Reporter.addStepLog("User Selects When with And  Statement");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#react-select-4-input")));
		action.click(driver.findElement(By.cssSelector("#react-select-4-input"))).perform();
		driver.findElement(By.cssSelector("#react-select-4-input")).sendKeys("All actions were successful");

		driver.findElement(By.cssSelector("#react-select-4-input")).sendKeys(Keys.ENTER);

		Reporter.addStepLog("User Selects Then Scenario Statement ");

		SelCommands.javascript_click(AddValidationAction, "AddValidationAction");

		By ThenAnd = By.xpath("//div[text()='Select an action...']");

		wait.until(ExpectedConditions.presenceOfElementLocated(ThenAnd));
		action.click(driver.findElement(ThenAnd)).perform();
		driver.findElement(By.xpath("//div[@id='react-select-9-option-4']")).click();

		Reporter.addStepLog("User Selects Then with And  Statement");



		SelCommands.captureScreenshot();

		click(Save, "Save");

	}

	public static void usercreatesscenariowithsimplestring() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 240);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Create New Folder']")));
		driver.findElement(By.xpath("//input[@placeholder='Create New Folder']")).sendKeys(sFolderName);
		Actions action = new Actions(driver);

		action.sendKeys(Keys.ENTER).perform();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='" + sFolderName + "']")));
		driver.findElement(By.xpath("//label[text()='" + sFolderName + "']")).click();
		Reporter.addStepLog("User Creates Folder as" + sFolderName);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#create-scenario-onEnterPress")));
		driver.findElement(By.cssSelector("#create-scenario-onEnterPress")).sendKeys(sTestScenario);
		action.sendKeys(Keys.ENTER).perform();

		Reporter.addStepLog("User Creates TestScenario :" + sTestScenario);

		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class='scenario-header-icons']/span[@data-tip='Edit Scenario']")));

		driver.findElement(By.xpath("//div[@class='scenario-header-icons']/span[@data-tip='Edit Scenario']")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#react-select-2-input")));
		action.click(driver.findElement(By.cssSelector("#react-select-2-input"))).perform();
		driver.findElement(By.cssSelector("#react-select-2-input")).sendKeys("Exempt");

		driver.findElement(By.cssSelector("#react-select-2-input")).sendKeys(Keys.ENTER);

		Reporter.addStepLog("User Selects Given Scenario Statement");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#react-select-3-input")));
		action.click(driver.findElement(By.cssSelector("#react-select-3-input"))).perform();
		driver.findElement(By.cssSelector("#react-select-3-input")).sendKeys("No action is taken");

		driver.findElement(By.cssSelector("#react-select-3-input")).sendKeys(Keys.ENTER);

		Reporter.addStepLog("User Selects When  Scenario Statement");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#react-select-4-input")));
		action.click(driver.findElement(By.cssSelector("#react-select-4-input"))).perform();
		driver.findElement(By.cssSelector("#react-select-4-input")).sendKeys("All actions were successful");

		driver.findElement(By.cssSelector("#react-select-4-input")).sendKeys(Keys.ENTER);

		Reporter.addStepLog("User Selects Then Scenario Statement ");
	}

	public static void userclicksonsave() {

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Reporter.addStepLog("User Clicked on Save");
	}

	public static void userclicksoncancel() {

		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		Reporter.addStepLog("User Clicked on Cancel");

	}

	public static void userclicksondeletescenario() throws InterruptedException {

		driver.findElement(By.xpath("//span[@data-tip='Delete Scenario']")).click();
	}

	public static void userdoesnotseescenariodetails() {

		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[contains(text(),'All actions were successful')]")));
		WebElement E1 = driver.findElement(By.xpath("//span[contains(text(),'Non-Exempt')]"));
		WebElement E2 = driver.findElement(By.xpath("//span[contains(text(),'No action')]"));
		WebElement E3 = driver.findElement(By.xpath("//span[contains(text(),'All actions were successful')]"));

		if (!E1.getText().isEmpty() && !E2.getText().isEmpty()) {
			Reporter.addStepLog("User does not Sees Scenario Details after deleting");
		} else {
			Reporter.addStepLog("User Sees Scenario details after deleting");

		}
	}

	public static void userseescreatedpersona() throws IOException {


		WebElement E1 = driver.findElement(By.xpath("//label[contains(text(),'I am an Exempt')]"));


		if(E1.getText().contains("Exempt")) {
			Reporter.addStepLog("User sees Created Persona Correctly"+E1.getText());
		}

		else {
			Reporter.addStepLog("User does not sees Created Persona");
		}
		SelCommands.captureScreenshot();
	}

	public static void userseescenariocreatedwithsimplestring() {
		WebDriverWait wait = new WebDriverWait(driver, 240);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[contains(text(),'All actions were successful')]")));
		WebElement E1 = driver.findElement(By.xpath("//span[contains(text(),'Non-Exempt')]"));
		WebElement E2 = driver.findElement(By.xpath("//span[contains(text(),'No action')]"));
		WebElement E3 = driver.findElement(By.xpath("//span[contains(text(),'All actions were successful')]"));

		if (E1.getText().contains("I am a Hourly Non-Exempt Employee") && E2.getText().equals("No action is taken")
				&& E3.getText().equals("All actions were successful")) {
			Reporter.addStepLog("User Sees Scenario Given  as :" + E1.getText());
			Reporter.addStepLog("User Sees Scenario When  as :" + E2.getText());
			Reporter.addStepLog("User Sees Scenario Then  as :" + E3.getText());

		} else {

			Reporter.addStepLog("User does not Sees Scenario Statement Correctly");
		}
	}

	public static void userclicksonscenariotab() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 240);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Scenarios']")));
		By ScenarioTab = By.xpath("//a[text()='Scenarios']");
		javascript_click(ScenarioTab, "Scenario Tab");

	}


	public static void userclicksonpersonalink() throws InterruptedException {
		Thread.sleep(4000);
		By PersonaLink=By.xpath("//a[@id='viewByPersonaLink']");
		WebElement ele=driver.findElement(By.xpath("//input[@placeholder='Create New Folder']"));
		if(ele.isDisplayed()) {


			click(PersonaLink, "PersonaLink");

		}
		else {

			By FolderLink=By.xpath("//*[@id='viewByFolderLink']");
			click(FolderLink, "FolderLink");
			click(PersonaLink, "PersonaLink");
		}
	}

	public static void userclicksoncreatefolder() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 240);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='create-folder-button']")));
		By CreateFolder = By.xpath("//*[@id='create-folder-button']");
		// click(CreateNewTestSuite, " Create New TestSuite");
		click(CreateFolder, "Create Folder");

	}

	public static void usercreatessubfolder() throws InterruptedException {

		Thread.sleep(4000);
		// User selects Folder Created
		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='" + sFolderName + "']")));

		driver.findElement(By.xpath("//label[text()='" + sFolderName + "']")).click();
		Reporter.addStepLog("User Selected Folder Created");
		driver.findElement(By.cssSelector("svg#create-folder-button")).click();
		Reporter.addStepLog("User Clicked on Create Folder");

		Actions action = new Actions(driver);
		WebElement Subfolder = driver.findElement(By.xpath("//*[@class='ta-tree-file']/span"));

		action.contextClick(Subfolder).perform();
		driver.findElement(By.xpath("//*[@class='ta-tree-file']/nav//ul[@class='options']/li[1]")).click();
		Reporter.addStepLog("User Clicked on Rename");

		driver.findElement(By.xpath("//ul[@class='ta-tree-node'] //input")).sendKeys(sSubFoldername1);
		Reporter.addStepLog("User Inputs Value as" + sSubFoldername1);

		driver.findElement(By.xpath("//label[text()='" + sFolderName + "']")).click();
		driver.findElement(By.cssSelector("svg#create-folder-button")).click();
		Reporter.addStepLog("User Creates Another Sub Folder");
		WebElement Subfolder2 = driver.findElement(By.xpath("(//span[@class='icon-file'])[1]"));

		action.contextClick(Subfolder2).perform();

		driver.findElement(By.xpath("(//nav//ul[@class='options']/li[1])[2]")).click();
		Reporter.addStepLog("User Clicked on Rename");

		driver.findElement(By.xpath("//ul[@class='ta-tree-node'] //input")).sendKeys(sSubFoldername2);

		Reporter.addStepLog("User Inputs Value as " + sSubFoldername2);

	}

	public static void user_deletesfolder_excluding_children() throws InterruptedException {
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		WebElement Subfolder = driver.findElement(By.xpath("//label[text()='" + sSubFoldername1 + "']"));
		action.contextClick(Subfolder).perform();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(
				By.xpath("(//nav[@class='context-menu']//ul/li[text()='Delete Folder (Excluding Children)'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
		Alert alert = driver.switchTo().alert(); // switch to alert
		String alertMessage = driver.switchTo().alert().getText(); // capture alert message
		System.out.println(alertMessage); // Print Alert Message
		Thread.sleep(5000);
		alert.accept();
		Reporter.addStepLog("User Clicked on Delete Folder ");
	}

	public static void user_deletesfolder_including_children() throws InterruptedException {
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		WebElement folder = driver.findElement(
				By.xpath("//label[text()='" + sFolderName + "']/preceding::span[@class='icon-folder'][1]"));
		action.contextClick(folder).perform();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(
				By.xpath("(//nav[@class='context-menu']//ul/li[text()='Delete Folder (Including Children)'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
		Alert alert = driver.switchTo().alert(); // switch to alert
		String alertMessage = driver.switchTo().alert().getText(); // capture alert message
		Thread.sleep(5000);
		alert.accept();
		Reporter.addStepLog("User Clicked on Delete Folder ");
	}

	public static void usercreatesfolderandscenario() throws InterruptedException {

		driver.findElement(By.xpath("//input[@placeholder='Create New Folder']")).sendKeys(sFolderName);
		driver.findElement(By.xpath("//input[@placeholder='Create New Folder']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		Reporter.addStepLog("User Creates Folder :" + sFolderName);
		driver.findElement(By.xpath("//label[text()='" + sFolderName + "']/preceding::span[@class='icon-file'][1]"))
				.click();
		WebDriverWait wait = new WebDriverWait(driver, 180);
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#create-scenario-onEnterPress")));
		driver.findElement(By.cssSelector("#create-scenario-onEnterPress")).sendKeys(sTestScenario);
		action.sendKeys(Keys.ENTER).perform();
		Reporter.addStepLog("User Creates TestScenario :" + sTestScenario);

	}

	public static void userrenamescreatedfolder() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='" + sFolderName + "']/preceding::span[@class='icon-file'][1]")));
		Thread.sleep(3000);
		scrollInToViewElement(By.xpath("//label[text()='" + sFolderName + "']/preceding::span[@class='icon-file'][1]"));
		driver.findElement(By.xpath("//label[text()='" + sFolderName + "']/preceding::span[@class='icon-file'][1]"))
				.click();
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		WebElement folder = driver
				.findElement(By.xpath("//label[text()='" + sFolderName + "']/preceding::span[@class='icon-file'][1]"));
		action.contextClick(folder).build().perform();
		WebElement ele = driver.findElement(By.xpath("(//nav[@class='context-menu']//ul/li[text()='Rename'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
		Reporter.addStepLog("User Clicked on Rename");
		driver.findElement(By.xpath("//input[@class='editable-input-text']")).sendKeys(sParentFolderName);


		Reporter.addStepLog("User Renames Parent Folder as "+sParentFolderName);
		SelCommands.captureScreenshot();



	}

	public static void usercopiesfolder() throws InterruptedException {

		Thread.sleep(4000);

		Actions action = new Actions(driver);
		WebElement folder = driver
				.findElement(By.xpath("//label[text()='" + sFolderName + "']/preceding::span[@class='icon-file'][1]"));

		action.contextClick(folder).perform();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("(//nav[@class='context-menu']//ul/li[text()='Copy'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
		Reporter.addStepLog("User Clicked on Copy");

	}

	public static void thenuserseesexportedfolder() throws InterruptedException {
		String Parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I = s.iterator();
		while (I.hasNext()) {

			String Child_Window = I.next();

			if (!Parent.equals(Child_Window)) {

				driver.switchTo().window(Child_Window);
			}
		}
		Thread.sleep(4000);
		String title = driver.getTitle();
		System.out.println("Page title is" + title);

		if (title.equals("TestAssure")) {
			Reporter.addStepLog("User Sees Exported Folder Correctly");

		} else {

			Reporter.addStepLog("User does not Sees Exported Folder Correctly");
		}

	}

	public static void thenuserseesexportedfeaturefile() throws InterruptedException {
		String Parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I = s.iterator();
		while (I.hasNext()) {

			String Child_Window = I.next();

			if (!Parent.equals(Child_Window)) {

				driver.switchTo().window(Child_Window);
			}
		}
		Thread.sleep(4000);

	}

	public static void userexportsfolder() throws InterruptedException {

		driver.findElement(By.cssSelector("svg#create-folder-button")).click();
		Reporter.addStepLog("User Clicked on Create Folder");
		Thread.sleep(3000);

		Actions action = new Actions(driver);
		WebElement folder = driver.findElement(
				By.xpath("//label[text()='" + sFolderName + "']/preceding::span[@class='icon-folder'][1]"));

		action.contextClick(folder).perform();

		WebElement ele = driver.findElement(By.xpath("(//nav[@class='context-menu']//ul/li[text()='Export'])[1]"));
		Thread.sleep(4000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
		// driver.findElement(By.xpath("(//nav[@class='context-menu']//ul/li[text()='Export'])[1]")).click();

		Reporter.addStepLog("User Clicked on Export");

	}

	public static void userexportsfeaturefile() throws InterruptedException {

		driver.findElement(By.cssSelector("svg#create-folder-button")).click();
		Reporter.addStepLog("User Clicked on Create Folder");
		Thread.sleep(3000);

		Actions action = new Actions(driver);
		WebElement folder = driver.findElement(
				By.xpath("//label[text()='" + sFolderName + "']/preceding::span[@class='icon-folder'][1]"));

		action.contextClick(folder).perform();

		WebElement ele = driver
				.findElement(By.xpath("(//nav[@class='context-menu']//ul/li[text()='Export Feature File'])[1]"));
		Thread.sleep(4000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
		// driver.findElement(By.xpath("(//nav[@class='context-menu']//ul/li[text()='Export'])[1]")).click();

		Reporter.addStepLog("User Clicked on Export");

	}

	public static void copytestsuite() throws InterruptedException {

		driver.findElement(By.cssSelector("svg#create-folder-button")).click();
		Reporter.addStepLog("User Clicked on Create Folder");
		Thread.sleep(3000);

		Actions action = new Actions(driver);
		WebElement folder = driver.findElement(
				By.xpath("//label[text()='" + sFolderName + "']/preceding::span[@class='icon-folder'][1]"));

		action.contextClick(folder).perform();

		WebElement ele = driver
				.findElement(By.xpath("(//nav[@class='context-menu']//ul/li[text()='Copy to Test Suite'])[1]"));
		Thread.sleep(4000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
		// driver.findElement(By.xpath("(//nav[@class='context-menu']//ul/li[text()='Export'])[1]")).click();

		Reporter.addStepLog("User Clicked on Copy to Test Suite");

		driver.findElement(By.xpath("(//div[contains(@class,' copy-scenario-select')])[1]")).click();
		By DesiredTestSuite = By.xpath("//div[text()='AutoHeTe']");
		click(DesiredTestSuite, "Desired TestSuite");

		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}

	public static void reviewoptions(String typeofreviewopts, String Comment) throws InterruptedException, IOException {

		By reviewopt = By.xpath("//*[@name='reviewOpt']");
		By Comments = By.xpath("//textarea[@placeholder='Enter comment about review status']");
		By Save = By.xpath("//button[@id='save-folder-status']");
		By ReviewStatustoggle = By.xpath("//span[text()='Review Status']/preceding-sibling::span");

		WebDriverWait wait = new WebDriverWait(driver, 240);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Create New Folder']")));
		driver.findElement(By.xpath("//input[@placeholder='Create New Folder']")).sendKeys(sFolderName);
		Actions action = new Actions(driver);

		action.sendKeys(Keys.ENTER).perform();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='" + sFolderName + "']")));
		driver.findElement(By.xpath("//label[text()='" + sFolderName + "']")).click();
		Reporter.addStepLog("User Creates Folder as" + sFolderName);
		Thread.sleep(4000);

		javascript_click(ReviewStatustoggle, "ReviewStatustoggle");

		javascript_click(ReviewStatustoggle, "ReviewStatustoggle");
		// form[@id='status-form']/select

		By ReviewStatusDrpdown = By.xpath("//form[@id='status-form']/select");
		By Reviewoptions = By.xpath("//option[text()='" + typeofreviewopts + "']");

		click(ReviewStatusDrpdown, "Review Status DropDown");
		click(Reviewoptions, "Desired Review Status As " + typeofreviewopts);

		// Select reviewoptions= new Select(driver.findElement(reviewopt));
		// reviewoptions.selectByVisibleText("'" + typeofreviewopts + "'");
		type(Comments, Comment, "Comment Field");

		SelCommands.captureScreenshot();

		click(Save, "Save Button");
	}

	public static void thenuserseescopiedfolder() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 240);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Copy')][1]")));
		WebElement copyfolder = driver.findElement(By.xpath("//label[contains(text(),'Copy')][1]"));

		Thread.sleep(6000);

		if (copyfolder.getText().contains("Copy")) {

			Reporter.addStepLog("User sees Copied Folder with label" + copyfolder.getText());
		}

		else {

			Reporter.addStepLog("User does not sees Copied Folder");
		}

	}

	public static void thenuserseefolderrenamed() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 240);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//label[contains(text(),'" + sParentFolderName + "')]")));

		WebElement userenamed = driver.findElement(By.xpath("//label[contains(text(),'" + sParentFolderName + "')]"));

		if (userenamed.getText().equals(sParentFolderName)) {

			Reporter.addStepLog("User sees Folder Renamed as " + sParentFolderName);
		}

		else {

			Reporter.addStepLog("User does not sees Folder Renamed");
		}

	}

}
