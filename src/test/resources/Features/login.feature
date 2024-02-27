
Feature: feature to test login functionality
  @ValidLoginTest
  Scenario:Check login is successful with valid credentials
    Given User is on login page
    When user enter email and password
    And Click on the Login button
    Then User is navigated to the residents screen

#  Scenario Outline: Check login is successful with valid credentials
#    Given User is on login page
#    When user enter <email> and <password>
#    And Click on the Login button
#    Then User is navigated to the residents screen
#    Examples:
#      |email  |password|
#      |harsh.gurjar1213@yopmail.com|Hgurjar731@|
