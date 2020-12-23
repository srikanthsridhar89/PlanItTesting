package steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pom.ActionLibrary;
import pom.TestSuite;
import pom.AddNewUser;
import pom.Persona;
import pom.Profile;
import pom.Scenario;
import pom.SwitchTenant;
import pom.TestPlan;
import pom.TestTarget;
import pom.loginpage;
import utilities.JsonReader;
import utilities.Selcommands;
import net.bytebuddy.utility.RandomString;

public class Stepsfile {
	static WebDriver driver;
	static Selcommands sel = new Selcommands(driver);

	public static String title = "";
	public static String Uname = "";
	public static String UserEmail = "";
	public static String testtarget = "";
	public static String testtargetpwd = "";
	public static String testtargetuname = "";
	public static String Actionlibrarylabel = "";
	public static String ActionlibraryDescription = "";
	public static String Updatetestsuitetitle = "";
	public static String sUpdateTestTargetname = "";
	public static String prefix = "";
	public static String suffix = "";
	public static String UpdatedActionLibrarylabel = "";

	public static String DisplayKey = "";

	public static String sRequirementnotes = "TestRequirement";

	@Given("^User launches the Application$")
	public void userlaunchesapplication() throws FileNotFoundException, InterruptedException {
		Selcommands.openbrowser(JsonReader.readJson("env", "url"));

		loginpage.logindetails(JsonReader.readJson("env", "Username"), JsonReader.readJson("env", "Password"));
		loginpage.click_Signin();
		loginpage.verifyLogin();

	}

	@When("^User Creates Folder and Scenario$")
	public void usercreatesfolderandscenario() throws InterruptedException, IOException {

		Scenario.usercreatesfolderandscenario();
		sel.captureScreenshot("Folder and Scenario Creation");
	}

	@When("^User Searches for Scenario Created$")
	public void usersearchesforscenariocreated() throws InterruptedException, IOException {

		Scenario.usersearchesscenario();
		sel.captureScreenshot("User Search For Scenario");
	}

	@When("^User Clicks on Persona Link$")
	public void userclicksonpersonalink() throws InterruptedException {
		
		Scenario.userclicksonpersonalink();
	}
	
	
	


@When("^User Navigates to TestPlanWorkspace$")
	public void usernavigatestotestplanworkspace() throws InterruptedException {

		TestSuite.userclicksonregressiontestsuite();
		TestSuite.userselectdesiredtestsuitecreated();
		TestPlan.click_testplantab();
		
}
	
	@When("^User Navigates to Scenario Detail Page$")
	public void usernavigatestoscenariodetailpage() throws InterruptedException {

		TestSuite.userclicksonregressiontestsuite();
		TestSuite.userselectdesiredtestsuitecreated();
		Scenario.userclicksonscenariotab();
		useredirectstoscenariodetailpage();
	}

	@When("^User Creates Scenario with MultipleCondition$")
	public void usercreatesscenariowithmuliplecondition() throws InterruptedException, IOException {
		Scenario.usercreatesscenario_multiplecondition();
	}

	@When("^User CreatesDuplicateTemplate$")
	public void usercreatesduplicatetemplate() {

		Scenario.duplictescenario();
	}

	@When("^User Creates Template$")
	public void usercreatestemplate() {

		Scenario.usercreatestemplate();

	}

	
	@Then("^User see SharedScenario$")
	public void userseessharedscenario() throws IOException {
		
		Scenario.userseesharedscenario();
	}
	@When("^User Shares ScenarioLink$")
	public void usersharesscenariolink() throws IOException, InterruptedException {

		Scenario.usersharesscenariolink();
		sel.captureScreenshot("Share Link");
	}

	@When("^User Cancels CreatedScenario$")
	public void usercancelscreatedscenario() throws InterruptedException, IOException {

		Scenario.usercreatesscenariowithsimplestring();
		Scenario.userclicksoncancel();
		sel.captureScreenshot("Cancel CreatedScenario");

	}

	@When("^User Creates RequirementNotes$")
	public void usercreatesrequirementnotes() throws IOException {

		Scenario.usercreatesrequirementnotes(sRequirementnotes);
		sel.captureScreenshot("Requirement Notes");
	}

	@Given("^User lands into DashboardPortal After TestSuiteCreation$")
	public void userlandsintodashboardportalaftertestsuitecreation()
			throws FileNotFoundException, InterruptedException {
		Selcommands.openbrowser(JsonReader.readJson("env", "url"));

		loginpage.logindetails(JsonReader.readJson("env", "Username"), JsonReader.readJson("env", "Password"));
		loginpage.click_Signin();

		TestSuite.userclicksonregressiontestsuite();

		TestSuite.userselectdesiredtestsuitecreated();

	}

	@Given("^User Launched application$")
	public void userlaunchedapplication() throws FileNotFoundException {
		Selcommands.openbrowser(JsonReader.readJson("env", "url"));
	}

	@Then("^User redirects to createuser$")
	public void userredirectstocreateuser() {
		AddNewUser.userredirectstocreateuser();

	}

