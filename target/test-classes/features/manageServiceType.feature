Feature: Verify the MRH application web page title

  @automated @sanity
  Scenario: Verify the MRH application web page title
    Given I launch the MRH application welcome page
    When I navigated to Manage Service Types page
    Then I get the all service list
      | DERMATOLOGY                    |
      | DERMATOLOGY_NEW_PATIENT        |
      | GENERAL_MEDICINE               |
      | GENERAL_MEDICINE_NEW_PATIENT   |
      | GYNECOLOGY                     |
      | GYNECOLOGY_NEW_PATIENT         |
      | INFECTIOUS_DISEASE             |
      | INFECTIOUS_DISEASE_NEW_PATIENT |
      | MENTAL_HEALTH                  |
      | MENTAL_HEALTH_NEW_PATIENT      |