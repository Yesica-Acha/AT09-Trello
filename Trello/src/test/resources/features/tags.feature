@Tags
Feature: Example for scenarios with tags

  @First @Smoke @CreateBoard
  Scenario: This is the first example for tags (PASS)
    Given this is the First step
    When this is the Second step
    Then this is the Third step

  @Second @Regression @DeleteBoard
  Scenario: This is the second example for tags (FAIL)
    Given this is the First step
    When this is the Second step
    Then this is the Third step
    And this step should fail
    And this step should be skipped

  @Third @Regression @Negative @Smoke
  Scenario: This is the third example for tags (NOT IMPLEMENTED)
    Given this is the First step
    When this is the Second step
    Then this is the Third step
    And this step is not implemented

  @Fourth @Smoke
  Scenario: This is the fourth example for tags (PENDING)
    Given this is the First step
    When this is the Second step
    Then this is the Third step
    And this step is pending


  Scenario Outline: This is the <case> scenario
    Given this is the First step
    When this is the Second step
    Then this is the Third step

    @Fast
    Examples:
      | case   |
      | fourth |

    @Low @Bug
    Examples:
      | case   |
      | fifth  |
