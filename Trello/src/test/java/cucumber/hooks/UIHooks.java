package cucumber.hooks;

import core.selenium.DriverManager;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class UIHooks {

    private WebDriver driver = DriverManager.getInstance().getDriver();

    @After(value = "@UI", order = 1)
    public void tearDown() {
        System.out.println("Quit driver.....");
        driver.quit();
    }
}
