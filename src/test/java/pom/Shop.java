package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import utilities.SelCommands;

public class Shop extends SelCommands {
	
	


	private static By shopTab = By.xpath("//*[text()='Shop']");
	private static By btn_buy_FunnyCow=By.xpath("//*[text()='Funny Cow']//following::a[1]");
	private static By btn_buy_FluffyBunny=By.xpath("//*[text()='Fluffy Bunny']//following::a[1]");
	
	private static By txt_cartCount=By.xpath("//span[contains(@class,'cart-count')]");
	
	
	


	

	
	public Shop(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	} 
	
	
	public static void user_clicks_buy_button_1_times_on_fluffybunny() {
		try {
			//test commevct
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(btn_buy_FluffyBunny));
			Actions action = new Actions(driver);
			WebElement buy_FluffyBunny=driver.findElement(btn_buy_FluffyBunny);
			action.click(buy_FluffyBunny).build().perform();
			Reporter.addStepLog("User clicks on FluffyBunny buy button"	);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

	
	public static void user_clicks_buy_button_2_times_on_funnycow() {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(btn_buy_FunnyCow));
			Actions action = new Actions(driver);
			WebElement buy_FunnyCow=driver.findElement(btn_buy_FunnyCow);
			action.doubleClick(buy_FunnyCow).build().perform();
			Reporter.addStepLog("User double clicks on FunnyCow buy button"	);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void user_sees_items_added_in_cart() {
	try {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(txt_cartCount));
		
		String cartcount = getElementString(txt_cartCount);
		
		System.out.println("value is :" +cartcount);
		
		if(!cartcount.isEmpty()) {
			Reporter.addStepLog("User sees item added in the cart and count is: "+cartcount);
			
			
		}
		else {
			Reporter.addStepLog("User does not sees item added in the cart");
		}
		captureScreenshot("Cart Count");
	
	}
	
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public static void user_clicks_shoptab() {
		try {
			click(shopTab, "ShopTab");
			captureScreenshot("Shop DetailPage");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	

}
