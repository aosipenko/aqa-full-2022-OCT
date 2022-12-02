Feature: generate and google random person

  Scenario: generate random male person
    Given Create user with id 10 and name "Anna"
    Given Get user with id "10"
    Then clean up user 10
