package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty"},
        glue = {"cucumber"},
        tags = "@Board"
)
public class RunCucumberTests extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void mainSetup() {
        System.out.println("*************");
    }
}
