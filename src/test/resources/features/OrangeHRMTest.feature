@UI

Feature: Test Orange HRM

  Background:
    Given I open url "https://opensource-demo.orangehrmlive.com/"

  @TestSomething
  Scenario: Test something
    Given I login with "Admin" user
    And I open tab named "Admin"
    And I read the number of existing user records
    When I add new user
      | User Role     | Admin              |
      | Employee Name | Peter Mac Anderson |
      | Status        | Enabled            |
      | Username      | Test123z           |
      | Password      | Automation123      |
    Then Number of existing users will be increased by 1