Feature: feature to test login functionality

  Scenario Outline: Check login functionality without credentials
    Given User is on login page
    When User enter <email> and <password>
    And User click on Login button
    Then User get email <error> message
    Examples:
      |email|password|error|
      |||Email address can't be blank.|

  Scenario Outline: Check login functionality with only email address credentials
    Given User is on login page
    When User enter correct <email> and not <password>
    And User click on Login button
    Then User get password <error> message
    Examples:
      |email|password|error|
      |harsh.gurjar1213@yopmail.com||Password can't be blank.|

  Scenario Outline: Check login functionality with only password credentials
    Given User is on login page
    When User enter correct <password> and not <email>
    And User click on Login button
    Then User get email <error> message
    Examples:
      |email|password|error|
      ||Hgurjar731@|Email address can't be blank.|

  Scenario Outline: Check login functionality with incorrect email credentials
    Given User is on login page
    When User enter incorrect <email> and correct <password>
    And User click on Login button
    Then User get Incorrect <error> message

    Examples:
      |email|password|error|
      |harsh.gurjar1214@yopmail.com|Hgurjar731@|Incorrect username or password.|

  Scenario Outline: Check login functionality with incorrect password credentials
    Given User is on login page
    When User enter correct <email> and incorrect <password>
    And User click on Login button
    Then User get Incorrect <error> message

    Examples:
      |email|password|error|
      |harsh.gurjar1213@yopmail.com|Hgurjar732@|Incorrect username or password|

  Scenario Outline: Check login functionality with incorrect credentials
    Given User is on login page
    When User enter incorrect <email> and incorrect <password>
    And User click on Login button
    Then User get Incorrect <error> message

    Examples:
      |email|password|error|
      |harsh.gurjar1214@yopmail.com|Hgurjar732@|Incorrect username or password|

  Scenario Outline: Check login functionality with valid credentials
    Given User is on login page
    When User enter <email> and <password>
    And User click on Login button
    Then User is navigated to the residents screen with correct <email>

    Examples:
      |email|password|
      |harsh.gurjar1213@yopmail.com|Hgurjar731@|