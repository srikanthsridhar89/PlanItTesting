Feature: TestTarget

@ignore
@regression
@addnewtarget
@testtarget
Scenario Outline: Add NewTestTarget

Given User launches the Application
When User Navigates to TestTarget CreationPage
And User Enter details for TestTarget with "<Software>" 
And User Clicks on CreateTestTarget
Then User Sees Created TestTarget details
And quit browser	

Examples:

	|Software|
	|Workforce Central|
	|Workforce Dimensions Timekeeping|





@ignore
@regression
@edittesttarget
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
	|Workforce Central|
	|Workforce Dimensions Timekeeping|




@ignore
@regression
@canceltesttarget
@testtarget
Scenario Outline: Cancel TestTarget
Given User launches the Application
When User Navigates to TestTarget CreationPage
And User Enter details for TestTarget with "<Software>" 
And User Clicks on Cancel in TestTarget
Then quit browser

Examples:

	|Software|
	|Workforce Central|
	|Workforce Dimensions Timekeeping|


@ignore
@regression
@deletetesttarget
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
	|Workforce Central|
	|Workforce Dimensions Timekeeping|
	

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
	
	