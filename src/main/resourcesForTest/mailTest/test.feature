Feature: Test mail.ru

   Scenario: Running a Test email
    Given I login as general_ks@mail.ru
    When I do login
    Then the button "Compose" should be visible