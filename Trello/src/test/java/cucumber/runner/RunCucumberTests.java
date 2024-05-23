package cucumber.runner;

import core.utils.ReportGenerator;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features"},
//        plugin = {"pretty"}, // Steps in console highlighted with colors
//        plugin = {"html:build/html_report/report.html"}, // Generates a html file with the test result
//        plugin = {"json:build/json_report/report.json"}, // Generates a json file with the test result
        plugin = {"json:build/cucumber/cucumber.json"}, // This plugin is necessary for the Report Generator
        glue = {"cucumber"},
//        tags = "@Tags or (@Login and not @Smoke)" // Use this tags to see different reports
        tags = "@Login" // Use this tag to test screenshot
)
public class RunCucumberTests extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void mainSetup() {
        System.out.println("This method will be executed only once at the beginning of the execution");
    }

    // Use this method to add screenshot to cucumber report
    @AfterSuite    public void generateReport() {
        ReportGenerator.generateReport();
    }


      // Use the block of code to run in parallel
    @BeforeTest
    public void setup() {
        System.setProperty("dataproviderthreadcount", "3");
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
