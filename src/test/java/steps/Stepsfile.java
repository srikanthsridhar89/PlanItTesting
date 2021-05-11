package steps;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bean.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.cucumber.listener.Reporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pom.Contact;
import pom.Home;
import pom.Shop;

import utilities.JsonReader;
import utilities.SelCommands;
import net.bytebuddy.utility.RandomString;

import static utilities.SelCommands.*;

public class Stepsfile {
	private static final String String = null;
	static WebDriver driver;
	static SelCommands sel = new SelCommands(driver);
	private ContactConfig contactConfig = new ContactConfig();
	private EnvironmentConfig environmentConfig = new EnvironmentConfig();

	public Stepsfile() {
		ObjectMapper obj = new ObjectMapper();
		try {

			environmentConfig = obj.readValue(JsonReader.getFile("Environment"), EnvironmentConfig.class);
			contactConfig = obj.readValue(JsonReader.getFile("Contact"), ContactConfig.class);

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	// <<===================================Common Steps===================================>>

	@Given("^User launches the application$")
	public void user_launches_the_application() throws FileNotFoundException, InterruptedException {
		openbrowser(environmentConfig);
		Home.verify_login();

	}

	@Then("^quit browser$")
	public void quit_browser() {
		sel.quitBrowser();
	}

	// <<===================================Contact Steps===================================>>

	@When("^User navigates to contact page$")
	public void user_navigates_to_contact_page() {

		Contact.user_navigates_contactpage();
	}
	
	@When("^User clicks on submit button in contactpage$")
	public void user_clicks_on_submit_button_contactpage() {
		Contact.user_clicks_submit();
		
	}

	
	@Then("^User validates error message for nodata entered$")
	public void user_validates_error_message_for_nodata_entered() {
		Contact.user_validates_errormessage_nodata();
		
	}
	
	@Then("^User validates error message for invalid entered$")
	public void user_validates_error_message_for_invalid_entered() {
		Contact.user_validates_errormessage_invaliddata();
		
	}
	
	@Then("^User validates successful submission message$")
	public void user_validates_successful_submission_message() {
		
		Contact.user_validates_successful_submission_message(contactConfig);
		
	}
	
	@When("^User populate mandatory fields$")
	public void user_populate_mandatory_field() {
		Contact.user_enters_mandatoryfield_contactpage(contactConfig);

	}
	
	
	@When("^User populate mandatory fields with invalid data$")
	public void user_populate_mandatory_field_invalid_data() {
		Contact.user_enters_mandatoryfield_contactpage_invaliddata(contactConfig);

	}
	
	
	@Then("^User validates error are gone$")
	public void user_validates_error_are_gone() {
		Contact.user_validates_error_are_gone();
	}
	
	
	
	// <<===================================Shop Steps===================================>>
	
	@When("^User navigates to shop page$")
	public void user_navigates_to_shop_page() {

		Shop.user_clicks_shoptab();
	}
	
	@When("^User clicks buy button 2 times on FunnyCow$")
	public void user_clicks_buy_button_2_times_funnycow() {
		
		Shop.user_clicks_buy_button_2_times_on_funnycow();
	}
	
	
	@When("^User clicks buy button 1 times on Fluffybunny$")
	public void user_clicks_buy_button_2_times_Fluffybunny() {
		
		Shop.user_clicks_buy_button_1_times_on_fluffybunny();
	}
	
	
	
	
	
	@Then("^user sees items added in cart$")
	public void user_sees_items_added_cart() {
		Shop.user_sees_items_added_in_cart();
	}
	
	
}
