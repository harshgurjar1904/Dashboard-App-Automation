Feature: feature to test requesting a service from portal app
  @ServiceTest
  Scenario: Check login functionality with valid credentials
    Given I am on login page
    When I am entering correct email and correct password
    And I click on Login button
    Then I am navigated to the residents screen

#  @ServiceTest
  Scenario: I  want to request a service from request only service which is Boolean type addon without price
    Given I am on Service requests list  Screen
    When I tap on the add service button
    Then I am redirected to New Service Request Screen
    When I select Unit No if unit is not auto fetched
    And I select Resident Name in BookFor if  not auto fetched
    And I select Service Name
    Then I can see the addon section
    When I select the addon
    And I tap on the Save button
    Then I can see request is created successfully
    When I tap on created request
    Then I can verify request details with addon

#  @ServiceTest
  Scenario: I  want to request a service from request only service which is Boolean type addon  with price
    Given I am on Service requests list  Screen
    When I tap on the add service button
    Then I am redirected to New Service Request Screen
    When I select Unit No if unit is not auto fetched
    And I select Resident Name in BookFor if  not auto fetched
    And I select Service Name
    Then I can see the addon section
    When I select the addon
    And I tap on the Save button
    Then I can see request is created successfully
    When I tap on created request
    Then I can verify request details with addon

#  @ServiceTest
  Scenario: I  want to request a service from request only service which is Quantity type addon  without  price
    Given I am on Service requests list  Screen
    When I tap on the add service button
    Then I am redirected to New Service Request Screen
    When I select Unit No if unit is not auto fetched
    And I select Resident Name in BookFor if  not auto fetched
    And I select Service Name
    Then I can see the addon section
    When I select the addon
    And I can increase the quantity of addon
    And I tap on the Save button
    Then I can see request is created successfully
    When I tap on created request
    Then I can verify request details with addon

#  @ServiceTest
  Scenario: I  want to request a service from request only service which is Quantity type addon  with  price
    Given I am on Service requests list  Screen
    When I tap on the add service button
    Then I am redirected to New Service Request Screen
    When I select Unit No if unit is not auto fetched
    And I select Resident Name in BookFor if  not auto fetched
    And I select Service Name
    Then I can see the addon section
    When I select the addon
    And I can increase the quantity of addon
    And I tap on the Save button
    Then I can see request is created successfully
    When I tap on created request
    Then I can verify request details with addon

#    @ServiceTest
  Scenario: I  want to request a service from request only service which is addon type without addons and with preferences
    Given I am on Service requests list  Screen
    When I tap on the add service button
    Then I am redirected to New Service Request Screen
    When I select Unit No if unit is not auto fetched
    And I select Resident Name in BookFor if  not auto fetched
    And I select Service Name
    Then I can see the Preferences section
    When I select the single select preference
    And I tap on the Save button
    Then I can see request is created successfully
    When I tap on created request
    Then I can verify request details with package

#  @ServiceTest
#  @GoToMoreSection
  Scenario: I  want to request a service from request only service which is Package type
    Given I am on Service requests list  Screen
    When I tap on the add service button
    Then I am redirected to New Service Request Screen
    When I select Unit No if unit is not auto fetched
    And I select Resident Name in BookFor if  not auto fetched
    And I select Service Name
    Then I can see the Packages section
    When I select the package
    And I tap on the Save button
    Then I can see request is created successfully
    When I tap on created request
    Then I can verify request details with package

#  @ServiceTest
  Scenario: I  want to request a service from request only service in which special entity is pet
    Given I am on Service requests list  Screen
    When I tap on the add service button
    Then I am redirected to New Service Request Screen
    When I select Unit No if unit is not auto fetched
    And I select Resident Name in BookFor if  not auto fetched
    And I select Service Name
    And I select pet
    When I select the package
    And I tap on the Save button
    Then I can see request is created successfully
    When I tap on created request
    Then I can verify request details with addon

#  @ServiceTest
  Scenario: I  want to request a service from request only service in which special entity is pet and select multiple package
    Given I am on Service requests list  Screen
    When I tap on the add service button
    Then I am redirected to New Service Request Screen
    When I select Unit No if unit is not auto fetched
    And I select Resident Name in BookFor if  not auto fetched
    And I select Service Name
    And I select pet
    When I select the package
    And I select one more package
    And I tap on the Save button
    Then I can see request is created successfully
    When I tap on created request
    Then I can verify request details with addon

#  @ServiceTest
  Scenario: I  want to request a service from request only service which is Boolean type addon without price with "Allow future Booking" toggle enabled.
    Given I am on Service requests list  Screen
    When I tap on the add service button
    Then I am redirected to New Service Request Screen
    When I select Unit No if unit is not auto fetched
    And I select Resident Name in BookFor if  not auto fetched
    And I select Service Name
    Then I can see the addon section
    When I select the addon
    And I select the future date
    And I tap on the Save button
    Then I can see request is created successfully
    When I tap on created request
    Then I can verify request details with addon

  @ServiceTest
  Scenario: I  want to request a service from request only service which is Boolean type addon without price with "Allow future Booking" and "Allow Preferred Request Time" toggle enabled.
    Given I am on Service requests list  Screen
    When I tap on the add service button
    Then I am redirected to New Service Request Screen
    When I select Unit No if unit is not auto fetched
    And I select Resident Name in BookFor if  not auto fetched
    And I select Service Name
    Then I can see the addon section
    When I select the addon
    And I select the future date
    And I select the preferred time
    And I tap on the Save button
    Then I can see request is created successfully
    When I tap on created request
    Then I can verify request details with addon


