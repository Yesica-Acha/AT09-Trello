package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TagSteps {
    @Given("this is the first step")
    public void thisIsTheFirstStep() {
        System.out.println("this is the first step");
    }

    @When("this is the second step")
    public void thisIsTheSecondStep() {
        System.out.println("this is the second step");
    }

    @Then("this is the third step")
    public void thisIsTheThirdStep() {
        System.out.println("this is the third step");
    }

    @And("this step should fail")
    public void thisStepShouldFail() {
        System.out.println("this step should fail");
        Assert.assertTrue(false);
    }
}