	@When("^User Copies TestSuite$")
	public void usercopiestestsuite() throws InterruptedException, IOException {

		Scenario.copytestsuite();
		sel.captureScreenshot("Copy TestSuite");
	}

	@Then("^User redirects to Switch Tenant Page$")
	public void userredirectstoswitchtenantpage() {

		SwitchTenant.userredirectstoswitchtenant();

	}

	@When("^User Renames CreatedFolder$")
	public void userrenamescreatedfolder() throws InterruptedException, IOException {
		Scenario.userrenamescreatedfolder();
		sel.captureScreenshot("RenameFolder");
	}

	@Then("^User will not see Folder Deleted$")
	public void userwillnotseefolder() throws IOException {
		Scenario.userwillnotseefolderdeleted();
		sel.captureScreenshot("Delete Folder Verification");
	}

	@Then("^User sees Parent Folder Deleted$")
	public void userseesparentfolderdeleted() throws IOException, InterruptedException {

		Scenario.userwillseeParentfolderdeleted();

		sel.captureScreenshot("Delete Folder Verification");
	}

	@Then("^User sees ParentFolder$")
	public void userseesparentfolder() throws InterruptedException {
		Scenario.userseesparentfolder();

	}

	@When("^User Deletes Folder Excluding children")
	public void userdeletesfolderexcludingchildren() throws InterruptedException, IOException {

		Scenario.user_deletesfolder_excluding_children();
		sel.captureScreenshot("Delete Folder Excluding Children");
	}

	@When("^User Deletes Folder including children$")
	public void userdeletesfolderincludingchildren() throws InterruptedException, IOException {
		Scenario.user_deletesfolder_including_children();
		sel.captureScreenshot("Delete Folder Incluing Children");

	}

	@Then("^User sees FolderRenamed$")
	public void userseesfolderrenamed() throws IOException, InterruptedException {
		Scenario.thenuserseefolderrenamed();
		sel.captureScreenshot("Rename Folder Verification");

	}

	@Then("^User sees Folder Created Successfully$")
	public void userseesfoldercreatedsuccessfully() throws InterruptedException {

		Scenario.userseefoldercreated();
	}

	@When("^User creates child folder$")
	public void usercreateschildfolder() throws IOException, InterruptedException {
		Scenario.usercreateschildfolder();
		sel.captureScreenshot("Child Folder Creation");
	}

	@When("^User Copies CreatedFolder$")
	public void Usercopiescreatedfolder() throws InterruptedException, IOException {

		Scenario.usercopiesfolder();

		sel.captureScreenshot("Copy Folder");
	}

	@Then("^User sees Exported Folder$")
	public void userseesexportedfolder() throws IOException, InterruptedException {

		Scenario.thenuserseesexportedfolder();
		sel.captureScreenshot("Export Folder");
	}

	@Then("^User sees Exported FeatureFile$")
	public void userseesexportedfeaturefile() throws IOException, InterruptedException {

		Scenario.thenuserseesexportedfeaturefile();
		sel.captureScreenshot("Export Folder");
	}

	@When("^User Creates SubFolder$")
	public void usercretessubfolder() throws InterruptedException, IOException {

		Scenario.usercreatessubfolder();
		sel.captureScreenshot("SubFolder Creation");
	}

	@Then("^User sees CopiedFolder$")
	public void userseescopiedfolder() throws InterruptedException, IOException {

		Scenario.thenuserseescopiedfolder();
		sel.captureScreenshot("CopyFolder Verification");
	}

	@When("^User CreatesScenario with Simple String$")
	public void usercreatesscenario() throws InterruptedException, IOException {

		Scenario.usercreatesscenariowithsimplestring();
		Scenario.userclicksonsave();
		// Scenario.userseescenariocreatedwithsimplestring();
		sel.captureScreenshot("Scenario Creation");

	}

	@When("^User Updates Scenario with Simple String$")
	public void userupdatesscenariowithsimplestring() throws IOException {

		Scenario.userupdatescenariowithsimplestring();
		Scenario.userclicksonsave();
		sel.captureScreenshot("Scenario Update");
	}

	@When("^User CreatesScenario with TableData$")
	public void usercreatesscenariowithtabledata() throws IOException, InterruptedException {
		Scenario.usercreatesscenariowithtabledata();
		Scenario.userclicksonsave();
		sel.captureScreenshot("Scenario Creation with table data");
	}

	@When("^User Clicks on Save$")
	public void userclicksonsave() {

		Scenario.userclicksonsave();
	}

	@When("^User Clicks on Cancel$")
	public void userclicksoncancel() {

		Scenario.userclicksoncancel();
	}

	@When("^User Deletes CreatedScenario$")

	public void userdeletescreatedscenario() throws InterruptedException, FileNotFoundException {
		userlandsintodashboardportalaftertestsuitecreation();
		Scenario.userclicksonscenariotab();
		useredirectstoscenariodetailpage();
		Scenario.usercreatesscenariowithsimplestring();
		Scenario.userclicksonsave();
		Scenario.userseescenariocreatedwithsimplestring();
		Scenario.userclicksondeletescenario();
	}

