Feature: Shop
@regression
@cartcount
  Scenario: This Scenario is to validate cart count
    Given User launches the application
      When User navigates to shop page
      And User clicks buy button 2 times on FunnyCow
      And User clicks buy button 1 times on Fluffybunny
      Then user sees items added in cart
          And quit browser