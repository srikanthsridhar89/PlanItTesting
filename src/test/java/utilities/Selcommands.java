package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.cucumber.listener.Reporter;

public class Selcommands {
//	public static final String ImagesPath = null;
	public static WebDriver driver;
	public Selcommands(WebDriver driver) {
		this.driver = driver;
	}

	public static void openbrowser(String url) throws FileNotFoundException {

		try {
			System.setProperty("webdriver.chrome.driver","/Users/admin/Documents/Agilea/OneDrive - Agilea Solutions, Inc/Automation/chromedriver");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			Reporter.addStepLog("welcome to " + url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void highlightWebElement(WebElement webElement) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", webElement,
					"color: black; border: 4px solid red;");
		} catch (Exception e) {
			Reporter.addStepLog("Element not highlighted");
		}
	}

	public void quitBrowser() {
		driver.close();
		driver.quit();
	}

	public void captureScreenshot(String filename) throws IOException {
		String Base64StringofScreenshot = "";
		String path = new String("/Users/admin/Documents/Agilea/OneDrive - Agilea Solutions, Inc/Automation/TestAssurePro/target/screenshots/" + filename + ".png");
		TakesScreenshot oScn = (TakesScreenshot) driver;
		File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(oScnShot);
		Base64StringofScreenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
		File oDest = new File(path);
		try {
			FileUtils.copyFile(oScnShot, oDest);
			Reporter.addScreenCaptureFromPath(path, "hello123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void captureScreenshot() throws IOException {
		String Base64StringofScreenshot = "";
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
		Date date = new Date();
		System.out.println(formatter.format(date));
		String path = new String(
				"/Users/admin/Documents/Agilea/OneDrive - Agilea Solutions, Inc/Automation/TestAssurePro/target/screenshots/"
						+ formatter.format(date) + ".png");
		TakesScreenshot oScn = (TakesScreenshot) driver;
		File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(oScnShot);
		Base64StringofScreenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
		File oDest = new File(path);
		try {
			FileUtils.copyFile(oScnShot, oDest);

			Reporter.addScreenCaptureFromPath(path, "hello123");
//Reporter.("Details", MediaEntityBuilder.createScreenCaptureFromPath(Paths.get("").toAbsolutePath().toString() + "/screenshotFolder/screenshot.png").build());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getElementString(By Locator) {

		return driver.findElement(Locator).getText();

	}

	public static void clickElement(By signinlink, String element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(signinlink));
			driver.findElement(signinlink).click();
			Reporter.addStepLog("Successfully clicked on element " + element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void enterText(By wb, String text) {
		try {
			highlightWebElement(driver.findElement(wb));
			driver.findElement(wb).sendKeys(text);
			Reporter.addStepLog(" Entered Text as  " + text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<WebElement> getElements(By listOfElements) {
		return driver.findElements(listOfElements);
	}

	public static void selectByIndex(By by, int index) {
		try {
			waitForElementPresent(by, 10);
			Select select = new Select(driver.findElement(by));
			select.selectByIndex(index);
			Reporter.addStepLog("Selected " + index + " Index list from Drop Down");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void scrollInToViewElement(By by) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(by));
			Reporter.addStepLog("Scrolling down to Element");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void Drag_Drop(By source, By target) {
		try {
			Actions actions = new Actions(driver);
			actions.dragAndDrop(driver.findElement(source), driver.findElement(target)).build().perform();
			Reporter.addStepLog("Element is dragged from" + source + " and dropped to" + target);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void submit(By by) {
		try {
			driver.findElement(by).submit();
			Reporter.addStepLog("Submitting the Form");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public static boolean isAlertPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void click(By by, String fieldName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 240);
			wait.until(ExpectedConditions.elementToBeClickable(by));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			driver.findElement(by).click();

		} catch (Exception e) {
			javascript_click(by, fieldName);
		}

		Reporter.addStepLog("User Clicks on " + fieldName);

	}

	public static void javascript_click(By by, String fieldName) {
		try {
			waitForElementPresent(by, 10);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(by));
			Reporter.addStepLog("User Clicks on " + fieldName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ScrollintoView(WebElement ele) {

		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void waitForElementPresent(By by, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);

			wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getTitle() {
		String title = null;
		try {
			title = driver.getTitle();
			Reporter.addStepLog("Getting Title of Window" + title);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return title;
	}

	
	public static void getPageSource()
	{
		String pagesource = null;
		try {
			pagesource = driver.getPageSource();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.addStepLog ("Getting PageSource"+pagesource);
	}
	public static String getText(By by, String fieldName) {
		String text = null;
		try {
			waitForElementPresent(by, 10);
			text = driver.findElement(by).getText();
			Reporter.addStepLog("Field Name is :" + text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return text;
	}

	public static String getAttribute(By by, String attributeName, String fieldName) {
		String attributeValue= null;
		try {
			waitForElementPresent(by, 10);
			attributeValue = driver.findElement(by).getAttribute(attributeName);

			Reporter.addStepLog("Getting Text" + attributeValue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return attributeValue;
	}

	public static boolean isDisplayed(By by, String fieldName) {
		boolean visible = false;
		try {
			waitForElementPresent(by, 10);
			visible = driver.findElement(by).isDisplayed();
			Reporter.addStepLog("Checking " + fieldName + "is Displayed");

		} catch (Exception e) {
			visible = false;
		}
		return visible;
	}

	public static boolean isEnabled(By by, String fieldName) {
		boolean editable = false;
		try {
			waitForElementPresent(by, 60);
			editable = driver.findElement(by).isEnabled();

			Reporter.addStepLog("Checking " + fieldName + "is Enabled");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return editable;
	}

	public static void alertAccept() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();

			Reporter.addStepLog("Alert Accepted");

		} catch (Exception e) {
			Reporter.addStepLog("Alert Not Accepted");
		}
	}

	public static void closeWindow() {
		try {
			driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.addStepLog("Closing Current Window ");

	}

	
	public void refreshPage() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.addStepLog("Refreshing Page");
	}

	public void navigate_back() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.addStepLog("Navigating to back");
	}

	public void navigate_forward() {
		driver.navigate().forward();
		Reporter.addStepLog("Navigating to forword");

	}

	public static Object[] getAllWindowObjects() {
		Set<String> windows = driver.getWindowHandles();
		Object[] window = windows.toArray();
		return window;
	}

	public static void type(By by, String value, String fiedlName) {

		waitForElementPresent(by, 60);
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
		Reporter.addStepLog("Setting " + fiedlName + " value As " + value);

	}
	
	
	public static void setTextinAlertBox(String alertText)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().sendKeys(alertText);
		Reporter.addStepLog("Setting text into alert"+alertText);

	}

}