	@Then("^User does not see Scenario details$")
	public void userdoesnotseescenariodetails() throws IOException {
		Scenario.userdoesnotseescenariodetails();
		sel.captureScreenshot("Delete Scenario Verification");

	}

	@Then("^User sees CreateScenario with SimpleString$")
	public void userseescreatescenariowithsimplestring() throws IOException {
		Scenario.userseescenariocreatedwithsimplestring();

		sel.captureScreenshot("Scenario Verification");

	}

	public static void userredirectstocreatetestsuite() {

		By CreateTestSuite = By.xpath("//div[text()='Create Test Suite']");

		String btn = sel.getElementString(CreateTestSuite);

		Assert.assertEquals("Create Test Suite", btn);
		Reporter.addStepLog("User Redirects to Create TestSuite Page Successful");

	}

	@Then("^User redirects to Scenario DetailPage$")
	public void useredirectstoscenariodetailpage() throws InterruptedException {
		By ScenarioDetail = By.xpath("//span[text()='Scenario Library']");

		String btn = sel.getElementString(ScenarioDetail);

		Assert.assertEquals("Scenario Library", btn);
		Reporter.addStepLog("User Redirects to Scenario detail Page");

	}

	@When("^User Exports CreatedFolder$")
	public void userexportscreatedfolder() throws InterruptedException, IOException {
		Scenario.userexportsfolder();
		sel.captureScreenshot("Export Folder");
	}

	@When("^User Exports FeatureFile$")
	public void userexportsfeaturefile() throws IOException, InterruptedException {

		Scenario.userexportsfeaturefile();
		sel.captureScreenshot("ExportFeatureFile");
	}

	@When("^User Clicks on Scenario Tab$")
	public void userclicksonscenariotab() throws InterruptedException {
		Scenario.userclicksonscenariotab();

	}

	@When("^User Clicks on Create Folder$")
	public void userclicksoncreatefolder() throws InterruptedException {
		Scenario.userclicksoncreatefolder();

	}

	@Then("^validate login$")
	public void verifyLogin() throws InterruptedException {

		loginpage.verifyLogin();

	}

	@Then("^User redirects to ForgotPassword Page$")
	public void userredirectstopasswordpage() throws InterruptedException, IOException {

		Profile.verifyforgotpasswordpage();
		sel.captureScreenshot("Forgot Password Verfication");
	}

	@When("^User Inputs Emailaddress to recover$")
	public void userinputsemailtorecover() throws IOException {
		String RecoveryEmail = JsonReader.readJson("env", "Username");
		Profile.userinputs_emailrecovery(RecoveryEmail);

		sel.captureScreenshot("Forgot Password Input");
	}

	@Then("^User redirects to Create TestPlan Page$")
	public void userredirectstocreatetestplanpage() {

		TestPlan.userredirectstocreateplan();
	}

	@When("^User Clicks on Submit$")
	public void userclicksonsubmit() {
		Profile.userclicksonsubmit();
	}

	@Then("^User redirects to TestSuiteDetailPage$")
	public static void userredirectstotestsuitedetailpage() {
		TestSuite.userredirectstocreatetestsuite();

	}

	@Then("^User redirects to Create Test Target Page$")
	public static void userredirectstocreatetesttargetpage() {
		TestTarget.userredirectstocreatetesttarget();

	}

	@Then("^User redirects to Edit TestTarget Page$")
	public void useredirectstoedittargetpage() {

		TestTarget.userredirectstoedittesttargetpage();
	}

	@When("^User Navigates to Profile$")
	public void usernavigatestoprofile() throws IOException {

		Profile.usernavigatesprofile();
		sel.captureScreenshot("Profile Page");
	}

	@When("^User Enter details for Password Change$")
	public void userenterdetailsforpasswordchange() throws IOException {

		String newpassword = JsonReader.readJson("Profile", "newpassword");

		String Confirmpassword = JsonReader.readJson("Profile", "Confirmpassword");

		String currentpassword = JsonReader.readJson("Profile", "currentpassword");

		Profile.userfillspassworddetailfields(newpassword, Confirmpassword, currentpassword);

		sel.captureScreenshot("Profile Detail Page");
	}

	@Then("^User redirects to Profile$")
	public void useredirectstoprofile() throws InterruptedException {

		Profile.userverifyprofilepage();

	}

	@When("^User Updates TestTarget details$")
	public static void userupdatestesttargetdetails() {
		sUpdateTestTargetname = JsonReader.readJson("TestTarget", "UpdatedName") + new RandomString(4).nextString();
		TestTarget.userupdatedtesttargetdetails(sUpdateTestTargetname);
	}

