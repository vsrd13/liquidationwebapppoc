
Feature: Liquidation.com web application 
  I want to use this template for my Liquidation.com web application 


@Registration
  Scenario: Liquidation.com user Registration scenario
    Given I want to navigate to Liquidation.com web Application URL
   	When I want to click on Register link
    Then user navigates to the Liquidation.com registertation page and verify the title
    And enter the details for completing the user registration process
  
  
  @Signin
  Scenario: Liquidation.com user SignIn scenario
    Given user to navigate to Liquidation.com web Application URL
   	When user click on SignIn link and enters username and password for signin
    Then Confirm the user successfully signed in
  