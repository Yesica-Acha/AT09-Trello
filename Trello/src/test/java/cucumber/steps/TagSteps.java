package cucumber.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TagSteps {
    @Given("this is the First step")
    public void thisIsTheFirstStep() {
        System.out.println("This is the first step");
    }

    @When("this is the Second step")
    public void thisIsTheSecondStep() {
        System.out.println("This is the second step");
    }

    @Then("this is the Third step")
    public void thisIsTheThirdStep() {
        System.out.println("This is the third step");
    }

    @Then("this step should fail")
    public void thisStepShouldFail() {
        Assert.assertTrue(false);
    }

    @Then("this step is pending")
    public void thisStepIsPending() throws PendingException {
        throw new PendingException();
    }

    @Then("this step should be skipped")
    public void thisStepShouldBeSkipped() {

    }
}