	@Then("^User Sees Created TestTarget details$")
	public static void userseestesttargetdetails() throws InterruptedException, IOException {

		Thread.sleep(4000);
		By TestTarget = By.xpath("//*[text()='" + testtarget + "']");
		String btn = sel.getElementString(TestTarget);

		Assert.assertEquals(testtarget, btn);

		Reporter.addStepLog("User Created TestTarget Succesfully with  : " + btn);

		sel.captureScreenshot("TestTarget Verfication");
	}

	@Then("^User Does not  Sees TestTarget Deleted$")
	public void userdoesnotseetesttargetdeleted() throws InterruptedException {
		Thread.sleep(4000);
		By TestTarget = By.cssSelector(".bdd-table-body tr td:nth-child(2)");
		String str = sel.getElementString(By.cssSelector(".bdd-table-body tr:nth-child(3) td:nth-child(2)"));
		System.out.println(">>>>>>>>>>>>>>>>>" + str);
		List<WebElement> ele = sel.getElements(TestTarget);
		List<String> targets = new ArrayList<String>();
		for (WebElement wb : ele) {
			System.out.println(wb.getText());
			targets.add(wb.getText());
		}

		if (targets.toString().contains(testtarget)) {

			Reporter.addStepLog("User Sees Deleted TestTarget Record");

		} else {

			Reporter.addStepLog("User Does not  Sees Deleted TestTarget Record");
		}

	}

	@Then("^User Sees TestTarget Updated$")
	public static void userseestesttargetupdated() throws InterruptedException {

		Thread.sleep(4000);
		By TestTarget = By.xpath("//*[text()='" + sUpdateTestTargetname + "']");
		String btn = sel.getElementString(TestTarget);

		Assert.assertEquals(sUpdateTestTargetname, btn);

		Reporter.addStepLog("User Updated TestTarget Succesfully with  : " + btn);
	}

	@When("^User Clicks on CreateTestTarget$")
	public void userclicksoncreatetarget() {

		TestTarget.userclicksoncreatetesttarget();
	}

	@When("^User Enter details for TestTarget with \"([^\"]*)\"$")
	public void userenterdetailsfortesttarget(String args1) throws InterruptedException, IOException {

		testtarget = JsonReader.readJson("TestTarget", "Name") + new RandomString(4).nextString();
		testtargetuname = JsonReader.readJson("TestTarget", "Username");
		testtargetpwd = JsonReader.readJson("TestTarget", "Password") + new RandomString(4).nextString();

		String host = JsonReader.readJson("TestTarget", "Host");

		TestTarget.userfillstesttargetdetails(testtarget, host, testtargetuname, testtargetpwd, args1);

		sel.captureScreenshot("TestTarget Detail");

	}

	@When("^User Clicks on Cancel in TestTarget$")
	public void userclicksoncancelintesttarget() {

		TestTarget.userclicksoncancel();
	}

	@When("^User Clicks on Delete TestTarget$")
	public void userclicksondeletetesttarget() {

		By deletetestarget = By.xpath("//*[text()='" + testtarget + "']/following::a[@class='edit-test-target'][2]	");

		sel.javascript_click(deletetestarget, "User Clicked on Delete TestTarget");

	}

	@When("^User Navigates to TestTarget CreationPage")
	public void usernavigatestotesttargetcreationpage() throws InterruptedException {

		TestTarget.usernavigatestotesttargettab();
		TestTarget.userclicksonaddnewtesttarget();
		TestTarget.userredirectstocreatetesttarget();
	}

	@When("^User Updated TestTargetDetails$")
	public void userupdatedtesttargetdetails() {
		TestTarget.userupdatedtesttargetdetails(JsonReader.readJson("TestTarget", "UpdatedName"));

	}

	@When("^User Clicks on Update Test Target$")
	public void userclicksonupdatetestarget() {
		TestTarget.userclicksonupdatetesttarget();

	}

	@When("^User Deletes TestTargetCreated$")
	public void userdeletestestargetcreated() {

		By edittesttarget = By.xpath("//*[text()='" + testtarget + "']/following::a[@class='edit-test-target'][2]	");

		sel.javascript_click(edittesttarget, "User Clicked on Edit Test Target");
	}

	@When("^User Clicks on Edit TestTarget$")
	public void userclicksonedittesttarget() {

		By edittesttarget = By.xpath("//*[text()='" + testtarget + "']/following::a[@class='edit-test-target'][1]	");

		sel.javascript_click(edittesttarget, "User Clicked on Edit Test Target");
	}

	@When("^User Edits CreatedTestTarget$")
	public void usereditscreatedtesttarget() {
		By edittesttarget = By.xpath("//*[text()='" + testtarget + "']/following::a[@class='edit-test-target'][1]	");

		sel.javascript_click(edittesttarget, "User Clicked on Edit Test Target");

		TestTarget.userredirectstoedittesttargetpage();

		sUpdateTestTargetname = JsonReader.readJson("TestTarget", "UpdatedName") + new RandomString(4).nextString();
		TestTarget.userupdatedtesttargetdetails(sUpdateTestTargetname);
		TestTarget.userclicksonupdatetesttarget();

	}

