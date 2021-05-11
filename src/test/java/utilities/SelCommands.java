package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Set;

import bean.EnvironmentConfig;
import lombok.Data;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;
@Data
public class SelCommands {
//	public static final String ImagesPath = null;
	public static WebDriver driver;

	public SelCommands(WebDriver driver) {
		this.driver = driver;
	}



	public static void openbrowser(EnvironmentConfig environmentConfig) throws FileNotFoundException {
		
String driverlocation=System.getProperty("user.dir")+ "\\src"+"\\test"+"\\resources"+"\\drivers"+"\\chromedriver.exe";
//System.setProperty("webdriver.chrome.driver","C:\\Users\\Srikanth\\Documents\\testassure_selenium (1)\\testassure_selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
System.setProperty("webdriver.chrome.driver",driverlocation);

		//Uncomment the below step to run the tests on Chrome browser
			driver = new ChromeDriver();

		//Uncomment the below step to run the tests on headless browser
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless", "--disable-gpu","--ignore-certificate-errors");
//		options.addArguments("headless");
//		driver = new ChromeDriver(options);
		
		driver.get(environmentConfig.getUrl());
		driver.manage().window().maximize();
		Reporter.addStepLog("Navigated to " + environmentConfig.getUrl());
	}

	public void quitBrowser() {
		driver.close();
		driver.quit();
	}

	

	public static String getElementString(By Locator) {

		return driver.findElement(Locator).getText();

	}

	public static void clickElement(By signinlink, String element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(signinlink));
		driver.findElement(signinlink).click();
		Reporter.addStepLog("User clicked on " + element);
	}
	
	public static void clickElementAndWait(By signinlink, String element) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(signinlink));
		driver.findElement(signinlink).click();
		Thread.sleep(2000);
		Reporter.addStepLog("User clicked on " + element);
	}

	public static void enterText(By wb, String text) {
		driver.findElement(wb).sendKeys(text);
		Reporter.addStepLog("User entered text as  " + text);
	}

	public static List<WebElement> getElements(By listOfElements) {

		return driver.findElements(listOfElements);
	}

	public static void selectByIndex(By by, int index) {
		waitForElementPresent(by, 10);
		Select select = new Select(driver.findElement(by));
		select.selectByIndex(index);
		Reporter.addStepLog("Selected " + index + " index list from Drop Down");
	}

	public static void scrollInToViewElement(By by) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(by));
		Reporter.addStepLog("Scrolling down to Element");
	}

	public static void Drag_Drop(By source, By target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(driver.findElement(source), driver.findElement(target)).build().perform();
		Reporter.addStepLog("Element is dragged from" + source + " and dropped to" + target);
	}

	public static void submit(By by) {
		driver.findElement(by).submit();
		Reporter.addStepLog("Submitting the form");

	}

	/*
	 * public static void captureScreenshot() throws IOException { String
	 * Base64StringofScreenshot = ""; SimpleDateFormat formatter = new
	 * SimpleDateFormat("ddMMyyyyHHmmss"); Date date = new Date();
	 * System.out.println(formatter.format(date)); String path = new String(
	 * "./target/screenshots/" + formatter.format(date) + ".png"); TakesScreenshot
	 * oScn = (TakesScreenshot) driver; File oScnShot =
	 * oScn.getScreenshotAs(OutputType.FILE); byte[] fileContent =
	 * FileUtils.readFileToByteArray(oScnShot); Base64StringofScreenshot =
	 * "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
	 * File oDest = new File(path); try { FileUtils.copyFile(oScnShot, oDest);
	 * Reporter.addScreenCaptureFromPath(path, "hello123"); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */
	
	public  static void captureScreenshot(String filename) throws IOException {
		   String Base64StringofScreenshot = "";
		   String imagePath = new String(
		         "./target/screenshots/" + filename + ".png");
		   String reportPath = new String(
		         "../screenshots/" + filename + ".png");
		   TakesScreenshot oScn = (TakesScreenshot) driver;
		   File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		   byte[] fileContent = FileUtils.readFileToByteArray(oScnShot);
		   Base64StringofScreenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
		   File oDest = new File(imagePath);
		   try {
		      FileUtils.copyFile(oScnShot, oDest);
		      Reporter.addScreenCaptureFromPath(reportPath, filename);
		   } catch (Exception e) {
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
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(by));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			driver.findElement(by).click();

		} catch (Exception e) {
			javascript_click(by, fieldName);
		}
		Reporter.addStepLog("User clicks on " + fieldName);

	}

	public static void javascript_click(By by, String fieldName) {
		waitForElementPresent(by, 10);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(by));
		Reporter.addStepLog("User clicks on " + fieldName);
	}

	public static void ScrollintoView(WebElement ele) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public static void waitForElementPresent(By by, int time) {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public static String getTitle() {
		String title = driver.getTitle();
		Reporter.addStepLog("Getting title of window" + title);

		return title;
	}

	
	public static void getPageSource()
	{
		String pagesource=driver.getPageSource();
		Reporter.addStepLog ("Getting PageSource"+pagesource);
	}
	public static String getText(By by, String fieldName) {
		waitForElementPresent(by, 10);
		String text = driver.findElement(by).getText();
		Reporter.addStepLog("Field Name is :" + text);

		return text;
	}

	public static String getAttribute(By by, String attributeName, String fieldName) {
		waitForElementPresent(by, 10);
		String attributeValue = driver.findElement(by).getAttribute(attributeName);

		Reporter.addStepLog("Getting text" + attributeValue);
		return attributeValue;
	}

	public static boolean isDisplayed(By by, String fieldName) {
		boolean visible = false;
		try {
			waitForElementPresent(by, 10);
			visible = driver.findElement(by).isDisplayed();
			Reporter.addStepLog("Checking " + fieldName + "is displayed");

		} catch (Exception e) {
			visible = false;
		}
		return visible;
	}

	public static boolean isEnabled(By by, String fieldName) {
		waitForElementPresent(by, 60);
		boolean editable = driver.findElement(by).isEnabled();

		Reporter.addStepLog("Checking " + fieldName + "is Enabled");

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
		driver.close();
		Reporter.addStepLog("Closing Current Window ");

	}

	
	public void refreshPage() {
		driver.navigate().refresh();
		Reporter.addStepLog("Refreshing Page");
	}

	public void navigate_back() {
		driver.navigate().back();
		Reporter.addStepLog("Navigating to back");
	}

	public void navigate_forward() {
		driver.navigate().forward();
		Reporter.addStepLog("Navigating to forward");

	}

	public static Object[] getAllWindowObjects() {
		Set<String> windows = driver.getWindowHandles();
		Object[] window = windows.toArray();
		return window;
	}

	public static void type(By by, String value, String fieldName) {

		waitForElementPresent(by, 60);
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
		Reporter.addStepLog("Setting " + fieldName + " value As " + value);

	}
	
	
	public static void setTextinAlertBox(String alertText)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().sendKeys(alertText);
		Reporter.addStepLog("Setting text into alert"+alertText);

	}

}
