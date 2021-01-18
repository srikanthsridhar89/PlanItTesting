Feature: TestSuite

	@ignore
		@regression
		@AddWFDTestSuite
	Scenario Outline: Create TestSuite wrt Workforce Dimension  Versions
		Given User launches the Application
		When User Navigates to TestSuite CreationPage
		And User Creates TestSuite with "<KronosVersion>"
		And User Clicks on Create New TestSuite
		Then User Created TestSuite Successfully with "<KronosVersion>"
		And quit browser


		Examples:
			|KronosVersion|
			|Workforce Dimensions Timekeeping - R1|


	@ignore
		@regression
		@AddWFCTestSuite
	Scenario Outline: Create TestSuite wrt Workforce Central  Versions
		Given User launches the Application
		When User Navigates to TestSuite CreationPage
		And User Creates TestSuite with "<KronosVersion>"
		And User Clicks on Create New TestSuite
		Then User Created TestSuite Successfully with "<KronosVersion>"
		And quit browser


		Examples:
			|KronosVersion|
			|Workforce Central - R1|


	@regression
		@TestSuite
		@EditWFDTestSuite
	Scenario Outline: Edit TestSuite
		Given User launches the Application
		When User Navigates to TestSuite CreationPage
		And User Creates TestSuite with "<KronosVersion>"
		And User Clicks on Create New TestSuite
		And User Updates TestSuite Created
		Then User sees TestSuite Updated
		And quit browser

		Examples:
			|KronosVersion|
			|Workforce Dimensions Timekeeping - R1|



	@regression
		@TestSuite
		@CancelWFDTestSuite
	Scenario Outline: Cancel TestSuite
		Given User launches the Application
		When User Navigates to TestSuite CreationPage
		And User Creates TestSuite with "<KronosVersion>"
		And User Clicks on Cancel in AddTestSuite
		Then quit browser


		Examples:
			|KronosVersion|
			|Workforce Dimensions Timekeeping - R1|


	@ignore
		@regression
		@TestSuite
		@DeleteTestSuite
	Scenario Outline: Delete TestSuite
		Given User launches the Application
		When User Navigates to TestSuite CreationPage
		And User Creates TestSuite with "<KronosVersion>"
		And User Clicks on Create New TestSuite
		And User DeletesTestSuite Created
		Then quit browser

		Examples:
			|KronosVersion|
			|Workforce Dimensions Timekeeping - R1|


	@ignore
		@regression
		@TestSuite
		@AddTestSuiteForEachTypeOfTesting
	Scenario Outline: Add TestSuite for each type of testing
		Given User launches the Application
		When User Navigates to TestSuite CreationPage
		And User Enter Details for Creating Test Suite with "<typeoftest>"
		And User Clicks on Create New TestSuite
		And User DeletesTestSuite Created
		Then quit browser

		Examples:
			|typeoftest|
			|Parallel Testing|
			|Regression Testing|
			|Integration Testing|
			|Functional Testing|
