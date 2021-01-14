package pom;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import junit.framework.Assert;
import utilities.SelCommands;

public class TestPlan  extends SelCommands {

	public TestPlan(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public static void clickTestPlanTab() throws InterruptedException {
		Thread.sleep(4000);
		By PlanTab=By.xpath("//a[@id='testPlans']");
		click(PlanTab, "Test Plan Tab");
		
	}
	
	
	
	
	public static void userSelectTestSuite() {
		
By functionaltest=By.xpath("//div[@class='avatar-medium']/following::h3[text()='Functional Test Suites']");
		
click(functionaltest, "Functional Test Suites");

		By Desiredtestsuite=By.xpath("//a[text()='Functional Testing - Scheduling']");
		WebElement ele=driver.findElement(Desiredtestsuite);
		SelCommands.ScrollintoView(ele);
		
		click( Desiredtestsuite, "Functional Testing - Scheduling");
	}
	
	public static void clickCreateNewTestPlan() {
		By Create_NewPlan=By.xpath("//button[@id='createNewTestPlan']");
		click(Create_NewPlan, "Create New Plan");
		
	}
	
	
public static void userEditsTestPlanDetails(String Name, String description) throws InterruptedException {
	Thread.sleep(4000);
	By PlanTab=By.xpath("//a[@id='testPlans']");
	click(PlanTab, "Test Plan Tab");
			
			By TestPlanDetails=By.xpath("(//td[contains(text(),'" + Name + "')])[1]");
			
			click(TestPlanDetails, "TestPlanDetails");
			
			By EditTestPlan=By.xpath("//a[@id='editTestPlanId']");
			SelCommands.javascript_click(EditTestPlan, "Edit TestPlan");
			
			By Description=By.xpath("//textarea[@placeholder='Enter a Description']");
			
			type(Description, description, "Description Field");
			
			By SelectPersona=By.xpath("//div[@class='persona']//input");
			click( SelectPersona, "Select Persona");
			
		
			
			
}
	
	
	
	public static void userRedirectsToCreatePlan() {
		
		WebDriverWait wait = new WebDriverWait(driver,180);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-agilea.btn-danger")));
		
		String btn = getElementString(By.cssSelector(".btn.btn-agilea.btn-danger"));
		Assert.assertEquals("Delete Test Plan", btn);
		
		Reporter.addStepLog("User Redirects to Create Plan Page Successful");
	}
	
	
	

	
	
	
	
	public static void fillDetailsOfTestPlan(String Name, String Descrition) throws InterruptedException {
		By NameField_Edit=By.xpath("//div[@class='react-form editable-input new']");
		By Namefield=By.cssSelector(".editable-input-text");
		By Description=By.xpath("//textarea[@name='custom']");
		
		click( NameField_Edit, "Name Field Edit");
		type(Namefield, Name, "Name Field");
		
		Thread.sleep(4000);
type(Description, Descrition, "Description Field");
		

By SelectPersona=By.xpath("//div[@class='persona']//input");
click( SelectPersona, "Select Persona");
By SelectScenario=By.xpath("(//div[text()='Select Scenarios']/following::input[@type='checkbox'])[1]");
click( SelectScenario, "Select Scenario");
		
	}
	
	public static void clickCommitTestPlan() {
		
		By CommitTestPlan=By.xpath("//button[@id='commitTestPlan']");
		click( CommitTestPlan, "CommitTestPlan");
	}
	
	
	public static void clickUpdateTestPlan() throws InterruptedException {
		Thread.sleep(5000);
		By UpdateTestPlan=By.xpath("//button[@id='updateTestPlanId']");
		
		click(UpdateTestPlan, "UpdateTestPlan");
	
	}
	
	
	public static void clickDeleteTestPlan() throws IOException {
		By DeleteTestPlan=By.xpath("//button[text()='Delete Test Plan']");
		click( DeleteTestPlan, "DeleteTestPlan");
		
		Alert alert_box = driver.switchTo().alert();
		alert_box.accept(); 
		
		SelCommands.captureScreenshot();
	}


	
}
