package steps;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bean.EnvironmentConfig;
import bean.TestSuiteConfig;
import bean.TestTargetConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import pom.LoginPage;
import utilities.JsonReader;
import utilities.SelCommands;
import net.bytebuddy.utility.RandomString;

import static utilities.SelCommands.*;

public class Stepsfile {
	private static final String String = null;
	static WebDriver driver;
	static SelCommands sel = new SelCommands(driver);
	private TestTargetConfig testTargetConfig = new TestTargetConfig();
	private EnvironmentConfig environmentConfig = new EnvironmentConfig();
	private TestSuiteConfig testSuiteConfig = new TestSuiteConfig();
	public static String title = "";
	public static String Uname = "";
	public static String UserEmail = "";
	public static String Actionlibrarylabel = "";
	public static String ActionlibraryDescription = "";
	public static String Updatetestsuitetitle = "";
	public static String sUpdateTestTargetname = "";
	public static String prefix = "";
	public static String suffix = "";
	public static String UpdatedActionLibrarylabel = "";
	public static String dashboard_Personacount="";
	public static String dashboard_Actionscount="";
	public static String dashboard_Scenariocount="";


	public Stepsfile() {
		ObjectMapper obj = new ObjectMapper();
		try {
			testTargetConfig = obj.readValue(JsonReader.getFile("TestTarget"), TestTargetConfig.class);
			environmentConfig = obj.readValue(JsonReader.getFile("env"), EnvironmentConfig.class);
			testSuiteConfig = obj.readValue(JsonReader.getFile("TestSuite"), TestSuiteConfig.class);
		}catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static String DisplayKey = "";

	public static String sRequirementnotes = "TestRequirement";

	@Given("^User launches the Application$")
	public void userLaunchesApplication() throws FileNotFoundException, InterruptedException {
		openbrowser(environmentConfig);
		LoginPage.loginDetails(environmentConfig);
		LoginPage.clickSignin();
		LoginPage.verifyLogin();

	}

	@When("^User Creates Folder and Scenario$")
	public void user_Creates_Folder_and_Scenario() throws InterruptedException, IOException {
		Scenario.usercreatesfolderandscenario();
		sel.captureScreenshot("Folder and Scenario Creation");
	}

	@When("^User Searches for Scenario Created$")
	public void user_Searches_for_Scenario_Created() throws InterruptedException, IOException {
		Scenario.usersearchesscenario();
		sel.captureScreenshot("User Search For Scenario");
	}

	@When("^User Clicks on Persona Link$")
	public void User_Clicks_On_Persona_Link() throws InterruptedException {
		Scenario.userclicksonpersonalink();
	}

	@When("^User Navigates to TestPlanWorkspace$")
	public void User_Navigates_to_TestPlanWorkspace() throws InterruptedException {
		TestSuite.userClicksOnRegressionTestSuite();
		TestSuite.userSelectDesiredTestSuiteCreated();
		TestPlan.clickTestPlanTab();
	}


	@Then("^User Naviagates to SummaryDetailPage and Verifies the Count$")
	public void User_Navigates_to_SummaryDetailPage_and_Verifies_the_Count() throws IOException {
		By Summary=By.xpath("//a[@id='summary']");
		sel.click(Summary, "Dashboard Summary Tab");
		By Persona_Count=By.xpath("(//a[text()='Personas'])[2]/preceding::div[@class='number']");
		By Action_Count=By.xpath("//a[text()='Actions']/preceding::div[@class='number'][1]");
		By Scenario_Count=By.xpath("//a[text()='Scenarios']/preceding::div[@class='number'][1]");
		String personacount = sel.getElementString(Persona_Count);
		String Actionscount = sel.getElementString(Action_Count);
		String	Scenariocount = sel.getElementString(Scenario_Count);
		if(personacount.equals(dashboard_Personacount)) {
			Reporter.addStepLog("User see Persona Count as" +personacount);
		}
		if(Actionscount.equals(dashboard_Actionscount)) {
			Reporter.addStepLog("User see Actions Count as" +Actionscount);
		}
		if(dashboard_Scenariocount.equals(Scenariocount)) {
			Reporter.addStepLog("User see Scenario Count" +Scenariocount);
		}
		sel.captureScreenshot();
	}

	@When("^User Navigates to Persona and Creates Persona$")
	public void User_Navigates_to_Persona_and_Creates_Persona() throws InterruptedException, IOException {
		Thread.sleep(4000);
		By Persona_Tab=By.xpath("//a[@id='personas']");
		sel.click(Persona_Tab, "Persona Tab");
		Persona.userClicksOnNewPersona();
		Persona.userFillsPersonaDetails(JsonReader.readJson("Persona", "label"),
				JsonReader.readJson("Persona", "description"), JsonReader.readJson("Persona", "ActivityProfile"),
				JsonReader.readJson("Persona", "Adjustmentrule"), JsonReader.readJson("Persona", "CategoryProfile"));
		Persona.userClicksOnSubmit();
	}


	@When("^User Navigates to Actions and Creates Actions$")
	public void User_Navigates_to_Action_and_Creates_Actions() throws InterruptedException, IOException {
		By ActionLibrary = By.xpath("//a[text()='Action Library']");
		sel.click(ActionLibrary, "Action Library");
		User_Enter_details_for_Action_Creation_with_TableData(null);
		User_Clicks_on_Submit_in_ActionCreationPage();
	}

	@When("^User Navigates to Scenario Detail Page$")
	public void user_Navigates_to_Scenario_Detail_Page() throws InterruptedException, IOException {

		Thread.sleep(4000);
		Scenario.userclicksonscenariotab();
		User_CreatesScenario_with_Simple_String();
	}

	@When("^User Navigates to Dashboard Detail Page$")
	public static void User_Naviages_to_Dashboard_Detail_Page() throws InterruptedException {
		TestSuite.userClicksOnRegressionTestSuite();
		TestSuite.userSelectDesiredTestSuiteCreated();
		By Persona_Count=By.xpath("(//a[text()='Personas'])[2]/preceding::div[@class='number']");
		By Action_Count=By.xpath("//a[text()='Actions']/preceding::div[@class='number'][1]");
		By Scenario_Count=By.xpath("//a[text()='Scenarios']/preceding::div[@class='number'][1]");
		dashboard_Personacount = sel.getElementString(Persona_Count);
		dashboard_Actionscount = sel.getElementString(Action_Count);
		dashboard_Scenariocount = sel.getElementString(Scenario_Count);
	}

	@When("^User Creates Scenario with MultipleCondition$")
	public void User_Creates_Scenario_with_MulipleCondition() throws InterruptedException, IOException {
		Scenario.usercreatesscenario_multiplecondition();
	}

	@When("^User CreatesDuplicateTemplate$")
	public void User_CreatesDuplicateTemplate() {
		Scenario.duplicateScenario();
	}

	@When("^User Creates Template$")
	public void User_Creates_Template() {
		Scenario.userCreatesTemplate();
	}

	@Then("^User see SharedScenario$")
	public void User_see_SharedScenario() throws IOException {

		Scenario.userSeeSharedScenario();
	}
	@When("^User Shares ScenarioLink$")
	public void User_Shares_Scenariolink() throws IOException, InterruptedException {
		Scenario.userSharesScenarioLink();
		sel.captureScreenshot("Share Link");
	}

	@When("^User Cancels CreatedScenario$")
	public void User_Cancels_CreatedScenario() throws InterruptedException, IOException {
		Scenario.usercreatesscenariowithsimplestring();
		Scenario.userclicksoncancel();
		sel.captureScreenshot("Cancel CreatedScenario");
	}

	@When("^User Creates RequirementNotes$")
	public void User_Creates_RequirementNotes() throws IOException {
		Scenario.userCreatesRequirementNotes(sRequirementnotes);
		sel.captureScreenshot("Requirement Notes");
	}

	@Given("^User lands into DashboardPortal After TestSuiteCreation$")
	public void User_Lands_into_DashboardPortal_After_TestSuiteCreation()
			throws FileNotFoundException, InterruptedException {
		openbrowser(environmentConfig);
		LoginPage.loginDetails(environmentConfig);
		LoginPage.clickSignin();
		TestSuite.userClicksOnRegressionTestSuite();
		TestSuite.userSelectDesiredTestSuiteCreated();

	}

	@Given("^User Launched application$")
	public void User_Launched_application() throws FileNotFoundException {
		openbrowser(environmentConfig);
	}

	@Then("^User redirects to createuser$")
	public void User_redirects_to_createuser() {
		AddNewUser.userRedirectsToCreateUser();

	}

	@When("^User Copies TestSuite$")
	public void user_Copies_TestSuite() throws InterruptedException, IOException {
		Scenario.copytestsuite();
		sel.captureScreenshot("Copy TestSuite");
	}

	@Then("^User redirects to Switch Tenant Page$")
	public void User_redirects_to_Switch_Tenant_Page() throws IOException {

		SwitchTenant.userRedirectsToSwitchTenant();
		sel.captureScreenshot("Switch TestSuite");

	}

	@When("^User Renames CreatedFolder$")
	public void User_Renames_CreatedFolder() throws InterruptedException, IOException {
		Scenario.userrenamescreatedfolder();
		sel.captureScreenshot("RenameFolder");
	}

	@Then("^User will not see Folder Deleted$")
	public void User_will_not_see_Folder_Deleted() throws IOException {
		Scenario.userwillnotseefolderdeleted();
		sel.captureScreenshot("Delete Folder Verification");
	}

	@Then("^User sees Parent Folder Deleted$")
	public void User_sees_Parent_Folder_Deleted() throws IOException, InterruptedException {

		Scenario.userwillseeParentfolderdeleted();

		sel.captureScreenshot("Delete Folder Verification");
	}

	@Then("^User sees ParentFolder$")
	public void userseesparentfolder() throws InterruptedException {
		Scenario.userseesparentfolder();

	}

	@When("^User Deletes Folder Excluding children")
	public void User_Deletes_Folder_Excluding_Children() throws InterruptedException, IOException {

		Scenario.user_deletesfolder_excluding_children();
		sel.captureScreenshot("Delete Folder Excluding Children");
	}

	@When("^User Deletes Folder including children$")
	public void User_Deletes_Folder_including_children() throws InterruptedException, IOException {
		Scenario.user_deletesfolder_including_children();
		sel.captureScreenshot("Delete Folder Incluing Children");

	}

	@Then("^User sees FolderRenamed$")
	public void User_sees_Folder_Renamed() throws IOException, InterruptedException {
		Scenario.thenuserseefolderrenamed();
		sel.captureScreenshot("Rename Folder Verification");

	}

	@Then("^User sees Folder Created Successfully$")
	public void User_sees_Folder_Created_Successfully() throws InterruptedException {

		Scenario.userseefoldercreated();
	}

	@When("^User creates child folder$")
	public void User_creates_child_folder() throws IOException, InterruptedException {
		Scenario.usercreateschildfolder();
		sel.captureScreenshot("Child Folder Creation");
	}

	@When("^User Copies CreatedFolder$")
	public void User_Copies_CreatedFolder() throws InterruptedException, IOException {

		Scenario.usercopiesfolder();

		sel.captureScreenshot("Copy Folder");
	}

	@Then("^User sees Exported Folder$")
	public void User_sees_Exported_Folder() throws IOException, InterruptedException {

		Scenario.thenuserseesexportedfolder();
		sel.captureScreenshot("Export Folder");
	}

	@Then("^User sees Exported FeatureFile$")
	public void User_sees_Exported_FeatureFile() throws IOException, InterruptedException {

		Scenario.thenuserseesexportedfeaturefile();
		sel.captureScreenshot("Export Folder");
	}

	@When("^User Creates SubFolder$")
	public void User_Cretes_SubFolder() throws InterruptedException, IOException {

		Scenario.usercreatessubfolder();
		sel.captureScreenshot("SubFolder Creation");
	}

	@Then("^User sees CopiedFolder$")
	public void User_sees_CopiedFolder() throws InterruptedException, IOException {

		Scenario.thenuserseescopiedfolder();
		sel.captureScreenshot("CopyFolder Verification");
	}

	@When("^User CreatesScenario with Simple String$")
	public void User_CreatesScenario_with_Simple_String() throws InterruptedException, IOException {

		Scenario.usercreatesscenariowithsimplestring();
		Scenario.userclicksonsave();
		// Scenario.userseescenariocreatedwithsimplestring();
		sel.captureScreenshot("Scenario Creation");

	}

	@When("^User Updates Scenario with Simple String$")
	public void User_Updates_scenario_with_Simple_String() throws IOException {

		Scenario.userupdatescenariowithsimplestring();
		Scenario.userclicksonsave();
		sel.captureScreenshot("Scenario Update");
	}

	@When("^User CreatesScenario with TableData$")
	public void User_Creates_Scenario_with_TableData() throws IOException, InterruptedException {
		Scenario.usercreatesscenariowithtabledata();
		Scenario.userclicksonsave();
		sel.captureScreenshot("Scenario Creation with table data");
	}

	@When("^User Clicks on Save$")
	public void User_Clicks_on_Save() {
		Scenario.userclicksonsave();
	}

	@When("^User Clicks on Cancel$")
	public void User_Clicks_on_Cancel() {
		Scenario.userclicksoncancel();
	}

	@When("^User Deletes CreatedScenario$")

	public void User_Deletes_CreatedScenario() throws InterruptedException, FileNotFoundException {
		User_Lands_into_DashboardPortal_After_TestSuiteCreation();
		Scenario.userclicksonscenariotab();
		User_redirects_to_Scenario_DetailPage();
		Scenario.usercreatesscenariowithsimplestring();
		Scenario.userclicksonsave();
		Scenario.userseescenariocreatedwithsimplestring();
		Scenario.userclicksondeletescenario();
	}

	@Then("^User does not see Scenario details$")
	public void User_does_not_see_Scenario_details() throws IOException {
		Scenario.userdoesnotseescenariodetails();
		sel.captureScreenshot("Delete Scenario Verification");

	}

	@Then("^User sees CreateScenario with SimpleString$")
	public void User_sees_CreateScenario_with_SimpleString() throws IOException {
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
	public void User_redirects_to_Scenario_DetailPage() throws InterruptedException {
		By ScenarioDetail = By.xpath("//span[text()='Scenario Library']");

		String btn = sel.getElementString(ScenarioDetail);

		Assert.assertEquals("Scenario Library", btn);
		Reporter.addStepLog("User Redirects to Scenario detail Page");

	}

	@When("^User Exports CreatedFolder$")
	public void User_Exports_CreatedFolder() throws InterruptedException, IOException {
		Scenario.userexportsfolder();
		sel.captureScreenshot("Export Folder");
	}

	@When("^User Exports FeatureFile$")
	public void User_Exports_FeatureFile() throws IOException, InterruptedException {

		Scenario.userexportsfeaturefile();
		sel.captureScreenshot("ExportFeatureFile");
	}

	@When("^User Clicks on Scenario Tab$")
	public void User_Clicks_on_Scenariotab() throws InterruptedException {
		Scenario.userclicksonscenariotab();

	}

	@When("^User Clicks on Create Folder$")
	public void User_Clicks_on_Create_Folder() throws InterruptedException {
		Scenario.userclicksoncreatefolder();

	}

	@Then("^validate login$")
	public void Validate_Login() throws InterruptedException {
		LoginPage.verifyLogin();
	}

	@Then("^User redirects to ForgotPassword Page$")
	public void User_redirects_to_ForgotPassword_Page() throws InterruptedException, IOException {

		Profile.verifyForgotPasswordpage();
		sel.captureScreenshot("Forgot Password Verfication");
	}

	@When("^User Inputs Emailaddress to recover$")
	public void User_Inputs_Emailaddress_to_recover() throws IOException {
		String RecoveryEmail = JsonReader.readJson("env", "Username");
		Profile.userInputsEmailRecovery(RecoveryEmail);
		sel.captureScreenshot("Forgot Password Input");
	}

	@Then("^User redirects to Create TestPlan Page$")
	public void User_redirects_to_Create_TestPlan_Page() {

		TestPlan.userRedirectsToCreatePlan();
	}

	@When("^User Clicks on Submit$")
	public void User_Clicks_on_Submit() {
		Profile.userClicksOnSubmit();
	}

	@Then("^User redirects to TestSuiteDetailPage$")
	public static void User_redirects_to_TestSuiteDetailPage() {
		TestSuite.userRedirectsToCreateTestSuite();

	}

	@Then("^User redirects to Create Test Target Page$")
	public static void User_redirects_to_Create_Test_Target_Page() {
		TestTarget.userRedirectsToCreateTestTarget();

	}

	@Then("^User redirects to Edit TestTarget Page$")
	public void User_redirects_to_Edit_TestTarget_Page() {

		TestTarget.userRedirectsToEditTestTargetPage();
	}

	@When("^User Navigates to Profile$")
	public void User_Navigates_to_Profile() throws IOException {

		Profile.userNavigatesToProfile();
		sel.captureScreenshot("Profile Page");
	}

	@When("^User Enter details for Password Change$")
	public void User_Enter_details_for_Password_Change() throws IOException {

		String newpassword = JsonReader.readJson("Profile", "newpassword");
		String Confirmpassword = JsonReader.readJson("Profile", "Confirmpassword");
		String currentpassword = JsonReader.readJson("Profile", "currentpassword");
		Profile.userFillsPasswordDetailFields(newpassword, Confirmpassword, currentpassword);
		sel.captureScreenshot("Profile Detail Page");
	}

	@Then("^User redirects to Profile$")
	public void User_redirects_to_Profile() throws InterruptedException {
		Profile.userVerifiesProfilePage();

	}

	@When("^User Updates TestTarget details$")
	public void User_Updates_TestTarget_details() {
		sUpdateTestTargetname = JsonReader.readJson("TestTarget", "UpdatedName") + new RandomString(4).nextString();
		TestTarget.userUpdatedTestTargetDetails(sUpdateTestTargetname);
	}

	@Then("^User Sees Created TestTarget details with \"([^\"]*)\"$")
	public void User_Sees_Created_TestTarget_details_with(String args1) throws InterruptedException, IOException {
		Thread.sleep(4000);
		String btn = "";
		if(args1.equals("Workforce Dimensions Timekeeping")) {
			By TestTarget = By.xpath("//*[text()='" + testTargetConfig.getTestTargetWFDName() + "']");
			btn = sel.getElementString(TestTarget);
			Assert.assertEquals(testTargetConfig.getTestTargetWFDName(), btn);
		}
		else if(args1.equals("Workforce Central")) {
			By TestTarget = By.xpath("//*[text()='" + testTargetConfig.getTestTargetWFCName() + "']");
			btn = sel.getElementString(TestTarget);
			Assert.assertEquals(testTargetConfig.getTestTargetWFCName(), btn);
		}
		Reporter.addStepLog("User Created TestTarget Succesfully with  : " + btn);
		sel.captureScreenshot("TestTarget Verification");
	}

	@Then("^User Does not  Sees TestTarget Deleted$")
	public void User_Does_not_Sees_TestTarget_Deleted() throws InterruptedException {
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
		if (targets.toString().contains(testTargetConfig.getTestTargetWFDName())) {

			Reporter.addStepLog("User Sees Deleted TestTarget Record");
		} else {

			Reporter.addStepLog("User Does not  Sees Deleted TestTarget Record");
		}
	}

	@Then("^User Sees TestTarget Updated$")
	public void User_Sees_TestTarget_Updated() throws InterruptedException {
		Thread.sleep(4000);
		By TestTarget = By.xpath("//*[text()='" + testTargetConfig.getUpdateTestTargetName() + "']");
		String btn = sel.getElementString(TestTarget);
		Assert.assertEquals(testTargetConfig.getUpdateTestTargetName(), btn);
		Reporter.addStepLog("User Updated TestTarget Successfully with  : " + btn);
	}

	@When("^User Clicks on CreateTestTarget$")
	public void User_Clicks_on_CreateTestTarget() {

		TestTarget.userClicksOnCreateTestTarget();
	}

	@When("^User Enter details for TestTarget with \"([^\"]*)\"$")
	public void User_Enter_details_for_TestTarget_with(String args1) throws InterruptedException, IOException {
		if(args1.equals("Workforce Dimensions Timekeeping"))
			TestTarget.userFillsWFDTestTargetDetails(testTargetConfig, args1);
		else if(args1.equals("Workforce Central"))
			TestTarget.userFillsWFCTestTargetDetails(testTargetConfig, args1);
		sel.captureScreenshot("TestTarget Detail");
	}

	@When("^User Clicks on Cancel in TestTarget$")
	public void User_Clicks_on_Cancel_in_TestTarget() {
		TestTarget.userClicksOnCancel();
	}

	@When("^User Clicks on Delete TestTarget$")
	public void User_Clicks_on_Delete_TestTarget() {
		By deletetestarget = By.xpath("//*[text()='" + testTargetConfig.getTestTargetWFDName() + "']/following::a[@class='edit-test-target'][2]	");
		sel.javascript_click(deletetestarget, "User Clicked on Delete TestTarget");

	}

	@When("^User Navigates to TestTarget CreationPage")
	public void User_Navigates_to_TestTarget_CreationPage() throws InterruptedException {

		TestTarget.userNavigatesToTestTargetTab();
		TestTarget.userClicksOnAddNewTestTarget();
		TestTarget.userRedirectsToCreateTestTarget();
	}

	@When("^User Updated TestTargetDetails$")
	public void User_Updated_TestTargetDetails() {
		TestTarget.userUpdatedTestTargetDetails(JsonReader.readJson("TestTarget", "UpdatedName"));

	}

	@When("^User Clicks on Update Test Target$")
	public void User_Clicks_on_Update_Tes_Target() {
		TestTarget.userClicksOnUpdateTestTarget();

	}

	@When("^User Deletes TestTargetCreated$")
	public void User_Deletes_TestTarget_Created() {
		By edittesttarget = By.xpath("//*[text()='" + testTargetConfig.getTestTargetWFDName() + "']/following::a[@class='edit-test-target'][2]	");
		sel.javascript_click(edittesttarget, "User Clicked on Edit Test Target");
	}

	@When("^User Clicks on Edit TestTarget$")
	public void User_Clicks_on_Edit_TestTarget() {
		By edittesttarget = By.xpath("//*[text()='" + testTargetConfig.getTestTargetWFDName() + "']/following::a[@class='edit-test-target'][1]	");
		sel.javascript_click(edittesttarget, "User Clicked on Edit Test Target");
	}

	@When("^User Edits CreatedTestTarget$")
	public void User_Edits_CreatedTestTarget() {
		By edittesttarget = By.xpath("//*[text()='" + testTargetConfig.getTestTargetWFDName() + "']/following::a[@class='edit-test-target'][1]	");
		sel.javascript_click(edittesttarget, "User Clicked on Edit Test Target");
		TestTarget.userRedirectsToEditTestTargetPage();
		TestTarget.userUpdatedTestTargetDetails(testTargetConfig.getUpdateTestTargetName());
		TestTarget.userClicksOnUpdateTestTarget();
	}

	@Then("^User see Actionlibrary message$")
	public void User_see_Actionlibrary_message() {
		ActionLibrary.userSeeActionMessage();
	}

	@When("^User Deletes ActionCreated$")
	public void User_Deletes_ActionCreated() {
		ActionLibrary.userDeletesAction();
	}

	@When("^User Clicks on Submit in ActionCreationPage$")
	public void User_Clicks_on_Submit_in_ActionCreationPage() {

		ActionLibrary.userClicksOnSubmit();
	}

	@When("^User Updates Created Actions$")
	public void User_Updates_Created_Actions() {

		String desc = JsonReader.readJson("ActionLibrary", "UpdatedDescription") + new RandomString(4).nextString();
		UpdatedActionLibrarylabel = JsonReader.readJson("ActionLibrary", "UpdatedLabel")
				+ new RandomString(4).nextString();
		ActionLibrary.userUpdatesAction(desc, UpdatedActionLibrarylabel);

	}

	@Then("^User sees Action Updated$")
	public void User_sees_Action_Updated() throws IOException, InterruptedException {
		Thread.sleep(6000);
		By ActionLibraryDetail = By.xpath("//div[contains(text(),'" + UpdatedActionLibrarylabel + "')]");
		String btn = sel.getElementString(ActionLibraryDetail);
		Assert.assertEquals(UpdatedActionLibrarylabel, btn);
		Reporter.addStepLog("User Sees Action Library Updated Correctly with Label :" + UpdatedActionLibrarylabel);
		sel.captureScreenshot("Action Library Verification");
	}

	@Then("^User sees Action Created$")
	public void User_sees_Action_created() throws IOException, InterruptedException {

		Thread.sleep(6000);
		By ActionLibraryDetail = By.xpath("//div[contains(text(),'" + Actionlibrarylabel + "')]");
		String btn = sel.getElementString(ActionLibraryDetail);
		System.out.println("Value is"+btn);
		Assert.assertEquals(Actionlibrarylabel, btn);
		Reporter.addStepLog("User Sees Action Library Created Correctly with Label :" + Actionlibrarylabel);
	}

	@When("^User Enter details for Action Creation with TableData \"([^\"]*)\"$")
	public void User_Enter_details_for_Action_Creation_with_TableData(String arg1) throws InterruptedException, IOException {
		ActionLibrary.userClicksOnAddAction();
		prefix = JsonReader.readJson("ActionLibrary", "prefix") + new RandomString(4).nextString();
		suffix = JsonReader.readJson("ActionLibrary", "suffix") + new RandomString(4).nextString();
		DisplayKey = JsonReader.readJson("ActionLibrary", "DisplayKey") + new RandomString(4).nextString();
		Actionlibrarylabel = JsonReader.readJson("ActionLibrary", "Label") + new RandomString(4).nextString();
		String columntype = JsonReader.readJson("ActionLibrary", arg1) + new RandomString(4).nextString();
		ActionlibraryDescription = JsonReader.readJson("ActionLibrary", "Description")
				+ new RandomString(4).nextString();
		ActionLibrary.userFillsActionWithTableData_Integer(Actionlibrarylabel, ActionlibraryDescription, prefix, suffix,
				DisplayKey, arg1);
	}

	@When("^User Enter details for ActionCreation$")
	public void User_Enter_details_for_ActionCreation() throws InterruptedException, IOException {
		Thread.sleep(4000);
		ActionLibrary.userClicksOnAddAction();
		Actionlibrarylabel = JsonReader.readJson("ActionLibrary", "Label") + new RandomString(4).nextString();
		ActionlibraryDescription = JsonReader.readJson("ActionLibrary", "Description")
				+ new RandomString(4).nextString();
		ActionLibrary.userFillsAction(Actionlibrarylabel, ActionlibraryDescription);
		sel.captureScreenshot("Action Library Detail");
	}

	@When("^User Clicks on Cancel in ActionCreationPage$")
	public void User_Clicks_on_Cancel_in_ActionCreationPage() {

		ActionLibrary.cancelAction();
	}

	@When("^User Clicks on NewAction$")
	public void User_Clicks_on_NewAction() throws InterruptedException {

		ActionLibrary.userClicksOnAddAction();

	}

	@When("^User Enter Logins Details and Clicks on ForgotPassword$")
	public void User_Enter_Logins_Details_and_Click_on_ForgotPassword() throws IOException {
		LoginPage.loginDetails(environmentConfig);
		Profile.userClicksOnForgotPassword();

		sel.captureScreenshot("Login");
	}

	@When("^User Enter Logins Details and Clicks on Sign In$")
	public void User_Enter_Logins_Details_and_Clicks_on_Sign_In() throws IOException {

		LoginPage.loginDetails( environmentConfig);
		LoginPage.clickSignin();
		sel.captureScreenshot("Login");
	}

	@When("^User clicks on Logout$")
	public void User_clicks_on_Logout() {
		LoginPage.clickLogout();

	}

	@When("^User clicks on Switch Tenant$")
	public void User_clicks_on_Switch_Tenant() {
		SwitchTenant.userClicksOnSwitchTenant();
		SwitchTenant.userRedirectsToSwitchTenant();
	}

	@When("^User selects Desired Tenant$")
	public void User_selects_Desired_Tenant() {
		SwitchTenant.userSelectsDesiredTenant();

	}

	@When("^User clicks on NewPersona$")
	public static void User_clicks_on_NewPersona() {

		Persona.userClicksOnNewPersona();
	}



	@When("^User Clicked on Submit$")
	public void User_Clicked_on_Submit() {

		Persona.userClicksOnSubmit();

	}

	@When("^User selects Persona$")
	public void User_selects_Persona() {
		Persona.userSelectsPersonaCreated();

	}

	@When("^User Clicks on Delete Persona$")
	public static void User_Clicks_on_Delete_Persona() {
		Persona.userClicksOnDelete();

	}

	@When("^User edits Persona$")
	public void User_edits_Persona() {
		Persona.userEditsPersonaDetails(JsonReader.readJson("Persona", "Editlabel"));

	}

	@When("^User fills Personadetails$")
	public static void User_fills_Personadetails() throws IOException {

		Persona.userFillsPersonaDetails(JsonReader.readJson("Persona", "label"),
				JsonReader.readJson("Persona", "description"), JsonReader.readJson("Persona", "ActivityProfile"),
				JsonReader.readJson("Persona", "Adjustmentrule"), JsonReader.readJson("Persona", "CategoryProfile"));

	}
	@Then("^User sees Persona Updated$")
	public void User_sees_persona_Updated() throws IOException {
		By PersonaUpdated=By.xpath("//span[text()='EditTestLabel']");

		String  UpdatedPersona= JsonReader.readJson("Persona", "Editlabel");
		String btn = sel.getElementString(PersonaUpdated);
		Assert.assertEquals(UpdatedPersona, btn);
		Reporter.addStepLog("User sees Persona Updated as"+UpdatedPersona);
		sel.captureScreenshot("Persona Verification");
	}

	@Then("^User does not see Persona Deleted$")
	public void User_does_not_see_Persona_Deleted() {
		By PersonaCreated=By.xpath("//span[text()='TestLabel']");

		String btn = sel.getElementString(PersonaCreated);


	}
	@Then("^User sees Persona Created")
	public void User_sees_Persona_Created() throws IOException {
		By PersonaCreated=By.xpath("//span[text()='TestLabel']");
		String btn = sel.getElementString(PersonaCreated);
		Assert.assertEquals("TestLabel", btn);
		Reporter.addStepLog("User sees Persona Created as "+btn);
		sel.captureScreenshot("Persona Verification");
	}

	@When("^User Clicks on Submit in CreatePersonaPage$")
	public void User_Clicks_on_Submit_in_CreatePersonaPage() {
		Persona.userClicksOnSubmitInCreatePersonaPage();
	}

	@When("^User Clicks on AddTestSuite$")
	public void User_Clicks_on_AddTestSuite() throws InterruptedException {
		TestSuite.userClicksOnAddNewTestSuite();
	}

	@When("^User Navigates to TestSuite CreationPage$")
	public void User_Navigates_to_TestSuite_CreationPage() throws InterruptedException {
		TestSuite.userClicksOnAddNewTestSuite();
		userredirectstocreatetestsuite();
	}

	@Then("^User sees TestSuite Updated$")
	public void User_sees_TestSuite_Updated() throws InterruptedException {
		Thread.sleep(4000);
		By TestSuiteCreated = By.xpath("//h2[text()='" + testSuiteConfig.getTestWFDUpdateTestSuiteTitle() + "']");
		String btn = sel.getElementString(TestSuiteCreated);
		Assert.assertEquals(testSuiteConfig.getTestWFDUpdateTestSuiteTitle(), btn);
		Reporter.addStepLog("User See  TestSuite Updated Successfully with title : " + btn);
	}

	@When("^User Updates Test Suite Details$")
	public void User_Updates_Test_Suite_Details() throws InterruptedException {
		Thread.sleep(3000);
		TestSuite.userUpdatesTestSuiteDetails(testSuiteConfig.getTestWFDUpdateTestSuiteTitle());
	}

	@When("^User Clicks on Updated Test Suite$")
	public void User_Clicks_on_Updated_Test_Suite() {

		TestSuite.userClicksOnUpdateTestSuite();
	}

	@When("^User Navigates to ActionLibrary$")
	public void User_Navigates_to_ActionLibrary() throws Throwable {

		ActionLibrary.userNavigatesToActionLibrary_RegressionTesting();
	}

	@When("^User Creates TestSuite with \"([^\"]*)\"$")
	public void User_Creates_TestSuite_with(String KronosVersion)
			throws InterruptedException, IOException {
		Thread.sleep(4000);
		if(KronosVersion.equals("Workforce Dimensions Timekeeping - R1"))
			TestSuite.enterAddTestSuiteDetailsWithWFDVersion(testSuiteConfig, KronosVersion);
		else if(KronosVersion.equals("Workforce Central - R1"))
			TestSuite.enterAddTestSuiteDetailsWithWFCVersion(testSuiteConfig, KronosVersion);

		sel.captureScreenshot("Test Suite Creation Detail");
	}


	@When("^User selects different reviewopts\"([^\"]*)\"$")
	public void User_selects_different_reviewopts(String arg1) throws InterruptedException, IOException {
		Scenario.reviewoptions(arg1, "Review Comments");

	}

	@When("^User Enter Details for Creating Test Suite with \"([^\"]*)\"$")
	public void User_Enter_Details_for_Creating_Test_Suite_with(String arg1) throws Throwable {

		Thread.sleep(4000);
		TestSuite.enterAddTestSuiteDetails(testSuiteConfig, arg1);
		sel.captureScreenshot("Test Suite Creation Detail");
	}

	@When("^User Clicks on Cancel in AddTestSuite$")
	public void User_Clicks_on_Cancel_in_AddTestSuite() {
		TestSuite.userClicksOnCancel();
	}

	@When("^User DeletesTestSuite Created$")
	public void User_DeletesTestSuite_Created() throws InterruptedException, IOException {
		TestSuite.userClicksOnTestSuiteSettings();
		TestSuite.userRedirectsToUpdateTestSuitePage();
		TestSuite.userClicksOnDeleteTestSuite();
		sel.captureScreenshot("Test Suite Deleted Successfully");
	}

	@When("^User Updates TestSuite Created$")
	public void User_Updates_TestSuite_Created() throws InterruptedException {
		TestSuite.userClicksOnTestSuiteSettings();
		TestSuite.userRedirectsToUpdateTestSuitePage();
		User_Updates_Test_Suite_Details();
		TestSuite.userClicksOnUpdateTestSuite();
	}

	@When("^User Clicks on TestSuiteSetting$")
	public void User_Clicks_on_TestSuiteSetting() throws InterruptedException {

		TestSuite.userClicksOnTestSuiteSettings();
		TestSuite.userRedirectsToUpdateTestSuitePage();
	}

	@When("^User Clicks on DeleteTestSuite$")
	public void User_Clicks_on_DeleteTestSuite() {
		TestSuite.userClicksOnDeleteTestSuite();

	}

	@Then("^User redirects to UpdateTestSuite Page$")
	public void User_redirects_to_UpdateTestSuite_Page() {
		TestSuite.userRedirectsToUpdateTestSuitePage();

	}

	@Then("^User Created TestSuite Successfully with \"([^\"]*)\"$")
	public void User_Created_TestSuite_Successfully(String KronosVersion) throws InterruptedException, IOException {
		Thread.sleep(6000);
		String btn = null;
		if(KronosVersion.equals("Workforce Dimensions Timekeeping - R1")) {
			btn = sel.getElementString(By.xpath("//h2[text()='" + testSuiteConfig.getTestSuiteWFDTitle() + "']"));
			Assert.assertEquals(testSuiteConfig.getTestSuiteWFDTitle(), btn);
			Reporter.addStepLog("User Created TestSuite Successfully with title : " + btn);
		}
		else if(KronosVersion.equals("Workforce Central - R1")) {
			btn = sel.getElementString(By.xpath("//h2[text()='" + testSuiteConfig.getTestSuiteWFCTitle() + "']"));
			Assert.assertEquals(testSuiteConfig.getTestSuiteWFCTitle(), btn);
		}
		Reporter.addStepLog("User Created TestSuite Successfully with title : " + btn);
		sel.captureScreenshot("CreateTestSuite");

	}

	@When("^User Clicks on Create New TestSuite$")
	public void User_Clicks_on_Create_New_TestSuite() throws InterruptedException {
		TestSuite.userClickNewTestSuite();
	}


	@When("User selects testsuite")
	public void User_selects_testsuite() {
		TestPlan.userSelectTestSuite();
	}

	@When("^User Clicks on TestPlan$")
	public void User_Clicks_on_TestPlan() throws InterruptedException {
		TestPlan.clickTestPlanTab();
	}

	@When("^User Clicks on Create TestPlan$")
	public void User_Clicks_on_Create_TestPlan() {
		TestPlan.clickCreateNewTestPlan();
	}

	@Then("User see TestPlan Created")
	public void User_see_TestPlan_Created() throws InterruptedException, IOException {
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
	public void User_Clicks_on_CommitTestPlan() {
		TestPlan.clickCommitTestPlan();
	}

	@When("^User Edits TestPlanDetail$")
	public void User_Edits_TestPlanDetails() throws InterruptedException {
		TestPlan.userEditsTestPlanDetails(JsonReader.readJson("TestPlan", "Name"),
				JsonReader.readJson("TestPlan", "EditDescription"));
	}

	@When("^User Clicks on UpdateTestPlan$")
	public void User_Clicks_on_UpdateTestPlan() throws InterruptedException {
		TestPlan.clickUpdateTestPlan();
	}

	@When("^User Deletes TestPlan$")
	public void User_Deletes_TestPlan() throws IOException {
		TestPlan.clickDeleteTestPlan();
	}

	@When("^Enter Details for TestPlanCreation$")
	public void Enter_Details_for_TestPlanCreation() throws InterruptedException, IOException {
		TestPlan.fillDetailsOfTestPlan(JsonReader.readJson("TestPlan", "Name"),
				JsonReader.readJson("TestPlan", "description"));
		sel.captureScreenshot();
	}

	@Then("^User does not see TestPlanDeleted$")
	public void User_does_not_see_TestPlanDeleted() throws InterruptedException {
		Thread.sleep(6000);
		String deletedplan=JsonReader.readJson("TestPlan", "DeleteName");
		if(!deletedplan.isEmpty()) {
			Reporter.addStepLog("User Does not see TestPlan Deleted");
		} else {
			Reporter.addStepLog("User Sees  TestPlan Deleted");
		}
	}

	@When("^User Navigates to Persona Workspace$")
	public void User_Navigates_to_Persona_workspace() throws InterruptedException {
		Persona.userClicksOnPersonaWorkspace();
	}

	@When("^User Navigates to Users Workspace$")
	public void User_Navigates_to_users_Workspace() throws InterruptedException, IOException {
		AddNewUser.userNavigatesToUserTab();
	}

	@When("^User select record to edit$")
	public void User_select_record_to_edit() throws InterruptedException, IOException {
		Thread.sleep(4000);
		By Select_Record = By.xpath("//td[contains(text(),'" + Uname + "')][1]");
		javascript_click(Select_Record, "Created Record which is " + Uname);
		captureScreenshot();
	}

	@When("^User clicks on Delete User$")
	public void User_clicks_on_Delete_user() throws InterruptedException, IOException {
		Thread.sleep(4000);
		By Delete_Record = By.xpath("/following::*[@id='deleteUserById'][1]");
		click(Delete_Record, "Delete User Record which is " + Uname);
		captureScreenshot();//td[contains(text(),'" + Uname + "')][1]
	}

	@When("^User Clicks on Add New User$")
	public void User_Clicks_on_Add_New_User() throws InterruptedException {
		AddNewUser.userclicksonaddnewuser();
	}

	@Then("^User sees Created Persona$")
	public void User_sees_Created_Persona() throws IOException {
		Scenario.userseescreatedpersona();
	}

	@Then("User sees Details Updated$")
	public void User_sees_Details_Updated() {
		By UpdatedUserRecord=By.xpath("(//td[contains(text(),'" + Uname + "')/following::td[@class='clickable-row attribute-key-col'])[2]");
		driver.findElement(UpdatedUserRecord).getText();
		String btn = sel.getElementString(UpdatedUserRecord);
		System.out.println("Value is"+btn);
	}

	@When("^User Clicks on UpdateUser$")
	public void User_Clicks_on_UpdateUser() {
		AddNewUser.clickUpdateUser();
	}

	@When("^User edits detail in UserPage$")
	public void User_edits_detail_in_UserPage() throws IOException {
		AddNewUser.editUserDetails();
	}

	@Then("^User redirects to Create User Page$")
	public void User_redirects_to_Create_User_Page() {
		String CreateUser = JsonReader.readJson("AddNewUser", "UserName");
	}

	@Then("^User Created Successfully$")
	public void User_Created_Successfully() throws InterruptedException {
		Thread.sleep(4000);
		By DesiredUser = By.xpath("(*//td[contains(text(),'" + Uname + "')])[1]");
		String btn = sel.getElementString(DesiredUser);
		Assert.assertEquals(Uname, btn);
		Reporter.addStepLog("User Created  Succesfully with  : " + Uname);
	}

	@Then("^User does not see Deleted Record$")
	public void User_does_not_see_Deleted_Record() {

		if(!Uname.isEmpty()) {
			Reporter.addStepLog("User Deleted  Succesfully with  : " + Uname);
		}
		else {
			Reporter.addStepLog("User does not Get Deleted");
		}
	}

	@When("^User Clicks on Create New User$")
	public void User_Clicks_on_Create_New_User() {

		AddNewUser.userclicksoncreatenewuser();
	}

	@When("^User Enter Details for Adding New User$")
	public void User_Enter_Details_for_Adding_New_User() throws IOException, InterruptedException {

		AddNewUser.userclicksonaddnewuser();
		AddNewUser.userRedirectsToCreateUser();
		Uname = JsonReader.readJson("AddNewUser", "UserName") + new RandomString(4).nextString();
		UserEmail = Uname + "@test.com";
		AddNewUser.userenterdetails(Uname, UserEmail);

		sel.captureScreenshot("UserDetails");
	}

	@Then("^quit browser$")
	public void quit_browser() {
		sel.quitBrowser();
	}

}
