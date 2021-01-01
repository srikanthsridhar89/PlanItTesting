Feature: Action Library

	@ignore
	@regression
	@actionlibrary
	@addaction
	Scenario: This Scenario is to Add action for Given  without parameters and table columns
		Given User launches the Application
		When User Navigates to ActionLibrary
		And User Enter details for ActionCreation
		And User Clicks on Submit in ActionCreationPage
		Then User sees Action Created
		And quit browser



	@ignore
	@actionlibrary
	@regression
	@cancelaction
	Scenario: This Scenario is to CancelAction

		Given User launches the Application
		When User Navigates to ActionLibrary
		And User Enter details for ActionCreation
		And User Clicks on Cancel in ActionCreationPage
		Then quit browser




	@regression
		@actionlibrary
		@addactionlibrary_table
	Scenario Outline: This Scenario is to Add action with Table Columns
		Given User launches the Application
		When User Navigates to ActionLibrary
		And User Enter details for Action Creation with TableData "<type>"
		And User Clicks on Submit in ActionCreationPage
		Then User sees Action Created
		And quit browser

		Examples:
			|type|
			|Integer|
			|String|
			|Date|
			|Time|
			|File Attachment|
			|Interval|

	@UpdateAction
	Scenario Outline: This Scenario is to UpdateAction

		Given User launches the Application
		When User Navigates to ActionLibrary
		And User Enter details for Action Creation with TableData "<type>"
		And User Clicks on Submit in ActionCreationPage
		And User Updates Created Actions
		Then User sees Action Updated
		And quit browser

		Examples:
			|type|
			|Integer|
			|String|
			|Date|
			|Time|
			|File Attachment|
			|Interval|




	@DeleteAction
	Scenario: This Scenario is to DeleteAction
		Given User launches the Application
		When User Navigates to ActionLibrary
		And User Enter details for ActionCreation
		And User Clicks on Submit in ActionCreationPage
		And User Deletes ActionCreated
		Then quit browser
 