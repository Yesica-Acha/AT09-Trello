package trello.ui;

import core.Environment;
import core.selenium.DriverFactory;
import core.selenium.DriverManager;
import core.selenium.WebDriverActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected WebDriverActions action;

    public AbstractBasePage() {
//        this.driver = DriverManager.getInstance().getDriver();
//        this.wait = DriverManager.getInstance().getWait();

        this.driver = DriverFactory.getDriver();

        // Set implicit Wait
        int implicitTime = Integer.parseInt(Environment.getInstance().getValue("implicit_time"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTime));

        // Set explicit Time
        int explicitTime = Integer.parseInt(Environment.getInstance().getValue("explicit_time"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(explicitTime));

        // Initialize WebDriverActions
        this.action = new WebDriverActions(driver, wait);

        // Initialize Selenium Page Factory
        PageFactory.initElements(driver, this);
    }
}
