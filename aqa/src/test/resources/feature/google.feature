Feature: generate and google random person

  Scenario Outline: : generate random male person
    Given a random "<gender>" person "person_01"
    When I load "GOOGLE" page
    When google for "person_01"
    Then Person "person_01" is present in searchResults
    Examples:
      | gender |
      | male   |
      | female |
