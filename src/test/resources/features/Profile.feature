Feature: Profile

@ignore
@regression
@changepassword
Scenario: Change Password
Given User Launched application
When User Enter Logins Details and Clicks on Sign In
Then validate login
When User Navigates to Profile
Then User redirects to Profile
And User Enter details for Password Change
And quit browser


	

	@ignore
@regression
@forgotpassword
Scenario: Forgot Password
Given User Launched application
When User Enter Logins Details and Clicks on ForgotPassword
Then User redirects to ForgotPassword Page
When User Inputs Emailaddress to recover
And User Clicks on Submit
And quit browser
	
	
	

@ignore
@regression
@Logout
Scenario: Logout
Given User launches the Application
When User clicks on Logout
Then quit browser 
	
	
	