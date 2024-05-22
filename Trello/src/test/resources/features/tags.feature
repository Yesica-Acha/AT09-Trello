@Tags
  Feature: Example for scenarios with tags

    @First @Smoke
    Scenario: This is the first scenario for tags
      Given this is the first step
      When this is the second step
      Then this is the third step

    @Second @Regression @Fail
    Scenario: This is the second scenario for tags
      Given this is the first step
      When this is the second step
      Then this is the third step
        And this step should fail