package pom;

import java.io.IOException;

import bean.PersonaConfig;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.SelCommands;

public class Persona  extends SelCommands {

	private static By delete =By.xpath("//*[@id='delete-persona-image-id']");
	private static By personaEdit =By.xpath("//*[contains(@class,'icon-edit-persona')]");
	private static By label = By.xpath("//input[@name='label']");
	private static By selectPersona =By.xpath("//span[contains(text(),'TestPersona')]");
	private static By personaTab =By.xpath("//a[@id='personas']");
	private static By newPersona =	By.xpath("//*[@id='createPersonaIconId']");
	private static By buildFromScratch = By.xpath("//div[text()='I would like to build my Persona from scratch']");
	private static By description = By.xpath("//textarea[@name='description']");
	private static By activityProfile = By.xpath("//input[@data-id='Activity Profile']");
	private static By adjustmentRole = By.xpath("//input[@data-id='Adjustment Rule']");
	private static By submit = By.xpath("//button[@type='submit']");

	public Persona(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void userClicksOnDelete() {

		click(delete, "Delete");
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public static void userEditsPersonaDetails(String label) {
		click(personaEdit, "Persona Edit");
		type(Persona.label, label, "Label Field");
	}


	public static void userSelectsPersonaCreated() {
		click(selectPersona, "Desired Persona");
	}

	public  static void userClicksOnPersonaWorkspace() throws InterruptedException {

		Thread.sleep(4000);
		TestSuite.userClicksOnRegressionTestSuite();
		TestSuite.userSelectDesiredTestSuiteCreated();
		click(personaTab, "Persona Tab");
	}


	public static void userClicksOnSubmit() {
		try {
			SelCommands.javascript_click(submit, "Submit button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void userClicksOnNewPersona() {
		click(newPersona, "New Persona");
	}



	public static void userFillsPersonaDetails(PersonaConfig personaConfig) throws IOException {
		click(buildFromScratch, "build from Scratch");
		type(label, personaConfig.getPersonaLabel(), "Label Field");
		type(description, personaConfig.getPersonaDescription(), "Description Field");
		type(activityProfile, personaConfig.getPersonaActProfile(), "Activity Profile Field");
		type(adjustmentRole, personaConfig.getPersonaAdjRule(), "Adjustment Rule Field");
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
