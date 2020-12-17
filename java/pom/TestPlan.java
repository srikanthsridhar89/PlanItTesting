package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import junit.framework.Assert;
import utilities.Selcommands;

public class TestPlan  extends Selcommands {

	public TestPlan(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public static void click_testplantab() {
		By PlanTab=By.xpath("//a[@id='testPlans']");
		click(PlanTab, "Test Plan Tab");
		
	}

	
	public static void userselecttestsuite() {
		
By functionaltest=By.xpath("//div[@class='avatar-medium']/following::h3[text()='Functional Test Suites']");
		
click(functionaltest, "Functional Test Suites");

		By Desiredtestsuite=By.xpath("//a[text()='Functional Testing - Scheduling']");
		WebElement ele=driver.findElement(Desiredtestsuite);
		Selcommands.ScrollintoView(ele);
		
		click( Desiredtestsuite, "Functional Testing - Scheduling");
	}
	
	public static void click_createnewtestplan() {
		By Create_NewPlan=By.xpath("//button[@id='createNewTestPlan']");
		click(Create_NewPlan, "Create New Plan");
		
	}
	
	
	//p[text()='Open Test Plans ']
	
	
	
	public static void userredirectstocreateplan() {
		
		WebDriverWait wait = new WebDriverWait(driver,180);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-agilea.btn-danger")));
		
		String btn = getElementString(By.cssSelector(".btn.btn-agilea.btn-danger"));
		Assert.assertEquals("Delete Test Plan", btn);
		
		Reporter.addStepLog("User Redirects to Create Plan Page Successful");
	}
	
	
	
	public static void filldetails_testplan(String Name,String Descrition) throws InterruptedException {
		By Namefield=By.cssSelector(".editable-input-text");
		By Description=By.xpath("//textarea[@name='custom']");
		
		
		type(Namefield, Name, "Name Field");
		
		Thread.sleep(4000);
type(Description, Descrition, "Description Field");
		
		
	}
	
	
	
	
	
}
