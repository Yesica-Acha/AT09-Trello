package core.selenium;

import core.Environment;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class SharedDriver {

    public SharedDriver() {
        WebDriver driverSession = DriverFactory.getDriver();
        if (driverSession == null || ((RemoteWebDriver) driverSession).getSessionId() == null) {
            WebDriver driver = BrowserFactory.getBrowser(Environment.getInstance().getValue("browser"));

            // Maximize the window
            driver.manage().window().setPosition(new Point(1529, -400));
            driver.manage().window().maximize();

            DriverFactory.addDriver(driver);
        }
    }
}
