package cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksForTags {

    @Before(order = 1)
    public void beforeScenario() {
        System.out.println("This before runs for every scenario.");
    }

    @Before(value = "@First", order = 2)
    public void beforeFirstScenario() {
        System.out.println("This before runs only for the first scenario.");
    }

    @Before(value = "not @Regression", order = 3)
    public void beforeNotRegressionScenario() {
        System.out.println("This before runs only for the scenarios that don-t have @Regression tag.");
    }

    @After(value = "@Third and @Regression", order = 9999)
    public void afterThirdRegressionScenario() {
        System.out.println("This after runs only for the scenarios with @Third and @Regression tag.");
    }
}