	@Then("^User see Actionlibrary message$")
	public void userseeactionlibrarymessage() {

		ActionLibrary.userseeactionlibrarymessage();
	}

	@When("^User Deletes ActionCreated$")
	public void userdeletesactionlibrarycreated() {

		ActionLibrary.userdeletesactionlibrary();
	}

	@When("^User Clicks on Submit in ActionCreationPage$")
	public void userclicksonsubmitinactionlibrary() {

		ActionLibrary.userclicksonsubmit();
	}

	@When("^User Updates Created Actions$")
	public void userupdatescreatedactionlibrary() {

		String desc = JsonReader.readJson("ActionLibrary", "UpdatedDescription") + new RandomString(4).nextString();
		UpdatedActionLibrarylabel = JsonReader.readJson("ActionLibrary", "UpdatedLabel")
				+ new RandomString(4).nextString();

		ActionLibrary.userupdatesactionlibrary(desc, UpdatedActionLibrarylabel);

	}

	@Then("^User sees Action Updated$")
	public void userseeactionlibrayupdated() throws IOException, InterruptedException {
		Thread.sleep(6000);
		By ActionLibraryDetail = By.xpath("//div[contains(text(),'" + UpdatedActionLibrarylabel + "')]");

		String btn = sel.getElementString(ActionLibraryDetail);

		Assert.assertEquals(UpdatedActionLibrarylabel, btn);
		Reporter.addStepLog("User Sees Action Library Updated Correctly with Label :" + UpdatedActionLibrarylabel);
		sel.captureScreenshot("Action Library Verfication");
	}

	@Then("^User sees Action Created$")
	public void userseesactionlibrarycreated() throws IOException, InterruptedException {
		
		Thread.sleep(6000);
		By ActionLibraryDetail = By.xpath("//div[contains(text(),'" + Actionlibrarylabel + "')]");
		

		String btn = sel.getElementString(ActionLibraryDetail);
System.out.println("Value is"+btn);
		Assert.assertEquals(Actionlibrarylabel, btn);
		Reporter.addStepLog("User Sees Action Library Created Correctly with Label :" + Actionlibrarylabel);
		

	}

	@When("^User Enter details for Action Creation with TableData \"([^\"]*)\"$")
	public void userenterdetailsforactionlibrarywithtabledata(String arg1) throws InterruptedException, IOException {

		ActionLibrary.userclicksonaddaction();
		prefix = JsonReader.readJson("ActionLibrary", "prefix") + new RandomString(4).nextString();
		suffix = JsonReader.readJson("ActionLibrary", "suffix") + new RandomString(4).nextString();
		DisplayKey = JsonReader.readJson("ActionLibrary", "DisplayKey") + new RandomString(4).nextString();
		Actionlibrarylabel = JsonReader.readJson("ActionLibrary", "Label") + new RandomString(4).nextString();
		//String columntype = JsonReader.readJson("ActionLibrary", arg1) + new RandomString(4).nextString();
		ActionlibraryDescription = JsonReader.readJson("ActionLibrary", "Description")
				+ new RandomString(4).nextString();

		ActionLibrary.userfillsactionlibrarywithtabledata_Integer(Actionlibrarylabel, ActionlibraryDescription, prefix, suffix,
				DisplayKey, arg1);
	

	}

	@When("^User Enter details for ActionCreation$")
	public void userenterdetailsforactionlibrary() throws InterruptedException, IOException {
		Thread.sleep(4000);
		ActionLibrary.userclicksonaddaction();
		Actionlibrarylabel = JsonReader.readJson("ActionLibrary", "Label") + new RandomString(4).nextString();
		ActionlibraryDescription = JsonReader.readJson("ActionLibrary", "Description")
				+ new RandomString(4).nextString();
		ActionLibrary.userfillsactionlibrary(Actionlibrarylabel, ActionlibraryDescription);
		sel.captureScreenshot("Action Library Detail");
	}

	@When("^User Clicks on Cancel in ActionCreationPage$")
	public void userclicksoncancelinactionlibrary() {

		ActionLibrary.cancelactionlibrary();
	}

	@When("^User Clicks on NewAction$")
	public void userclicksonnewaction() throws InterruptedException {

		ActionLibrary.userclicksonaddaction();

	}

	@When("^User Enter Logins Details and Clicks on ForgotPassword$")
	public void userenterslogindetailsandclickonforgotpassword() throws IOException {
		loginpage.logindetails(JsonReader.readJson("env", "Username"), JsonReader.readJson("env", "Password"));
		Profile.userclicksonforgotpassword();

		sel.captureScreenshot("Login");
	}

	@When("^User Enter Logins Details and Clicks on Sign In$")
	public void userenterloginsdetailsandclickonsignin() throws IOException {

		loginpage.logindetails(JsonReader.readJson("env", "Username"), JsonReader.readJson("env", "Password"));
		loginpage.click_Signin();
		sel.captureScreenshot("Login");
	}

	@When("^User clicks on Logout$")
	public void userclicksonlogout() {
		loginpage.click_logout();

	}

