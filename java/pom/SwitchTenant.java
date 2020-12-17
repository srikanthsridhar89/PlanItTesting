package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import junit.framework.Assert;
import utilities.Selcommands;

public class SwitchTenant extends Selcommands {

	public SwitchTenant(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void userclicksonswitchtenant() {

		By HomeDropDown = By.xpath("//button[@id='bdd_menu_trigger_button_id']");
		By SwitchTenant = By.xpath("//a[contains(text(),'Switch Tenant')]");
		click(HomeDropDown, "Home Drop Down");
		click(SwitchTenant, "Switch Tenant");

	}

	public static void userredirectstoswitchtenant() {
		String btn = getElementString(By.xpath("//h2[text()='Welcome back. Please select a tenant:']"));
		Assert.assertEquals("Welcome back. Please select a tenant:", btn);
		Reporter.addStepLog("User Redirected to Switch Tenant  Successful");

	}

	public static void userselectsdesiredtenant() {
		By DesiredTenant = By.xpath("//*[@alt='Kroger logo']");

		click(DesiredTenant, "Desired Tenant");
	}

}