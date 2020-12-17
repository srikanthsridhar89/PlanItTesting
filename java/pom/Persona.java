package pom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.When;
import utilities.Selcommands;

public class Persona  extends Selcommands {

	public Persona(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static void userclicksondelete() {
		By Delete=By.xpath("//*[@id='delete-persona-image-id']");
		click(Delete, "Delete");
		
	}
	public static void user_editpersonadetails(String label) {
		
		By Persona_edit=By.xpath("//*[contains(@class,'icon-edit-persona')]");
		By Label = By.xpath("//input[@name='label']");
		click(Persona_edit, "Persona Edit");
		
		type(Label, label, "Label Field");
	}
	
	
	public static void user_selectpersonacreated() {
		By Select_Persona=By.xpath("//span[contains(text(),'TestPersona')]");
		click(Select_Persona, "Desired Persona");
	}
	public  static void userclicksonpersonaworkspace() throws InterruptedException {
		
		Thread.sleep(4000);

		TestSuite.userclicksonregressiontestsuite();
		TestSuite.userselectdesiredtestsuitecreated();
		By Persona_Tab=By.xpath("//a[@id='personas']");
		
		
		click(Persona_Tab, "Persona Tab");

		
	}
	
	
	public static void userclick_submit() {
		By Submit=By.xpath("//button[@type='submit']");
		
		
		Selcommands.javascript_click(Submit, "Submit button");
		
		
		
	}

public static void userclicksonnewpersona() throws InterruptedException {
		
		Thread.sleep(4000);	
		By NewPersona=	By.xpath("//*[@id='createPersonaIconId']");		
		click(NewPersona, "New Persona");
	} 
	
	
	
	public static void  userfillspersonadetails(String label,String description,String ActivityProfile,String Adjustmentrule,String CategoryProfile) throws IOException { 
		By buildfromscratch = By.xpath("//div[text()='I would like to build my Persona from scratch']");
		click(buildfromscratch, "build from Scratch");

		By Label = By.xpath("//input[@name='label']");
		By Description = By.xpath("//textarea[@name='description']");
		By Activity_Profile = By.xpath("//input[@data-id='Activity Profile']");
		By Adjustment_Role = By.xpath("//input[@data-id='Adjustment Rule']");
	

		type(Label, label, "Label Field");

		type(Description, label, "Description Field");

		type(Activity_Profile, ActivityProfile, "Actvity Profile Field");
      type(Adjustment_Role, Adjustmentrule, "Adjustmentrule Field");
      Selcommands.captureScreenshot();
	}

	public static void userclicksonsubmitincreatepersonapage() {
		By Submit = By.xpath("//button[@type='submit']");
		click(Submit, "Submit in New Persona Page");

}



	

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	
	
	
	
}
