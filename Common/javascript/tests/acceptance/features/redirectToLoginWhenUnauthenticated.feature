Feature: As user I should not be able to access the plugin if I'm unauthenticated. I should be redirected
  # Enter feature description here

  Scenario:
      Given I'm on the home page
      When I navigate to the plugin
      Then I should be redirected to login