Feature: As user I want to be able to access the plugin

  Scenario:
      Given I'm on the home page
      And I'm NOT logged in
      When I navigate to the plugin
      Then I should be redirected to login

  Scenario:
    Given I'm on the home page
    And I'm logged in
    When I click on the Pipelines tab
    Then I should be navigated to the Pipelines plugin page