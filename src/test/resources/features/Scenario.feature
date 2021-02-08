Feature: Scenario

	@CreateScenario
	@ignore
	@before
	@scenario
	@BeforeClass
	Scenario: Create a vanilla scenario with no parameters and data tables

		Given User launches the application
		When User navigates to scenario details page
		And User creates scenario with simple actions
		Then User verifies the scenario created
		And quit browser


	@CreateScenarioWithTableData
	@ignore
	Scenario: Create scenario with table data
		Given User launches the application
		When User navigates to scenario details page
		And User creates scenario with table data
		Then User verifies the scenario created
		And quit browser

	@ignore
	@regression
	@RenameFolder
	Scenario: This scenario is to rename root folder
		Given User launches the application
		When User navigates to scenario details page
		And User creates scenario with simple actions
		And User renames created folder
		Then User sees folder renamed
		And quit browser




	@exportfeaturefile
	@scenario
	Scenario: This scenario is to export folder

		Given User launches the application
		When User navigates to scenario details page
		And User creates scenario with simple actions
		And User exports feature file
		Then User sees Exported FeatureFile
		And quit browser



	@deletefolder_exclude
	@scenario1
	Scenario: This Scenario is to Delete Root Folder Excluding Children
		Given User launches the application
		When User navigates to scenario details page
		And User creates scenario with simple actions
		And User creates child folder
		And User Deletes Folder Excluding children
		Then User sees ParentFolder
		Then quit browser

	@ignore
	@regression
	@Logout
	@scenario
	@Rename
	Scenario: This Scenario is to Rename a Root Folder
		Given User launches the application
		When User navigates to scenario details page
		And User renames created folder
		Then User sees folder renamed
		And quit browser

	@parentfolder
	@scenario
	Scenario: This Scenario is to Create Root Folder and its Child Folder
		Given User launches the application
		When User navigates to scenario details page
		And User renames created folder
		And User creates child folder
		Then User sees Folder Created Successfully
		And quit browser




	@SearchScenario
	@scenario

	Scenario: This Scenario is to Search Root Folder
		Given User launches the application
		When User navigates to scenario details page
		And User Creates Folder and Scenario
		And User Searches for Scenario Created
		Then quit browser



	@deletefolder_exclude
	@scenario1
	Scenario: This Scenario is to Delete Root Folder Excluding Children
		Given User launches the application
		When User navigates to scenario details page
		And User renames created folder
		And User creates child folder
		And User Deletes Folder Excluding children
		Then User sees ParentFolder
		Then quit browser

	@copyfolder
	@scenario
	Scenario: This Scenario is to Copy Root Folder
		Given User launches the application
		When User navigates to scenario details page
		And User renames created folder
		And User Copies CreatedFolder
		Then User sees CopiedFolder
		And quit browser



	@copytestsuite
	@scenario
	Scenario: This Scenario is to CopyTestSuite

		Given User launches the application
		When User navigates to scenario details page
		And User renames created folder
		And User Copies TestSuite
		Then User sees CopiedFolder

	@exportfolder
	@scenario
	Scenario: Export  Folder

		Given User launches the application
		When User navigates to scenario details page
		And User creates scenario with simple actions
		And User exports created folder
		Then User sees Exported Folder
		And quit browser



	@DeleteScenario_SimpleString
	@ignore
	@scenario

	Scenario: This Scenario is to  Delete Scenario with Simple String
		When User Deletes CreatedScenario
		Then User does not see Scenario details
		And quit browser



	@UpdateScenario_SimpleString
	@ignore
	@scenario
	Scenario: This Scenario is to Update Scenario with Simple String
		Given User launches the application
		When User navigates to scenario details page
		And User creates scenario with simple actions
		And User Updates Scenario with Simple Stringbnm,
		Then quit browser



	@Createscenario_simplestring_cancel
	@ignore
	@scenario
	Scenario: This Scenario is to Cancel Scenario
		Given User launches the application
		When User navigates to scenario details page
		And User Cancels CreatedScenario
		Then quit browser

	@CreateScenario_SimpleString_MultipleConditons
	@ignore
	Scenario: This Scenarios is to  Create Scenario With MultipleCondition
		Given User launches the application
		When User navigates to scenario details page
		And User Creates Scenario with MultipleCondition
		Then quit browser


	@Scenario_RequirementNotes
	@ignore
	@scenario
	Scenario: This Scenarios is to CreateRequirementNotes
		Given User launches the application
		When User navigates to scenario details page
		And User Creates RequirementNotes


	@Scenario_CreateTemplate
	@scenario

	Scenario: This Scenarios is to CreateTemplate
		Given User launches the application
		When User navigates to scenario details page
		And User Creates Template



	@ignore
		@regression
		@reviewopts
	Scenario Outline: This Scenarios is to Select Different Review Options

		Given User launches the application
		When User navigates to scenario details page
		And User selects different reviewopts"<typeofreviewopts>"
		Then quit browser

		Examples:
			|typeofreviewopts|
			|Draft|
			|Ready for Review|
			|Reviewed|
			|Blocked|




	@Scenario_DuplicateTemplate
	@scenario

	Scenario: This Scenarios is to Duplicate Template
		Given User launches the application
		When User navigates to scenario details page
		And User CreatesDuplicateTemplate
		Then quit browser


	@Scenario_PersonaLink


	Scenario: This Scenarios is to See Persona Created
		Given User launches the application
		When User navigates to scenario details page
		And User Clicks on Persona Link
		Then User sees Created Persona
		Then quit browser


	@Scenario_ShareLink
	@scenario
	Scenario: This Scenarios is to Share Scenario Link

		Given User launches the application
		When User navigates to scenario details page
		And User creates scenario with simple actions
		And User Shares ScenarioLink
		Then quit browser

