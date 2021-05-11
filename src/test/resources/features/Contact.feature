Feature: Contact

@contacterrorvalidation
@regression
  Scenario: This Scenario is to validate contact field error 
    Given User launches the application
    When User navigates to contact page
    And User clicks on submit button in contactpage
    Then User validates error message for nodata entered
    When User populate mandatory fields
    Then User validates error are gone
    And quit browser

    
    
    
    @contactdetaildata
    @regression
  Scenario: This Scenario is to validate contactdetails data
    Given User launches the application
    When User navigates to contact page
    And User populate mandatory fields
    And User clicks on submit button in contactpage
    Then User validates successful submission message
    And quit browser
    
    
    
    
    
     @contactinvaliddata
     @regression
  Scenario: This Scenario is to validate contact Invalid details data
    Given User launches the application
    When User navigates to contact page
    And User populate mandatory fields with invalid data
    Then User validates error message for invalid entered
    And quit browser
    
    