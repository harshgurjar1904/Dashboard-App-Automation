#@OutletTest
Feature: feature to test product ordering from outlet
  @OutletTest
  Scenario: Check login functionality with valid credentials
    Given I am on login page
    When I am entering correct email and correct password
    And I click on Login button
    Then I am navigated to the residents screen
#  @OutletTest
#  @GoToMoreSection
  Scenario: I  want to order product without modifier and addon from an outlet
    Given I am on Outlet requests list  Screen
    When I tap on plus icon
    Then I am redirected to the Outlet requests screen
    When I select Unit if unit is not auto fetched
    And I select BookFor if book for is not auto fetched
    And I select BookFrom if book from is not auto fetched
    And I select Now schedule
    And I search the ProductName in searchbar
    Then I click on the searched product
    Then I select the ProductQuantity
    And I click on Add to Cart button
    Then Cart icon will visible, click on it
    Then I am redirected to the order cart screen tap on Checkout button
    Then I am redirected to the Request list screen
    When I click on the request
    Then I verify the order details

#  @OutletTest
#  @GoToMoreSection
#    @AllowPermission
  Scenario: I  want to order product with boolean modifier from an outlet
    Given I am on Outlet requests list  Screen
    When I tap on plus icon
    Then I am redirected to the Outlet requests screen
    When I select Unit if unit is not auto fetched
    And I select BookFor if book for is not auto fetched
    And I select BookFrom if book from is not auto fetched
    And I select Now schedule
    And I search the ProductName in searchbar
    Then I click on the searched product
    Then I select the ProductQuantity
    Then I select the Boolean Modifier
    And I click on Add to Cart button
    Then Cart icon will visible, click on it
    Then I am redirected to the order cart screen tap on Checkout button
    Then I am redirected to the Request list screen
    When I click on the request
    Then I verify the order details with modifier details

#  @OutletTest
#  @GoToMoreSection
#  @AllowPermission
  Scenario: I  want to order product with boolean addon from an outlet
    Given I am on Outlet requests list  Screen
    When I tap on plus icon
    Then I am redirected to the Outlet requests screen
    When I select Unit if unit is not auto fetched
    And I select BookFor if book for is not auto fetched
    And I select BookFrom if book from is not auto fetched
    And I select Now schedule
    And I search the ProductName in searchbar
    Then I click on the searched product
    Then I select the ProductQuantity
    Then I select the Boolean addon
    And I click on Add to Cart button
    Then Cart icon will visible, click on it
    Then I am redirected to the order cart screen tap on Checkout button
    Then I am redirected to the Request list screen
    When I click on the request
    Then I verify the order details with addon details

#  @OutletTest
#  @GoToMoreSection
#  @AllowPermission
  Scenario: I  want to order product with quantity modifier from an outlet
    Given I am on Outlet requests list  Screen
    When I tap on plus icon
    Then I am redirected to the Outlet requests screen
    When I select Unit if unit is not auto fetched
    And I select BookFor if book for is not auto fetched
    And I select BookFrom if book from is not auto fetched
    And I select Now schedule
    And I search the ProductName in searchbar
    Then I click on the searched product
    Then I select the ProductQuantity
    Then I select the Quantity Modifier
    And I click on Add to Cart button
    Then Cart icon will visible, click on it
    Then I am redirected to the order cart screen tap on Checkout button
    Then I am redirected to the Request list screen
    When I click on the request
    Then I verify the order details with modifier details

  @OutletTest
#  @GoToMoreSection
#  @AllowPermission
  Scenario: I  want to order product with quantity addon from an outlet
    Given I am on Outlet requests list  Screen
    When I tap on plus icon
    Then I am redirected to the Outlet requests screen
    When I select Unit if unit is not auto fetched
    And I select BookFor if book for is not auto fetched
    And I select BookFrom if book from is not auto fetched
    And I select Now schedule
    And I search the ProductName in searchbar
    Then I click on the searched product
    Then I select the ProductQuantity
    Then I select the Quantity addon
    And I click on Add to Cart button
    Then Cart icon will visible, click on it
    Then I am redirected to the order cart screen tap on Checkout button
    Then I am redirected to the Request list screen
    When I click on the request
    Then I verify the order details with addon details

  @OutletTest
  @GoToMoreSection
  @AllowPermission
  Scenario: I  want to order product with Quantity modifier and Quantity addon from an outlet
    Given I am on Outlet requests list  Screen
    When I tap on plus icon
    Then I am redirected to the Outlet requests screen
    When I select Unit if unit is not auto fetched
    And I select BookFor if book for is not auto fetched
    And I select BookFrom if book from is not auto fetched
    And I select Now schedule
    And I search the ProductName in searchbar
    Then I click on the searched product
    Then I select the ProductQuantity
    Then I select the Quantity Modifier
    Then I select the Quantity addon
    And I click on Add to Cart button
    Then Cart icon will visible, click on it
    Then I am redirected to the order cart screen tap on Checkout button
    Then I am redirected to the Request list screen
    When I click on the request
    Then I verify the order details with modifier and addon details