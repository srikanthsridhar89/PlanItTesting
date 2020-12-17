Feature: Create Test Plan

@ignore
@regression1
@createtestplan
Scenario: Create Test Plan

##Given User Launched application
Given User Enter Logins Details and Clicks on Sign In
#Then validate login
When User selects testsuite
And User Clicks on TestPlan
And User Clicks on Create TestPlan
When User fills details in TestPlan
Then quit browser