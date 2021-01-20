package pom;

import java.io.IOException;

import bean.PersonaConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.SelCommands;

public class Persona  extends SelCommands {

	public Persona(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void userClicksOnDelete() {
		By Delete=By.xpath("//*[@id='delete-persona-image-id']");
		click(Delete, "Delete");

	}
	public static void userEditsPersonaDetails(String label) {

		By Persona_edit=By.xpath("//*[contains(@class,'icon-edit-persona')]");
		By Label = By.xpath("//input[@name='label']");
		click(Persona_edit, "Persona Edit");

		type(Label, label, "Label Field");
	}


	public static void userSelectsPersonaCreated() {
		By Select_Persona=By.xpath("//span[contains(text(),'TestPersona')]");
		click(Select_Persona, "Desired Persona");
	}
	public  static void userClicksOnPersonaWorkspace() throws InterruptedException {

		Thread.sleep(4000);

		TestSuite.userClicksOnRegressionTestSuite();
		TestSuite.userSelectDesiredTestSuiteCreated();
		By Persona_Tab=By.xpath("//a[@id='personas']");


		click(Persona_Tab, "Persona Tab");


	}


	public static void userClicksOnSubmit() {
		try {
			By Submit=By.xpath("//button[@type='submit']");
			SelCommands.javascript_click(Submit, "Submit button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void userClicksOnNewPersona() {

		By NewPersona=	By.xpath("//*[@id='createPersonaIconId']");
		click(NewPersona, "New Persona");
	}



	public static void userFillsPersonaDetails(PersonaConfig personaConfig) throws IOException {
		By buildfromscratch = By.xpath("//div[text()='I would like to build my Persona from scratch']");
		click(buildfromscratch, "build from Scratch");
		By Label = By.xpath("//input[@name='label']");
		By Description = By.xpath("//textarea[@name='description']");
		By Activity_Profile = By.xpath("//input[@data-id='Activity Profile']");
		By Adjustment_Role = By.xpath("//input[@data-id='Adjustment Rule']");
		type(Label, personaConfig.getPersonaLabel(), "Label Field");
		type(Description, personaConfig.getPersonaDescription(), "Description Field");
		type(Activity_Profile, personaConfig.getPersonaActProfile(), "Activity Profile Field");
		type(Adjustment_Role, personaConfig.getPersonaAdjRule(), "Adjustment Rule Field");
		SelCommands.captureScreenshot();
	}

	public static void userClicksOnSubmitInCreatePersonaPage() {
		try {
			By Submit = By.xpath("//button[@type='submit']");
			click(Submit, "Submit in New Persona Page");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
