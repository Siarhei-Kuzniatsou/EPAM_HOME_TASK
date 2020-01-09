Feature: Test mail.ru

   Scenario: Sent new letter
    Given I login as general_ks@mail.ru
    When I do login
    Then the button "Compose" should be visible

    Given I click button Compose and fill fields To, Subject and Body
    When I save letter as draft
    Then new letter can be into drafts and has all fields filling

    Given Sent letter of Drafts
    When Go to Drafts, check letter and send
    Then letter can be into Sent folder

    Given LogOut
    When Click button logOut
    Then Button Login can be visible