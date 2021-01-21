Feature:  Persona

  @ignore
  @regression
  @AddPersona
  Scenario: Create  Persona

    Given User launches the Application
    When User Navigates to Persona Workspace
    And User clicks on NewPersona
    And User fills Persona details
    And User Clicked on Submit
    Then User sees Persona Created
    And quit browser


  @ignore
  @regression
  @EditPersona

  Scenario: Edit  Persona
    Given User launches the Application
    When User Navigates to Persona Workspace
    And User clicks on NewPersona
    And User fills Persona details
    And User Clicked on Submit
    And User edits Persona
    And User Clicked on Submit
    Then User sees Persona Updated
    Then quit browser

  @ignore
  @regression
  @CopyPersona

  Scenario: Copy  Persona
    Given User launches the Application
    When User Navigates to Persona Workspace
    And User clicks on NewPersona
    And User fills Persona details
    And User Clicked on Submit
    And User Copies createdPersona
    Then User sees Persona Copied
    Then quit browser



  @ignore
  @regression
  @DeletePersona

  Scenario: Delete  Persona
    Given User launches the Application
    When User Navigates to Persona Workspace
    And User clicks on NewPersona
    And User fills Persona details
    And User Clicked on Submit
    And User Clicks on Delete Persona
    Then User does not see Persona Deleted
    Then quit browser


