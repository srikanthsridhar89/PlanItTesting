Feature: Switch Tenant

@ignore
@regression
@SwitchTenant
Scenario: Switch Tenant


Given User launches the Application
When User clicks on Switch Tenant
And User selects Desired Tenant
Then quit browser