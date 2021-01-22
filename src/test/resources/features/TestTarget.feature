Feature: TestTarget

	@ignore
		@regression
		@AddWFDTestTarget
		@testtarget
	Scenario Outline: Add NewTestTarget

		Given User launches the Application
		When User Navigates to TestTarget CreationPage
		And User Enter details for TestTarget with "<Software>"
		And User Clicks on CreateTestTarget
		Then User Sees Created TestTarget details with "<Software>"
		And quit browser

		Examples:

			|Software|
			|Workforce Dimensions Timekeeping|


	@ignore
		@regression
		@AddWFCTestTarget
		@testtarget
	Scenario Outline: Add NewTestTarget

		Given User launches the Application
		When User Navigates to TestTarget CreationPage
		And User Enter details for TestTarget with "<Software>"
		And User Clicks on CreateTestTarget
		Then User Sees Created TestTarget details with "<Software>"
		And quit browser

		Examples:

			|Software|
			|Workforce Central|



	@ignore
		@regression
		@EditTestTarget
		@testtarget
	Scenario Outline: Edit TestTarget

		Given User launches the Application
		When User Navigates to TestTarget CreationPage
		And User Enter details for TestTarget with "<Software>"
		And User Clicks on CreateTestTarget
		And User Edits CreatedTestTarget
		Then User Sees TestTarget Updated
		And quit browser


		Examples:

			|Software|
			|Workforce Dimensions Timekeeping|




	@ignore
		@regression
		@CancelTestTarget
		@testtarget
	Scenario Outline: Cancel TestTarget
		Given User launches the Application
		When User Navigates to TestTarget CreationPage
		And User Enter details for TestTarget with "<Software>"
		And User Clicks on Cancel in TestTarget
		Then quit browser

		Examples:

			|Software|
			|Workforce Dimensions Timekeeping|


	@ignore
		@regression
		@DeleteTestTarget
		@testtarget
	Scenario Outline: Delete TestTarget


		Given User launches the Application
		When User Navigates to TestTarget CreationPage
		And User Enter details for TestTarget with "<Software>"
		And User Clicks on CreateTestTarget
		And User Clicks on Delete TestTarget
		Then User Does not  Sees TestTarget Deleted
		And quit browser

		Examples:

			|Software|
			|Workforce Dimensions Timekeeping|

	
	