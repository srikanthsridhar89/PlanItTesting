Feature: Profile

@ignore
@regression
@profile
@changepassword
Scenario: Change Password
Given User launches the application
When User Navigates to Profile
And User Enter details for Password Change
Then quit browser


	

	@ignore
	@profile
@regression
@forgotpassword
Scenario: Forgot Password
Given User Launched application
When User Enter Logins Details and Clicks on ForgotPassword
And User Inputs Emailaddress to recover
And User Clicks on Submit
Then quit browser
	
	
	

@ignore
@regression
@Logout
@profile
Scenario: Logout
Given User launches the application
When User clicks on Logout
Then quit browser 
	
	
	