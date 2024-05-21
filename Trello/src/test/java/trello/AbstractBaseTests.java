package trello;

import core.selenium.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class AbstractBaseTests {
    WebDriver driver;

    @BeforeTest
    public void setUp() {

        // Initialize driver
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://trello.com/login");
    }

    @AfterTest
    public void tearDown(){
        DriverManager.getInstance().quitDriver();
    }
}
