@UI
Feature: Login

  @Login
  Scenario: Login with valid credentials
    Given I am on the login page
    When I login with the following information:
      | User Email    | autotester248@gmail.com |
      | User Password | password                |
#    When I login with username "autotester248@gmail.com" and password "password"
    Then I should see "Automation Testing" in the top menu
      And I should see "autotester248@gmail.com" and "Automation Testing" in the account menu

  @Smoke
  Scenario Outline: Login with valid credentials (Scenario Outline)
    Given I am on the login page
    When I login with username "<User Email>" and password "<User Password>"
    Then I should see "<User Name>" in the top menu
      And I should see "<User Email>" and "<User Password>" in the account menu

    Examples:
      | User Email              | User Password | User Name          |
      | autotester248@gmail.com | password      | Automation Testing |

    @Fail
    Examples:
      | User Email              | User Password | User Name          |
      | autotester248@gmail.com | password1     | Automation Testing |