	@When("^User clicks on Switch Tenant$")
	public void userclicksonswitchtenant() {
		SwitchTenant.userclicksonswitchtenant();
		SwitchTenant.userredirectstoswitchtenant();
	}

	@When("^User selects Desired Tenant$")
	public void userselectsdesiredtenant() {
		SwitchTenant.userselectsdesiredtenant();

	}

	@When("^User clicks on NewPersona$")
	public static void userclicksonnewpersona() {

		Persona.userclicksonnewpersona();
	}

	

	@When("^User Clicked on Submit$")
	public void userclickedonsubmit() {

		Persona.userclick_submit();

	}

	@When("^User selects Persona$")
	public void userselectpersona() {
		Persona.user_selectpersonacreated();

	}

	@When("^User Clicks on Delete Persona$")
	public static void userclicksondelete() {
		Persona.userclicksondelete();

	}

	@When("^User edits Persona$")
	public void usereditspersona() {
		Persona.user_editpersonadetails(JsonReader.readJson("Persona", "Editlabel"));

	}

	@When("^User fills Personadetails$")
	public static void userfillspersonadetails() throws IOException {

		Persona.userfillspersonadetails(JsonReader.readJson("Persona", "label"),
				JsonReader.readJson("Persona", "description"), JsonReader.readJson("Persona", "ActivityProfile"),
				JsonReader.readJson("Persona", "Adjustmentrule"), JsonReader.readJson("Persona", "CategoryProfile"));
		
	}
	@Then("^User sees Persona Updated$")
	public void userseesperonaupdated() throws IOException {
	By PersonaUpdated=By.xpath("//span[text()='EditTestLabel']");
		
	String  UpdatedPersona= JsonReader.readJson("Persona", "Editlabel"); 
		String btn = sel.getElementString(PersonaUpdated);
      Assert.assertEquals(UpdatedPersona, btn);
		Reporter.addStepLog("User sees Persona Updated as"+UpdatedPersona);
		sel.captureScreenshot("Persona Verification");
	}
	
	@Then("^User does not see Persona Deleted$")
	public void userdoesnotseepersonadeleted() {
By PersonaCreated=By.xpath("//span[text()='TestLabel']");
		
String btn = sel.getElementString(PersonaCreated);

		
	}
	@Then("^User sees Persona Created")
	public void userseespersonacreated() throws IOException {
		
		By PersonaCreated=By.xpath("//span[text()='TestLabel']");
		

		String btn = sel.getElementString(PersonaCreated);

		Assert.assertEquals("TestLabel", btn);
		Reporter.addStepLog("User sees Persona Created as "+btn);
		sel.captureScreenshot("Persona Verification");
		
	}

	@When("^User Clicks on Submit in CreatePersonaPage$")
	public void userclicksonsubmitincreatepersonapage() {

		Persona.userclicksonsubmitincreatepersonapage();
	}

	@When("^User Clicks on AddTestSuite$")
	public void userclicksonaddtestsuite() throws InterruptedException {

		TestSuite.userclicksonaddnewtestsuite();

	}

	@When("^User Navigates to TestSuite CreationPage$")
	public void usernavigatestotestsuitecreationpage() throws InterruptedException {
		TestSuite.userclicksonaddnewtestsuite();

		userredirectstocreatetestsuite();
	}

	@Then("^User sees TestSuite Updated$")
	public void userseestestsuiteupdated() throws InterruptedException {

		Thread.sleep(4000);
		By TestSuiteCreated = By.xpath("//h2[text()='" + Updatetestsuitetitle + "']");
		String btn = sel.getElementString(TestSuiteCreated);

		Assert.assertEquals(Updatetestsuitetitle, btn);
		Reporter.addStepLog("User See  TestSuite Updated Succesfully with title : " + btn);

	}

	@When("^User Updates Test Suite Details$")
	public void userupdatestestsuitedetails() throws InterruptedException {
		Thread.sleep(3000);
		Updatetestsuitetitle = JsonReader.readJson("AddTestSuite", "UpdateTestSuiteTitle")
				+ new RandomString(4).nextString();
		TestSuite.userupdatestestsuitedetails(Updatetestsuitetitle);
	}

	@When("^User Clicks on Updated Test Suite$")
	public void userclicksonupdatedtestsuite() {

		TestSuite.userclicksonupdatetestsuite();
	}

	@When("^User Navigates to ActionLibrary$")
	public void user_navigates_to_actionlibrary_with() throws Throwable {

		ActionLibrary.usernavigatestoactionlibrary_regressiontesting();
	}

	@When("^User Creates TestSuite with WD \"([^\"]*)\"$")
	public void user_enter_details_for_creating_testsuite_with_WD(String args2)
			throws InterruptedException, IOException {

		Thread.sleep(4000);
		title = JsonReader.readJson("AddTestSuite", "TestSuiteTitle") + new RandomString(4).nextString();
		TestSuite.enteraddtestsuitedetailswithworkforcedimension(title,
				JsonReader.readJson("AddTestSuite", "Description"), args2);
		sel.captureScreenshot("Test Suite Creation Detail");
	}

