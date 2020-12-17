Feature: TestSuite

@ignore
@regression
@TestSuite
Scenario Outline: Add TestSuite

Given User launches the Application
When User Navigates to TestSuite CreationPage
And User Enter Details for Creating Test Suite with "<typeoftest>"
And User Clicks on Create New TestSuite
Then User Created TestSuite Succesfully
And quit browser

Examples:
	|typeoftest|
	|Parallel Testing|
	|Regression Testing|
	|Integration Testing|
	|Functional Testing|
	
	
	
@ignore
@regression
@TestSuite
Scenario Outline: Cancel TestSuite


Given User launches the Application
When User Navigates to TestSuite CreationPage
And User Enter Details for Creating Test Suite with "<typeoftest>"
And User Clicks on Cancel in AddTestSuite
Then quit browser


Examples:
	|typeoftest|
	|Parallel Testing|
	|Regression Testing|
	|Integration Testing|
	|Functional Testing|
	
	
	
	
	@ignore
@regression
@TestSuite_WCVersion
Scenario Outline: Create TestSuite wrt Workforce Central  Versions
Given User launches the Application
When User Navigates to TestSuite CreationPage
And User Creates Testsuite with "<WorkforceCentralVersion>" 
And User Clicks on Create New TestSuite
Then User Created TestSuite Succesfully
And quit browser


Examples:
	|WorkforceCentralVersion|
	|Workforce Central - R1|
	|Workforce Central - R2|
	|Workforce Central - R3|



	@ignore
@regression
@TestSuite_WDVersion
Scenario Outline: Create TestSuite wrt Workforce Dimension  Versions
Given User launches the Application
When User Navigates to TestSuite CreationPage
And User Creates TestSuite with WD "<WorkforceDimensionsversion>" 
And User Clicks on Create New TestSuite
Then User Created TestSuite Succesfully
And quit browser


Examples:
	|WorkforceDimensionsversion|
	|Workforce Dimensions Timekeeping - R1|
	|Workforce Dimensions Timekeeping - R2|
	|Workforce Dimensions Timekeeping - R3|

	
	
	
	@ignore
@regression
@TestSuite
@DeleteTestSuite
Scenario Outline: Delete TestSuite
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
	
	
	
	

@regression
@TestSuite
@EditTestSuite_TC
Scenario Outline: Edit TestSuite
Given User launches the Application
When User Navigates to TestSuite CreationPage
And User Enter Details for Creating Test Suite with "<typeoftest>"
And User Clicks on Create New TestSuite
And User Updates TestSuite Created
Then User sees TestSuite Updated 
And quit browser

Examples:
	|typeoftest|
	|Parallel Testing|
	|Regression Testing|
	|Integration Testing|
	|Functional Testing|
	
	
	
	