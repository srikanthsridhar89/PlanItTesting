package pom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bean.ContactConfig;

import com.cucumber.listener.Reporter;
import utilities.SelCommands;

public class Contact extends SelCommands {

	private static By forenameField = By.cssSelector("input#forename");
	private static By surnameField = By.cssSelector("input#surname");
	private static By emailField = By.cssSelector("input#email");
	private static By telephoneField = By.cssSelector("input#telephone");

	private static By messageField = By.id("message");
	private static By submitField = By.xpath("//a[@class='btn-contact btn btn-primary']");

	private static By forenameErrorMessage = By.cssSelector("span#forename-err");
	private static By emailErrorMessage = By.cssSelector("span#email-err");
	private static By messageError = By.cssSelector("span#message-err");
	private static By telephoneError=By.cssSelector("span#telephone-err");
		
	private static By mandatoryFieldText = By
			.xpath("//span[contains(text(),'*')]/following::span[contains(@id,'err')]");
	private static By contactTab = By.xpath("//*[text()='Contact']");
	private static By alertSuccessMessage=By.xpath("//div[@class='alert alert-success']");

	public static String sErrorMessage = "";

	WebDriverWait wait = new WebDriverWait(driver, 60);

	public Contact(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void user_clicks_submit() {
		try {
			click(submitField, "Submit Field");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void user_navigates_contactpage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(contactTab));
			click(contactTab, "ContactTab Field");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	
	
	public static void user_validates_errormessage_invaliddata() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(mandatoryFieldText));
			

			List<WebElement> sManadatoryFieldItems = driver.findElements(mandatoryFieldText);
			int size = sManadatoryFieldItems.size();
			Reporter.addStepLog("User sees " + size + " errorfield");

			for (int i = 0; i < size; i++) {

				sErrorMessage = sManadatoryFieldItems.get(i).getText();
				List<String> li = new ArrayList<String>();
				li.add(sErrorMessage);

				if (li.toString().contains(getElementString(emailErrorMessage)) || li.toString().contains(getElementString(telephoneError))) {

					Reporter.addStepLog("User sees error message as:" + li.toString());

				} else {
					Reporter.addStepLog("User does not  sees error message");

				}

			}
			captureScreenshot("ErrorMessage Invalid data");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	public static void user_validates_errormessage_nodata() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(forenameErrorMessage));
			String forenameErrorText = getElementString(forenameErrorMessage);
			String emailErrorText = getElementString(emailErrorMessage);
			String messageErrorText = getElementString(messageError);

			List<WebElement> sManadatoryFieldItems = driver.findElements(mandatoryFieldText);
			int size = sManadatoryFieldItems.size();
			Reporter.addStepLog("User sees " + size + " errorfield");

			for (int i = 0; i < size; i++) {

				sErrorMessage = sManadatoryFieldItems.get(i).getText();
				List<String> li = new ArrayList<String>();
				li.add(sErrorMessage);

				if (li.toString().contains(forenameErrorText) || li.toString().contains(emailErrorText)
						|| li.toString().contains(messageErrorText)) {

					Reporter.addStepLog("User sees error message as:" + li.toString());

				} else {
					Reporter.addStepLog("User does not  sees error message");

				}

			}
			captureScreenshot("ErrorMessage blankdata");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void user_enters_mandatoryfield_contactpage_invaliddata(ContactConfig contactConfig) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(forenameField));
			type(forenameField, contactConfig.getFornameField(), "Forename Field");
			type(surnameField, contactConfig.getSurnameField(), "Surname Field");
			type(emailField, contactConfig.getErrorEmailMailField(), "Email Field");
			type(messageField, contactConfig.getMessageField(), "Message Field");
			type(telephoneField, contactConfig.getErrorTelephoneField(), "Telephone Field");

			captureScreenshot("Contact Form Details");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void user_enters_mandatoryfield_contactpage(ContactConfig contactConfig) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(forenameField));
			type(forenameField, contactConfig.getFornameField(), "Forename Field");
			type(surnameField, contactConfig.getSurnameField(), "Surname Field");
			type(emailField, contactConfig.getEmailField(), "Email Field");
			type(messageField, contactConfig.getMessageField(), "Message Field");
			type(telephoneField, contactConfig.getTelephoneField(), "Telephone Field");

			captureScreenshot("Contact Form Details");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void user_validates_successful_submission_message(ContactConfig contactConfig) {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(alertSuccessMessage));
		
		String successmessagealert = getElementString(alertSuccessMessage);
		
				
				
			

		if(successmessagealert.contains("we appreciate your feedback.")){
			
			Reporter.addStepLog("User sees successful alert message :" +successmessagealert );
		}
		else {
			
			Reporter.addStepLog("User does not sees successful alert message");
		}
		captureScreenshot("Successful Message Validation");
		
	}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void user_validates_error_are_gone() {
		try {
			Thread.sleep(3000);
			List<WebElement> sManadatoryFieldItems = driver.findElements(mandatoryFieldText);
			int size = sManadatoryFieldItems.size();

			if (size == 0) {
				Reporter.addStepLog("User validates error are gone");
			} else {
				Reporter.addStepLog("User does not validates error are gone");
			}
			captureScreenshot("Validate error are gone");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