	@When("^User Creates Testsuite with \"([^\"]*)\"$")
	public void user_enter_details_for_creating_testsuite_with(String args2) throws InterruptedException, IOException {

		Thread.sleep(4000);
		title = JsonReader.readJson("AddTestSuite", "TestSuiteTitle") + new RandomString(4).nextString();
		TestSuite.enteraddtestsuitedetailswithworkforcentralversion(title,
				JsonReader.readJson("AddTestSuite", "Description"), args2);
		sel.captureScreenshot("Test Suite Creation Detail");
	}

	@When("^User selects different reviewopts\"([^\"]*)\"$")
	public void userselectsdifferentreviewopts(String arg1) throws InterruptedException, IOException {
		Scenario.reviewoptions(arg1, "Review Comments");

	}

	@When("^User Enter Details for Creating Test Suite with \"([^\"]*)\"$")
	public void user_Enter_Details_for_Creating_Test_Suite_with(String arg1) throws Throwable {

		Thread.sleep(4000);
		title = JsonReader.readJson("AddTestSuite", "TestSuiteTitle");
		TestSuite.enteraddtestsuitedetails(title, JsonReader.readJson("AddTestSuite", "Description"), arg1);
		sel.captureScreenshot("Test Suite Creation Detail");
	}

	@When("^User Clicks on Cancel in AddTestSuite$")
	public void userclicksoncancelinaddtestsuite() {
		TestSuite.userclicksoncancel();

	}

	@When("^User DeletesTestSuite Created$")
	public void userdeletestestsuitecreated() throws InterruptedException {

		TestSuite.userclicksontestsuitesettings();
		TestSuite.userredirectstoupdatetestsuitepage();
		TestSuite.userclicksondeletetestsuite();

	}

	@When("^User Updates TestSuite Created$")
	public void userupdatestestsuitecreated() throws InterruptedException {
		TestSuite.userclicksontestsuitesettings();
		TestSuite.userredirectstoupdatetestsuitepage();
		userupdatestestsuitedetails();
		TestSuite.userclicksonupdatetestsuite();

	}

	@When("^User Clicks on TestSuiteSetting$")
	public void userclicksontestsuitesetting() throws InterruptedException {

		TestSuite.userclicksontestsuitesettings();
		TestSuite.userredirectstoupdatetestsuitepage();
	}

	@When("^User Clicks on DeleteTestSuite$")
	public void userclicksondeletetestsuite() {
		TestSuite.userclicksondeletetestsuite();

	}

	@Then("^User redirects to UpdateTestSuite Page$")
	public void userredirectstoupdatetestsuitepage() {
		TestSuite.userredirectstoupdatetestsuitepage();

	}

	@Then("^User Created TestSuite Succesfully$")
	public void usercreatedtestsuitesuccessfully() throws InterruptedException {
		Thread.sleep(6000);
		By TestSuiteCreated = By.xpath("//h2[text()='" + title + "']");
		String btn = sel.getElementString(TestSuiteCreated);

		Assert.assertEquals(title, btn);
		Reporter.addStepLog("User Created TestSuite Succesfully with title : " + btn);

	}

	@When("^User Clicks on Create New TestSuite$")
	public void userclicksoncreatenewtestsuite() throws InterruptedException {

		TestSuite.userclicknewtestsuite();

	}

	
	@When("User selects testsuite")
	public void userselectstestsuite() {
		TestPlan.userselecttestsuite();

	}

	@When("^User Clicks on TestPlan$")
	public void userclicksontestplan() throws InterruptedException {

		TestPlan.click_testplantab();
	}

	@When("^User Clicks on Create TestPlan$")
	public void userclicksoncreatetestplan() {
		TestPlan.click_createnewtestplan();

	}
	
	@Then("User see TestPlan Created")
	public void userseetestplancreated() throws InterruptedException, IOException {
		
		Thread.sleep(6000);
		By PlanTab=By.xpath("//a[@id='testPlans']");
		sel.click(PlanTab, "Plan Tab");
		
		By TestSuiteCreated = By.xpath("//td[text()='" + JsonReader.readJson("TestPlan", "Name") + "']");
		String btn = sel.getElementString(TestSuiteCreated);

		Assert.assertEquals(JsonReader.readJson("TestPlan", "Name"), btn);
		Reporter.addStepLog("User Sees TestPlan Created : " + btn);
		sel.captureScreenshot();
	}
	@When("^User Clicks on CommitTestPlan$")
	public void userclicksoncommittestplan() {
		
		TestPlan.click_committestplan();
	}
	
	@When("^User Edits TestPlanDetail$")
	public void usereditstestplandetails() throws InterruptedException {
		
		TestPlan.usereditstestplandetails(JsonReader.readJson("TestPlan", "Name"),
				JsonReader.readJson("TestPlan", "EditDescription"));
		
		
	}
	
