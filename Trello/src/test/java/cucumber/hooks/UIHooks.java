package cucumber.hooks;

import core.selenium.DriverFactory;
import core.selenium.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UIHooks {

//    private WebDriver driver = DriverManager.getInstance().getDriver();

    private WebDriver driver = DriverFactory.getDriver();

    @After(value = "@UI", order = 1)
    public void tearDown() {
        System.out.println("Quit driver.....");

        // Quit browser
//        DriverManager.getInstance().quitDriver();
        driver.quit();
    }

    /**
     * After method to add screenshot to failed scenarios
     * @param scenario
     */
    @After(value = "@UI", order = 9999)
    public void takeScreenshotIfFails(Scenario scenario) {
        if (scenario.isFailed()) {

            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // Embed it in the report.
            scenario.attach(screenshot, "image/png", scenario.getName() + " failed");
        }
    }
}
