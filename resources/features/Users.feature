Feature: User

@ignore
@regression
@edituser
Scenario: Edit User
Given User launches the Application
When User Navigates to Users Workspace
And User Enter Details for Adding New User
And User Clicks on Create New User
And User select record to edit
And User edits detail in UserPage
And User Clicks on UpdateUser
Then User sees Details Updated
Then quit browser


@ignore
@regression
@deleteuser
Scenario: Delete User
Given User launches the Application
When User Navigates to Users Workspace
And User Enter Details for Adding New User
And User Clicks on Create New User
And User clicks on Delete User
Then User does not see Deleted Record
And quit browser


@ignore
@regression
@addnewuser
Scenario: Add NewUser
Given User launches the Application
When User Navigates to Users Workspace
And User Enter Details for Adding New User
And User Clicks on Create New User
Then User Created Successfully
Then quit browser
