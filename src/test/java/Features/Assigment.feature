Feature: Create Account Login and Order
  @SeleniumTests
  Scenario:Create Account Login and Order
    Given User is on landing page "http://automationpractice.com/"
    Then Enter a Random Email
    And Create an Account with
    |Ozan|Karademir|Celiktepe mah|Istanbul|34413|5528604330|
    Then Sign out and Sign in current Account
    And Select Categories and Sub Categories
    Then Compare Prices and Add to Cart
    And Check Delivery and Invoice Adresses "Celiktepe mah"
    Then Set Shipping options
    And Payment Options and Order the Product
