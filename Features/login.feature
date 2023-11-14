
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Login OrangeHRM application
    Given I want to open Chrome browser
    And open Orange HRM application with url as "http://orangehrm.qedgetech.com"
    When enter username as "Admin"
    And enter password as "Qedge123!@#"
    And click on Login button
    Then we should able to see "Welcome Admin" text on left side 
    And user should able to see "Logout" option on left side

 