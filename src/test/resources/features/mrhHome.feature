Feature: Verify the MRH application web page title

  @automated @Feature @sanity
  Scenario: Verify the MRH application web page title
    Given I launch the MRH application welcome page
    When I find the MRH application web title
    Then I match the web title successfully