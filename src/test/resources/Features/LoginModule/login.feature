
@LoginTest
Feature: feature to test login functionality

#  @LoginTest
  Scenario: Check login functionality without credentials
    Given I am on login page
    When I am not  entering email and password
    And I click on Login button
    Then I get email address error

#  @LoginTest
  Scenario: Check login functionality with only email address credentials
    Given I am on login page
    When I am entering email
    And I click on Login button
    Then I get password error

#  @LoginTest
  Scenario: Check login functionality with only password credentials
    Given I am on login page
    When I am entering  password
    And I click on Login button
    Then I get email address error

#  @LoginTest
  Scenario: Check login functionality with incorrect email credentials
    Given I am on login page
    When I am entering incorrect email and correct password
    And I click on Login button
    Then I get Incorrect error

#  @LoginTest
  Scenario: Check login functionality with incorrect password credentials
    Given I am on login page
    When I am entering correct email and incorrect password
    And I click on Login button
    Then I get Incorrect error

#  @LoginTest
  Scenario: Check login functionality with incorrect credentials
    Given I am on login page
    When I am  entering incorrect email and incorrect password
    And I click on Login button
    Then I get Incorrect error

#  @LoginTest
  Scenario: Check login functionality with valid credentials
    Given I am on login page
    When I am entering correct email and correct password
    And I click on Login button
    Then I am navigated to the residents screen and verify email
