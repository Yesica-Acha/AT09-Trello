@Board @UI
  Feature: Board

    Background:
      Given I am logged in with valid user credentials

    Scenario: Create Board from top menu
      When I open Board Creation form from the top menu
        And I create a board with title "My test board"
      Then the board title "My test board" should be displayed in the board page

#    Scenario: Create Board from context
#      When I open Board Creation form from the context
#      And I create a board with title "My test board"
#      Then the board title "My test board" should be displayed in the board page