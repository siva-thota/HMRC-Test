@demo
Feature: HMRC Test Demo

  Scenario: Add the costly dress to cart
    Given I open the demo site
    Then I validate the page title "My Store"
    When I click on the "Dresses" menu
    Then I validate the page title "Dresses - My Store"
    When I add costly dress to cart
