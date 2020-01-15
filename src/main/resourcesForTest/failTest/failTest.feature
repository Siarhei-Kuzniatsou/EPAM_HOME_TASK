Feature: Checking login

  I want to check that logIn works.

  Scenario Outline: login
    Given I go to Mail.ru
    When I login as general_ks@mail.ru with "<Password>"
    Then I "<can>" get button logout

    Examples:
    | Password | can |
    | 11111111 | no  |
    | g1020958G| yes |
    | 22       | no  |
