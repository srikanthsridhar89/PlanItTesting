package steps;
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
	private PersonaConfig personaConfig = new PersonaConfig();
	private ActionLibraryConfig actionLibraryConfig = new ActionLibraryConfig();
	private ScenarioConfig scenarioConfig = new ScenarioConfig();
	public static String Uname = "";
	public static String UserEmail = "";
	public static String dashboard_Personacount="";
	public static String dashboard_Actionscount="";
	public static String dashboard_Scenariocount="";
	public static String sRequirementnotes = "TestRequirement";


	public Stepsfile() {
		ObjectMapper obj = new ObjectMapper();
		try {
			testTargetConfig = obj.readValue(JsonReader.getFile("TestTarget"), TestTargetConfig.class);
			environmentConfig = obj.readValue(JsonReader.getFile("Environment"), EnvironmentConfig.class);
			testSuiteConfig = obj.readValue(JsonReader.getFile("TestSuite"), TestSuiteConfig.class);
			personaConfig = obj.readValue(JsonReader.getFile("Persona"), PersonaConfig.class);
			actionLibraryConfig = obj.readValue(JsonReader.getFile("ActionLibrary"), ActionLibraryConfig.class);
			scenarioConfig= obj.readValue(JsonReader.getFile("Scenario"), ScenarioConfig.class);
		}catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
	}


	@Given("^User launches the application$")
	public void User_launches_the_application() throws FileNotFoundException, InterruptedException {
		openbrowser(environmentConfig);
		LoginPage.loginDetails(environmentConfig);
		LoginPage.clickSignin();
		LoginPage.verifyLogin();

	}

	@When("^User Creates Folder and Scenario$")
	public void user_Creates_Folder_and_Scenario() throws InterruptedException, IOException {
		Scenario.createFolderAndScenario(scenarioConfig);
		sel.captureScreenshot("Folder and Scenario Creation");
	}

	@When("^User Searches for Scenario Created$")
	public void user_Searches_for_Scenario_Created() throws InterruptedException, IOException {
		Scenario.searchScenario(scenarioConfig);
		sel.captureScreenshot("User Search For Scenario");
	}

	@When("^User Clicks on Persona Link$")
	public void User_Clicks_On_Persona_Link() throws InterruptedException {
		Scenario.clickOnPersonaLink();
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
		String personaCount = sel.getElementString(Persona_Count);
		String actionsCount = sel.getElementString(Action_Count);
		String	scenarioCount = sel.getElementString(Scenario_Count);
		if(personaCount.equals(dashboard_Personacount)) {
			Reporter.addStepLog("User see Persona Count as" +personaCount);
		}
		if(actionsCount.equals(dashboard_Actionscount)) {
			Reporter.addStepLog("User see Actions Count as" +actionsCount);
		}
		if(dashboard_Scenariocount.equals(scenarioCount)) {
			Reporter.addStepLog("User see Scenario Count" +scenarioCount);
		}
		sel.captureScreenshot();
	}

	@When("^User Navigates to Persona and Creates Persona$")
	public void User_Navigates_to_Persona_and_Creates_Persona() throws InterruptedException, IOException {
		Thread.sleep(4000);
		By Persona_Tab=By.xpath("//a[@id='personas']");
		sel.click(Persona_Tab, "Persona Tab");
		Persona.userClicksOnNewPersona();
		Persona.userFillsPersonaDetails(personaConfig);
		Persona.userClicksOnSubmit();
	}

	@When("^User Copies createdPersona$")
	public void user_Copies_createdPersona() throws Throwable {
		Thread.sleep(2000);
		By personaCopy=By.xpath("//*[@id='copyPersona']");
		sel.click(personaCopy, "Persona Copy");

	}

	@When("^User Navigates to Actions and Creates Actions$")
	public void User_Navigates_to_Action_and_Creates_Actions() throws InterruptedException, IOException {
		By ActionLibrary = By.xpath("//a[text()='Action Library']");
		sel.click(ActionLibrary, "Action Library");
		User_Enter_details_for_Action_Creation_with_TableData(null);
		User_Clicks_on_Submit_in_ActionCreationPage();
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
		Scenario.createScenarioWithMultipleConditions(scenarioConfig);
	}

	@When("^User CreatesDuplicateTemplate$")
	public void User_CreatesDuplicateTemplate() {
		Scenario.duplicateScenario(scenarioConfig);
	}

	@When("^User Creates Template$")
	public void User_Creates_Template() {
		Scenario.createTemplate(scenarioConfig);
	}

	@Then("^User see SharedScenario$")
	public void User_see_SharedScenario() throws IOException {

		Scenario.verifySharedScenario();
	}
	@When("^User Shares ScenarioLink$")
	public void User_Shares_Scenariolink() throws IOException, InterruptedException {
		Scenario.shareScenarioLink(scenarioConfig);
		sel.captureScreenshot("Share Link");
	}

	@When("^User Cancels CreatedScenario$")
	public void User_Cancels_CreatedScenario() throws InterruptedException, IOException {
		Scenario.createScenarioWithSimpleActions(scenarioConfig);
		Scenario.clickOnCancel();
		sel.captureScreenshot("Cancel CreatedScenario");
	}

	@When("^User Creates RequirementNotes$")
	public void User_Creates_RequirementNotes() throws IOException {
		Scenario.createRequirementNotes(scenarioConfig,sRequirementnotes);
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
		Scenario.copyTestSuite(scenarioConfig);
		sel.captureScreenshot("Copy TestSuite");
	}

	@Then("^User redirects to Switch Tenant Page$")
	public void User_redirects_to_Switch_Tenant_Page() throws IOException {

		SwitchTenant.userRedirectsToSwitchTenant();
		sel.captureScreenshot("Switch TestSuite");

	}

	@When("^User renames created folder$")
	public void User_renames_created_folder() throws InterruptedException, IOException {
		Scenario.renameCreatedFolder(scenarioConfig);
		sel.captureScreenshot("RenameFolder");
	}

	@Then("^User will not see Folder Deleted$")
	public void User_will_not_see_Folder_Deleted() throws IOException {
		Scenario.verifyFolderDeleted(scenarioConfig);
		sel.captureScreenshot("Delete Folder Verification");
	}

	@Then("^User sees Parent Folder Deleted$")
	public void User_sees_Parent_Folder_Deleted() throws IOException, InterruptedException {

		Scenario.verifyParentfolderDeleted(scenarioConfig);

		sel.captureScreenshot("Delete Folder Verification");
	}

	@Then("^User sees ParentFolder$")
	public void userseesparentfolder() throws InterruptedException {
		Scenario.verifyParentFolder(scenarioConfig);

	}

	@When("^User Deletes Folder Excluding children")
	public void User_Deletes_Folder_Excluding_Children() throws InterruptedException, IOException {

		Scenario.deleteFolder(scenarioConfig);
		sel.captureScreenshot("Delete Folder Excluding Children");
	}


	@Then("^User sees folder renamed$")
	public void User_sees_folder_renamed() throws IOException, InterruptedException {
		Scenario.verifyFolderRenamed(scenarioConfig);
		sel.captureScreenshot("Rename Folder Verification");

	}

	@Then("^User sees Folder Created Successfully$")
	public void User_sees_Folder_Created_Successfully() throws InterruptedException {

		Scenario.verifyFolderCreated(scenarioConfig);
	}

	@When("^User creates child folder$")
	public void User_creates_child_folder() throws IOException, InterruptedException {
		Scenario.creatChildFolder(scenarioConfig);
		sel.captureScreenshot("Child Folder Creation");
	}

	@When("^User Copies CreatedFolder$")
	public void User_Copies_CreatedFolder() throws InterruptedException, IOException {

		Scenario.copyFolder(scenarioConfig);

		sel.captureScreenshot("Copy Folder");
	}

	@Then("^User sees Exported Folder$")
	public void User_sees_Exported_Folder() throws IOException, InterruptedException {

		Scenario.verifyExportedFolder();
		sel.captureScreenshot("Export Folder");
	}

	@Then("^User sees Exported FeatureFile$")
	public void User_sees_Exported_FeatureFile() throws IOException, InterruptedException {

		Scenario.verifyExportedFeatureFile();
		sel.captureScreenshot("Export Folder");
	}

	@When("^User Creates SubFolder$")
	public void User_Cretes_SubFolder() throws InterruptedException, IOException {

		Scenario.createsSubFolder(scenarioConfig);
		sel.captureScreenshot("SubFolder Creation");
	}

	@Then("^User sees CopiedFolder$")
	public void User_sees_CopiedFolder() throws InterruptedException, IOException {

		Scenario.verifyCopiedFolder();
		sel.captureScreenshot("CopyFolder Verification");
	}



	@When("^User Updates Scenario with Simple String$")
	public void User_Updates_scenario_with_Simple_String() throws IOException {

		Scenario.updatesScenarioWithSimpleActions(scenarioConfig);
		Scenario.clickOnSave();
		sel.captureScreenshot("Scenario Update");
	}


	@When("^User Clicks on Save$")
	public void User_Clicks_on_Save() {
		Scenario.clickOnSave();
	}

	@When("^User Clicks on Cancel$")
	public void User_Clicks_on_Cancel() {
		Scenario.clickOnCancel();
	}

	@When("^User Deletes CreatedScenario$")

	public void User_Deletes_CreatedScenario() throws InterruptedException, FileNotFoundException {
		User_Lands_into_DashboardPortal_After_TestSuiteCreation();
		Scenario.clickOnScenarioTab();
		User_redirects_to_Scenario_DetailPage();
		Scenario.createScenarioWithSimpleActions(scenarioConfig);
		Scenario.clickOnSave();
		Scenario.verifyScenarioCreatedWithSimpleActions();
		Scenario.clickOnDeleteScenario();
	}

	@Then("^User does not see Scenario details$")
	public void User_does_not_see_Scenario_details() throws IOException {
		Scenario.verifyScenarioDetails();
		sel.captureScreenshot("Delete Scenario Verification");

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

	@When("^User exports created folder$")
	public void User_exports_created_folder() throws InterruptedException, IOException {
		Scenario.exportFolder(scenarioConfig);
		sel.captureScreenshot("Export Folder");
	}

	@When("^User exports feature file$")
	public void User_exports_feature_file() throws IOException, InterruptedException {

		Scenario.exportFeatureFile(scenarioConfig);
		sel.captureScreenshot("ExportFeatureFile");
	}

	@When("^User clicks on scenario sab$")
	public void User_clicks_on_scenario_tab() throws InterruptedException {
		Scenario.clickOnScenarioTab();

	}

	@When("^User clicks on create folder$")
	public void User_clicks_on_create_folder() throws InterruptedException {
		Scenario.clicksOnCreateFolder();

	}

	@Then("^validate login$")
	public void validate_login() throws InterruptedException {
		LoginPage.verifyLogin();
	}

	@Then("^User redirects to forgot password page$")
	public void User_redirects_to_forgot_password_page() throws InterruptedException, IOException {

		Profile.verifyForgotPasswordpage();
		sel.captureScreenshot("Forgot Password Verfication");
	}

	@When("^User inputs email address to recover$")
	public void User_inputs_email_address_to_recover() throws IOException {
		String RecoveryEmail = JsonReader.readJson("env", "Username");
		Profile.userInputsEmailRecovery(RecoveryEmail);
		sel.captureScreenshot("Forgot Password Input");
	}

	@Then("^User redirects to create test plan page$")
	public void User_redirects_to_create_test_plan_page() {
		TestPlan.userRedirectsToCreatePlan();
	}

	@When("^User clicks on submit$")
	public void User_clicks_on_submit() {
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
		TestTarget.userUpdatedTestTargetDetails(testSuiteConfig.getTestWFCUpdateTestSuiteTitle());
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
	public void User_Deletes_ActionCreated() throws InterruptedException {
		ActionLibrary.userDeletesAction();
	}

	@When("^User Clicks on Submit in ActionCreationPage$")
	public void User_Clicks_on_Submit_in_ActionCreationPage() {
		ActionLibrary.userClicksOnSubmit();
	}

	@When("^User Updates Created Actions$")
	public void User_Updates_Created_Actions() {
		ActionLibrary.userUpdatesAction(actionLibraryConfig);

	}

	@Then("^User sees Action Updated$")
	public void User_sees_Action_Updated() throws IOException, InterruptedException {
		Thread.sleep(6000);
		By ActionLibraryDetail = By.xpath("//div[contains(text(),'" + actionLibraryConfig.getAcUpdatedLabel() + "')]");
		String btn = sel.getElementString(ActionLibraryDetail);
		Assert.assertEquals(actionLibraryConfig.getAcUpdatedLabel(), btn);
		Reporter.addStepLog("User Sees Action Library Updated Correctly with Label :" + actionLibraryConfig.getAcUpdatedLabel());
		sel.captureScreenshot("Action Library Verification");
	}

	@Then("^User sees Action Created$")
	public void User_sees_Action_created() throws IOException, InterruptedException {
		Thread.sleep(4000);
		By ActionLibraryDetail = By.xpath("//label[contains(text(),'" + actionLibraryConfig.getAcLabel() + "')]");
		String btn = sel.getElementString(ActionLibraryDetail);
		Assert.assertEquals(actionLibraryConfig.getAcLabel(), btn);
		Reporter.addStepLog("User Sees Action Library Created Correctly with Label :" + actionLibraryConfig.getAcLabel());
	}

	@When("^User Enter details for Action Creation with TableData \"([^\"]*)\"$")
	public void User_Enter_details_for_Action_Creation_with_TableData(String arg1) throws InterruptedException, IOException {
		ActionLibrary.userClicksOnAddAction();
		ActionLibrary.userFillsActionWithTableData(actionLibraryConfig,arg1);
	}

	@When("^User Enter details for ActionCreation$")
	public void User_Enter_details_for_ActionCreation() throws InterruptedException, IOException {
		Thread.sleep(4000);
		ActionLibrary.userClicksOnAddAction();
		ActionLibrary.userFillsAction(actionLibraryConfig);
		sel.captureScreenshot("Action Library Detail");
	}

	@When("^User Clicks on Cancel in ActionCreationPage$")
	public void User_Clicks_on_Cancel_in_ActionCreationPage() throws IOException {

		ActionLibrary.cancelAction();
		sel.captureScreenshot("Cancel Action creation");
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
		sel.captureScreenshot("Sign In successful");
	}

	@When("^User clicks on Logout$")
	public void User_clicks_on_Logout() throws IOException {
		LoginPage.clickLogout();
		sel.captureScreenshot("Sign Out successful");

	}

	@When("^User clicks on Switch Tenant$")
	public void User_clicks_on_Switch_Tenant() throws IOException {
		SwitchTenant.userClicksOnSwitchTenant();
		SwitchTenant.userRedirectsToSwitchTenant();
		sel.captureScreenshot("TenantsList");
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
		Persona.userEditsPersonaDetails(personaConfig.getPersonaEditLabel());

	}

	@When("^User fills Persona details$")
	public void User_fills_Persona_details() throws IOException {

		Persona.userFillsPersonaDetails(personaConfig);
		sel.captureScreenshot("Persona Details entered");

	}
	@Then("^User sees Persona Updated$")
	public void User_sees_persona_Updated() throws IOException {
		By PersonaUpdated=By.xpath("//span[text()='Associate Persona Edited']");
		String btn = sel.getElementString(PersonaUpdated);
		Assert.assertEquals(personaConfig.getPersonaEditLabel(), btn);
		Reporter.addStepLog("User sees Persona Updated as"+personaConfig.getPersonaEditLabel());
		sel.captureScreenshot("Persona Verification");
	}

	@Then("^User sees Persona Copied$")
	public void User_sees_Persona_Copied() throws IOException {
		By PersonaCopied=By.xpath("//span[text()='"+ personaConfig.getPersonaLabel() + " (Copy)']");
		String btn = sel.getElementString(PersonaCopied);
		Assert.assertTrue(btn,true);
		Reporter.addStepLog("User sees Persona Copied as"+ btn);
		sel.captureScreenshot("Duplicate Persona");
	}

	@Then("^User does not see Persona Deleted$")
	public void User_does_not_see_Persona_Deleted() {
		By PersonaCreated=By.xpath("//span[text()='AssociatePersona']");
		String btn = sel.getElementString(PersonaCreated);
	}
	@Then("^User sees Persona Created")
	public void User_sees_Persona_Created() throws IOException {
		By PersonaCreated=By.xpath("//span[text()='AssociatePersona']");
		String btn = sel.getElementString(PersonaCreated);
		Assert.assertEquals("AssociatePersona", btn);
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
		Scenario.reviewOptions(scenarioConfig,arg1, "Review Comments");

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
	public void User_Updates_TestSuite_Created() throws InterruptedException, IOException {
		TestSuite.userClicksOnTestSuiteSettings();
		TestSuite.userRedirectsToUpdateTestSuitePage();
		User_Updates_Test_Suite_Details();
		sel.captureScreenshot("UpdateTestSuite");
		TestSuite.userClicksOnUpdateTestSuite();
	}

	@When("^User Clicks on TestSuiteSetting$")
	public void User_Clicks_on_TestSuiteSetting() throws InterruptedException {

		TestSuite.userClicksOnTestSuiteSettings();
		TestSuite.userRedirectsToUpdateTestSuitePage();
	}

	@When("^User Clicks on DeleteTestSuite$")
	public void User_Clicks_on_DeleteTestSuite() throws IOException {
		TestSuite.userClicksOnDeleteTestSuite();
		sel.captureScreenshot("TestSuiteDeleted");
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
			sel.captureScreenshot("TestSuiteCreated");
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
		Scenario.verifyCreatedPersona();
	}

	@Then("User sees Details Updated$")
	public void User_sees_Details_Updated() {
		By UpdatedUserRecord=By.xpath("(//td[contains(text(),'" + Uname + "')/following::td[@class='clickable-row attribute-key-col'])[2]");
		driver.findElement(UpdatedUserRecord).getText();
		String btn = sel.getElementString(UpdatedUserRecord);
	}

	@When("^User Clicks on UpdateUser$")
	public void User_Clicks_on_UpdateUser() {
		AddNewUser.clickUpdateUser();
	}

	@When("^User edits detail in UserPage$")
	public void User_edits_detail_in_UserPage() throws IOException {
		AddNewUser.editUserDetails();
		sel.captureScreenshot("Role selected");
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


	//Scenarios steps

	@When("^User navigates to scenario details page$")
	public void User_navigates_to_scenario_details_page() throws InterruptedException, IOException {

		Thread.sleep(4000);
		TestSuite.userClicksOnRegressionTestSuite();
		TestSuite.userSelectDesiredTestSuiteCreated();
		Thread.sleep(2000);
		Scenario.clickOnScenarioTab();
		sel.captureScreenshot("ScenarioTabSelected");
	}

	@When("^User creates scenario with simple actions$")
	public void User_creates_scenario_with_simple_actions() throws InterruptedException, IOException {
		Scenario.createScenarioWithSimpleActions(scenarioConfig);
		Scenario.clickOnSave();
	}


	@Then("^User verifies the scenario created$")
	public void User_verifies_the_scenario_created() throws IOException {
		Scenario.verifyScenarioCreated(scenarioConfig);
	//	Scenario.verifyScenarioCreatedWithSimpleActions();
		sel.captureScreenshot("Scenario created");
	}


	@When("^User creates scenario with table data$")
	public void User_creates_scenario_with_table_data() throws IOException, InterruptedException {
		Scenario.createScenarioWithTableData(scenarioConfig);
		Scenario.clickOnSave();
		sel.captureScreenshot("ScenarioWithTableData");
	}
}
