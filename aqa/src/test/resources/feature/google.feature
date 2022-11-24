Feature: generate and google random person

  Scenario Outline: : generate random male person
    Given a random "<gender>" person "person_01"
    When I print a user "person_01"
    Examples:
      | gender |
      | male   |
      | female |