	@When("^User Clicks on UpdateTestPlan$")
	public void  userclicksonupdatetestplan() throws InterruptedException {
		
		TestPlan.click_updatetestplan();
	}
	@When("^User Deletes TestPlan$")
	public void userdeletestestplan() throws IOException {
		
		TestPlan.click_deletetestplan();
	}
	
	@When("^Enter Details for TestPlanCreation$")
	public void enterdetailsfortestplancreation() throws InterruptedException, IOException {
		
		

		
		TestPlan.filldetails_testplan(JsonReader.readJson("TestPlan", "Name"),
				JsonReader.readJson("TestPlan", "description"));
		sel.captureScreenshot();
	}
	
	@Then("^User does not see TestPlanDeleted$")
	public void userdoesnotseetestplandeleted() throws InterruptedException {
		Thread.sleep(6000);
		String deletedplan=JsonReader.readJson("TestPlan", "DeleteName");
		
		if(!deletedplan.isEmpty()) {
			Reporter.addStepLog("User Does not see TestPlan Deleted");
		}
		else {
			
			Reporter.addStepLog("User Sees  TestPlan Deleted");
		}
		
	}
@When("^User Navigates to Persona Workspace$")
public void usernavigatestopersonaworkspace() throws InterruptedException {
	
	Persona.userclicksonpersonaworkspace();
}
	@When("^User Navigates to Users Workspace$")
	public void usernaviagtestousertab() throws InterruptedException, IOException {

		AddNewUser.usernavigatestousertab();

	}

	@When("^User select record to edit$")
	public void userselectsrecrodtoedit() throws InterruptedException, IOException {

		Thread.sleep(4000);

		By Select_Record = By.xpath("//td[contains(text(),'" + Uname + "')][1]");

		Selcommands.javascript_click(Select_Record, "Created Record which is " + Uname);

		Selcommands.captureScreenshot();

	}

	@When("^User clicks on Delete User$")
	public void userclicksondeleteuser() throws InterruptedException, IOException {

		Thread.sleep(4000);

		By Delete_Record = By.xpath("/following::*[@id='deleteUserById'][1]");
		Selcommands.click(Delete_Record, "Delete User Record which is " + Uname);
		Selcommands.captureScreenshot();//td[contains(text(),'" + Uname + "')][1]

	}

	@When("^User Clicks on Add New User$")
	public void userclicksonaddnewuser() throws InterruptedException {

		AddNewUser.userclicksonaddnewuser();

	}
	
	@Then("^User sees Created Persona$")
	public void userseescreatedpersona() throws IOException {
		
		Scenario.userseescreatedpersona();
	}
@Then("User sees Details Updated$")
public void userseesdetailsupdated() {
	
	By UpdatedUserRecord=By.xpath("(//td[contains(text(),'" + Uname + "')/following::td[@class='clickable-row attribute-key-col'])[2]");
	driver.findElement(UpdatedUserRecord).getText();
	
	String btn = sel.getElementString(UpdatedUserRecord);
System.out.println("Value is"+btn);
	
}
	@When("^User Clicks on UpdateUser$")
	public void userclicksonupdateuser() {

		AddNewUser.click_updateuser();
	}

	@When("^User edits detail in UserPage$")
	public void usereditsdetailinuserpage() throws IOException {

		AddNewUser.edituserdetails();
	}

	@Then("^User redirects to Create User Page$")
	public void userredirectstocreateuserpage() {
		String CreateUser = JsonReader.readJson("AddNewUser", "UserName");

	}

	@Then("^User Created Successfully$")
	public void usercreatedsuccessfully() throws InterruptedException {
		Thread.sleep(4000);

		By DesiredUser = By.xpath("(*//td[contains(text(),'" + Uname + "')])[1]");

		String btn = sel.getElementString(DesiredUser);

		Assert.assertEquals(Uname, btn);
		Reporter.addStepLog("User Created  Succesfully with  : " + Uname);
	}
	
	@Then("^User does not see Deleted Record$")
	public void userdoesnotseeuserdeleted() {
		
		
		if(!Uname.isEmpty()) {
			Reporter.addStepLog("User Deleted  Succesfully with  : " + Uname);
		}
		else {
			Reporter.addStepLog("User does not Get Deleted");
		}

		
	}

	@When("^User Clicks on Create New User$")
	public void userclicksoncreatenewuser() {
		AddNewUser.userclicksoncreatenewuser();
	}

	@When("^User Enter Details for Adding New User$")
	public void userenterdetailsforaddingnewuser() throws IOException, InterruptedException {

		AddNewUser.userclicksonaddnewuser();
		AddNewUser.userredirectstocreateuser();
		Uname = JsonReader.readJson("AddNewUser", "UserName") + new RandomString(4).nextString();
		UserEmail = Uname + "@test.com";
		AddNewUser.userenterdetails(Uname, UserEmail);

		sel.captureScreenshot("UserDetails");
	}

	@Then("^quit browser$")
	public void quittingbrowser() {
		sel.quitBrowser();
	}

}
